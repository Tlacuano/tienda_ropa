<template>
  <b-modal id="login" title="Iniciar sesión" hide-footer centered>
    <b-container fluid>
      <b-row>
        <b-col>
          <b-form>
            <b-form-group>
              <b-form-input
                id="email"
                v-model="credentials.email"
                type="email"
                placeholder="Correo electrónico"
                required
              >
              </b-form-input>
            </b-form-group>
            <b-form-group>
              <b-form-input
                id="password"
                v-model="credentials.password"
                type="password"
                placeholder="Contraseña"
                required
              >
              </b-form-input>
            </b-form-group>
            <b-form-group class="custom-form-group">
              <b-link @click="forgotPassword" class="custom-link"
                >¿Haz olvidado tu contraseña?</b-link
              >
            </b-form-group>
            <b-button type="submit" class="custom-button" block
              >Iniciar sesión</b-button
            >
          </b-form>
        </b-col>
      </b-row>
      <b-row class="mt-2 custom-form-group">
        <b-col>
          ¿No tienes una cuenta?
          <b-link @click="redirectSignUp" class="custom-link">
            <strong>Registrate</strong>
          </b-link>
        </b-col>
      </b-row>

      <RecoverPassword />
      <CreateAccount />
    </b-container>
  </b-modal>
</template>
<script lang="ts">
import Vue from "vue";

export default Vue.extend({
  name: "Login",
  components: {
    RecoverPassword: () => import("./RecoverPasswordModal.vue"),
    CreateAccount: () => import("./CreateAccountModal.vue"),
  },
  data() {
    return {
      credentials: {
        email: "",
        password: "",
      },
    };
  },
  methods: {
    forgotPassword() {
      this.$root.$emit("bv::toggle::modal", "recoverPassword");
    },
    redirectSignUp() {
      this.$root.$emit("bv::toggle::modal", "createAccount");
    },
  },
});
</script>
<style>
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
