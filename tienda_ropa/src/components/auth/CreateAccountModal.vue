<template>
    <b-modal id="createAccount" title="Crear cuenta" hide-footer centered>
      <b-container fluid>
        <b-form>
          <b-form-group label="Correo electrónico" laber-for="email">
            <b-form-input
              id="email"
              v-model="use.email"
              type="email"
              placeholder="Ingrese un correo electrónico"
              required
            >
            </b-form-input>
          </b-form-group>
          <b-form-group label="Contraseña" laber-for="password">
            <b-form-input
              id="password"
              v-model="use.password"
              type="password"
              placeholder="Ingrese una contraseña"
              required
            >
            </b-form-input>
            <div class="password-requirements">
              Mínimo 8 caracteres incluyendo minúscula, mayúscula y un número. No
              repitas el mismo carácter más de 3 veces
            </div>
          </b-form-group>
          <b-form-group label="Fecha de Nacimiento" label-for="birthdate">
            <b-form-input
              id="birthdate"
              v-model="use.birthdate"
              type="date"
              required
            ></b-form-input>
            <div class="password-requirements custom-top">
              La fecha de nacimiento debe indicar que eres mayor de 18 años
            </div>
          </b-form-group>
          <b-button variant="dark" block>Crear cuenta</b-button>
        </b-form>
      </b-container>
    </b-modal>
  </template>
  <script lang="ts">
  import Vue from "vue";
  export default Vue.extend({
    name: "CreateAccount",
    data() {
      return {
        use: {
          email: "",
          password: "",
          birthdate: "",
        },
      };
    },
  });
  </script>
  <style>
  .password-requirements {
    font-size: 0.8em;
    color: #888;
    margin-top: 2px;
  }
  
  .custom-top {
    margin-bottom: 25px;
  }
  </style>
  