<template>
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
    </b-container>
</template>
<script>

</script>
<style>

</style>