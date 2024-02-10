<template>
  <b-modal id="role" title="Cambiar mi rol" hide-footer centered>
    <b-container fluid>
      <b-row class="mb-4">
        <b-col>
          <b-button
            variant="primary"
            block
            size="lg"
            class="custom-button-role"
            :class="{ 'active-button': activeButton === 'cliente' }"
            @click="changeRole('cliente')"
          >
            <b-icon icon="cart-fill" size="lg" class="text-dark"></b-icon>
            Cliente
          </b-button>
        </b-col>
        <b-col>
          <b-button
            variant="secondary"
            block
            size="lg"
            class="custom-button-role"
            :class="{ 'active-button': activeButton === 'vendedor' }"
            @click="changeRole('vendedor')"
          >
            <b-icon icon="bag-fill" size="lg" class="text-dark"></b-icon>
            Vendedor
          </b-button>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <p class="custom-p">Cambiar tu rol cerrará tu sesión actual</p>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-button class="custom-button" block @click="updateRole"
            >Actualizar rol</b-button
          >
        </b-col>
      </b-row>
    </b-container>
  </b-modal>
</template>

<script lang="ts">
import Vue from "vue";
import Swal from "sweetalert2";

export default Vue.extend({
  name: "role",
  data() {
    return {
      recover: {
        email: "",
      },
      activeButton: "",
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
    changeRole(role: string) {
      console.log(`Cambiar a rol: ${role}`);
      this.activeButton = role;
    },
    updateRole() {
      console.log("Actualizar rol");
    },
  },
});
</script>

<style>
.custom-p {
  text-align: center;
}

.custom-button-role {
  height: 5cm;
  color: black !important;
  background-color: white !important;
}

.custom-button-role.active-button {
  background-color: #f8f9fa !important;
}
</style>
