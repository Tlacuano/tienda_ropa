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
import CryptoJS from 'crypto-js'
import Swal from 'sweetalert2'
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
    encryptData(data) {
      const secretKey = import.meta.env.VUE_APP_SECRET_KEY;
      const key = CryptoJS.enc.Utf8.parse(secretKey);
      const iv = CryptoJS.lib.WordArray.random(128 / 8);
      const encrypted = CryptoJS.AES.encrypt(data, key, {
        iv: iv,
        mode: CryptoJS.mode.CBC,
        padding: CryptoJS.pad.Pkcs7
      });
      const encryptedDataWithIv = iv.toString(CryptoJS.enc.Hex) + encrypted.ciphertext.toString(CryptoJS.enc.Hex);
      return CryptoJS.enc.Base64.stringify(CryptoJS.enc.Hex.parse(encryptedDataWithIv));
    },
    decrypt(encryptedDataWithIv, secretKey) {
      var bytes = CryptoJS.enc.Base64.parse(encryptedDataWithIv);

      // Extraer IV (los primeros 16 bytes)
      var iv = CryptoJS.lib.WordArray.create(bytes.words.slice(0, 4));
      var encryptedData = CryptoJS.lib.WordArray.create(bytes.words.slice(4));

      var key = CryptoJS.enc.Utf8.parse(secretKey);
      var decrypted = CryptoJS.AES.decrypt({ ciphertext: encryptedData }, key, {
        iv: iv,
        mode: CryptoJS.mode.CBC,
        padding: CryptoJS.pad.Pkcs7
      });

      return decrypted.toString(CryptoJS.enc.Utf8);
    },
    async postData(userData) {
      try {
        const response = await axios.post('http://localhost:8080/api/auth', userData)
        let usernameDecrypt = this.decrypt(response.data.username, response.data.secretKey)
        if (usernameDecrypt) {
          await Swal.fire({
            title: '¡Bienvenido!',
            text: `Has ingresado como ${usernameDecrypt}`,
            icon: 'success'
          });
        }
      } catch (error) {
        await Swal.fire({
          title: 'Error',
          text: 'No se pudo realizar el ingreso. Por favor, intenta de nuevo.',
          icon: 'error'
        });
      }
    },
    async submitLogin() {
      //if (this.validateFields()) {


      const encryptedEmail = this.encryptData(this.credentials.email);
      const encryptedPassword = this.encryptData(this.credentials.password);


      console.log('Encrypted Email:', encryptedEmail);
      console.log('Encrypted Password:', encryptedPassword);
      const userData = {
        email: encryptedEmail,
        password: encryptedPassword
      };
      this.postData(userData);
      //}
    },
    /*
    validateFields() {
      const emailValid = this.isValidEmail(this.credentials.email);
      const passwordValid = this.credentials.password.length >= 6;
      return emailValid && passwordValid;
    },
    */
  }
  /*
    getEmailState() {
    if (!this.credentials.email) return null;
    return this.isValidEmail(this.credentials.email) ? true : false
  },
  getPasswordState() {
    if (!this.credentials.password) return null;
    return this.credentials.password.length >= 6 ? true : false;
  },
  isValidEmail(email) {
    return /\S+@\S+\.\S+/.test(email);
  }
},*/
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