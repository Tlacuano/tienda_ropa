<template>
  <b-modal
    id="recoverPassword"
    title="¿Olvidaste tu contraseña?"
    hide-footer
    centered
  >
    <b-container fluid>
      <b-row>
        <p class="custom-p">
          Ingresa la dirección de correo electrónico que utilizaste para
          registrarte, recibirás un enlace para restablecer tu contraseña
        </p>
      </b-row>
      <b-row>
        <b-col>
          <b-form @submit.prevent="sendEmail">
            <b-form-group>
              <b-form-input
                id="email"
                v-model="recover.email"
                type="email"
                placeholder="Correo electrónico"
                required
              >
              </b-form-input>
            </b-form-group>
            <b-button type="submit" class="custom-button" block
              >Enviar</b-button
            >
          </b-form>
        </b-col>
      </b-row>
    </b-container>
  </b-modal>
</template>

<script lang="ts">
import Vue from "vue";
import Swal from "sweetalert2";

export default Vue.extend({
  name: "recoverPassword",
  data() {
    return {
      recover: {
        email: "",
      },
    };
  },
  methods: {
    sendEmail() {
      console.log("Correo enviado a " + this.recover.email);
      Swal.fire({
        title: "Correo enviado",
        html: `<div style="text-align: justify;"> Se ha enviado un correo a ${this.recover.email}. Por favor, revisa tu bandeja de entrada y sigue las instrucciones para restablecer tu contraseña.</div>`,
        icon: "success",
        confirmButtonText: "Aceptar",
      });
    },
  },
});
</script>

<style>
.custom-p {
  text-align: center;
}
.custom-button {
  background-color: #353942;
}
</style>
