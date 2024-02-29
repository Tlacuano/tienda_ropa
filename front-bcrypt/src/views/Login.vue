<template>
  <b-container fluid class="body">
    <b-row class="card">
        <b-col class="card2">
          <b-form @submit.prevent="submitLogin" v-if="!submitted" class="form">
            <h3 id="heading">Login</h3>
            <b-form-group class="field">
              <b-form-input id="email" type="email" v-model="credentials.email" placeholder="Correo electrónico"
                class="input-field" required>
              </b-form-input>
            </b-form-group>
            <b-form-group class="field">
              <b-form-input id="password" type="password" v-model="credentials.password" placeholder="Contraseña"
                class="input-field" required>
              </b-form-input>
            </b-form-group>
            <b-button type="submit" class="custom-button" block>Iniciar sesión</b-button>
          </b-form>
          <!-- <div v-if="submited && errorMessage" class="text-danger">{errorMessage}</div>-->
        </b-col>
    </b-row>
  </b-container>
</template>
<script>
import forge from 'node-forge'
import Swal from 'sweetalert2'
import axios from "axios";

export default {

  data() {
    return {
      credentials: {
        email: '',
        password: '',
      },
      errorMessage: '',
      submitted: false,
    };
  },
  methods: {

    async submitLogin() {

      const email = this.credentials.email;
      const password = this.credentials.password;
      const jsonObject = {email,password};
      const jsonString = JSON.stringify(jsonObject)
      const secretKey = 'el@ConGr3z041!12'
      console.log(secretKey)
      if(!secretKey){
        throw new Error('La clave secreta no existe padre')
      }

      // Crear un objeto cipher utilizando la clave secreta
      const cipher = forge.cipher.createCipher('AES-CBC', secretKey);

      // Generar un IV (Initialization Vector) aleatorio
      const iv = forge.random.getBytesSync(16);

      // Actualizar el objeto cipher con el IV
      cipher.start({ iv });

      // Encriptar la cadena JSON
      cipher.update(forge.util.createBuffer(jsonString, 'utf8'));
      cipher.finish();
      const encryptedData = forge.util.encode64(iv+cipher.output.getBytes())
      const dataPost = encryptedData
      console.log(encryptedData)
      try {
        const response = await axios.post('http://localhost:8080/api/auth', dataPost);

        // Obtener el IV (Initialization Vector) y los datos encriptados de la respuesta
        const iv = forge.util.decode64(response.data.iv);
        const encryptedData = forge.util.decode64(response.data.encryptedData);

        // Crear un objeto decipher utilizando la clave secreta y el IV
        const decipher = forge.cipher.createDecipher('AES-CBC', secretKey);
        decipher.start({iv});

        // Actualizar el objeto decipher con los datos encriptados
        decipher.update(forge.util.createBuffer(encryptedData));

        // Finalizar el proceso de descifrado
        decipher.finish();
        // Obtener los datos desencriptados como una cadena
        const decryptedDataString = decipher.output.toString();

        // Convertir los datos desencriptados a un objeto JSON
        const decryptedDataObject = JSON.parse(decryptedDataString);

        // Manejar los datos desencriptados según sea necesario
        console.log('Datos desencriptados:', decryptedDataObject.data);
        if (decryptedDataObject) {
          await Swal.fire({
            title: '¡Bienvenido!',
            text: `Has ingresado como ${decryptedDataObject}`,
            icon: 'success'
          });
        }
        // Manejar la respuesta de la API
      } catch (error) {
        await Swal.fire({
          title:'¡Error!',
          text:"Acceso denegado",
          icon:"error"
        })
        // Manejar los errores
      }
    },
  }
}

</script>
<style>
#heading {
  text-align: center;
  margin: 2em;
  color: rgb(255, 255, 255);
  font-size: 1.2em;
}

.input-field{
  margin-top: 10px;
}

.body {
  background-color: #353942;
  padding: 100px;
}

.card {
  margin: auto;
  width: 400px;
  height: 350px;
  background-image: linear-gradient(163deg, #00ff75 0%, #3700ff 100%);
  border-radius: 22px;
  transition: all 0.3s;
}

.card2 {
  width: 400px;
  height: 350px;
  border-radius: 0;
  transition: all 0.2s;
}

.card2:hover {
  transform: scale(0.98);
  border-radius: 20px;
}

.card:hover {
  box-shadow: 0px 0px 30px 1px rgba(0, 255, 117, 0.3);
}

.form {
  display: flex;
  width: 375px;
  height: 345px;
  margin-top: 2px;
  flex-direction: column;
  gap: 10px;
  padding-left: 2em;
  padding-right: 2em;
  padding-bottom: 0.4em;
  background-color: #171717;
  border-radius: 25px;
  transition: 0.4s ease-in-out;
}

.body-login {
  margin: auto;
  border-color: #353942;

}

.body {
  width: 100%;
  height: 100vh;
}

.custom-button {
  margin-top: 10px;
  background-color: #353942;
}</style>