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
            <b-form>
              <b-form-group label="Correo electrónico" laber-for="email">
                <b-form-input
                  id="email"
                  v-model="recover.email"
                  type="email"
                  placeholder="Ingrese su correo electrónico"
                  required
                >
                </b-form-input>
              </b-form-group>
              <b-button type="submit" variant="dark" block>Enviar</b-button>
            </b-form>
          </b-col>
        </b-row>
      </b-container>
    </b-modal>
  </template>
  <script lang="ts">
  import Vue from "vue";
  export default Vue.extend({
    name: "recoverPassword",
    data() {
      return {
        recover: {
          email: "",
        },
      };
    },
    methods: {},
  });
  </script>
  <style>
  .custom-p {
    text-align: center;
  }
  </style>
  