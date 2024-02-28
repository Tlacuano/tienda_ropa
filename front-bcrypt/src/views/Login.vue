<template>
  <b-container fluid>
    <b-row class="body">
      <b-col class="body-login">
        <b-form @submit.prevent="submitLogin" v-if="!submitted">
          <b-form-group :state="getEmailState()">
            <b-form-input id="email" type="email" v-model="credentials.email" placeholder="Correo electrónico" required>
            </b-form-input>
          </b-form-group>
          <b-form-group :state="getPasswordState()">
            <b-form-input id="password" type="password" v-model="credentials.password" placeholder="Contraseña" required>
            </b-form-input>
          </b-form-group>
          <b-button type="submit" class="custom-button" block>Iniciar sesión</b-button>
        </b-form>
        <div v-if="submited && errorMessage" class="text-danger">{errorMessage}</div>
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
        const response = await axios.post('', userData)
        let usernameDecrypt = this.decrypt(response.data.username,response.data.secretKey)
        if(usernameDecrypt){
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
      const encryptedEmail = this.encryptData(this.credentials.email);
      const encryptedPassword = this.encryptData(this.credentials.password);

      
      console.log('Encrypted Email:', encryptedEmail);
      console.log('Encrypted Password:', encryptedPassword);
      const userData = {
        email: encryptedEmail,
        password: encryptedPassword
      };
      this.postData(userData);
    },

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
  },
}

</script>
<style>

.body-login{
  margin: auto;
  border-color:#353942;
  width: 10px;
}
.body{
  width: 100%;
  height: 100vh;
}
.custom-form-group {
  text-align: center;
}

.custom-link {
  color: black;
}

.custom-button {
  background-color: #353942;
}
</style>