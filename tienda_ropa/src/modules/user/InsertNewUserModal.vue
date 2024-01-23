<template>
    <b-modal id="insertNewUser" title="Registrar cuenta" hide-footer centered>
        <b-container fluid>
          <b-row>
            <b-col>
              <b-form>
                <b-row>
                  <b-col>
                    <b-form-group label="Nombre" label-for="name">
                      <b-form-input id="name" v-model="persona.name" type="text" placeholder="Ingrese su nombre" required></b-form-input>
                    </b-form-group>
                  </b-col>
                </b-row>
                <b-row>
                  <b-col>
                    <b-form-group label="Correo electrónico" label-for="email">
                      <b-form-input id="email" v-model="persona.email" type="email" placeholder="Ingrese su correo electrónico" required></b-form-input>
                    </b-form-group>
                  </b-col>
                </b-row>
                <b-row>
                  <b-col>
                    <b-form-group label="Contraseña" label-for="password">
                      <b-form-input id="password" v-model="persona.password" type="password" placeholder="Ingrese su contraseña" required></b-form-input>
                    </b-form-group>
                  </b-col>
                </b-row>
                <b-row>
                  <b-col>
                    <b-form-group label="Confirmar contraseña" label-for="password_confirmation">
                      <b-form-input id="password_confirmation" v-model="persona.password_confirmation" type="password" placeholder="Confirme su contraseña" required></b-form-input>
                    </b-form-group>
                  </b-col>
                </b-row>
                <b-row>
                  <b-col>
                    <b-form-group label="Rol" label-for="role">
                      <b-form-select id="role" v-model="persona.role" :options="roles" required></b-form-select>
                    </b-form-group>
                  </b-col>
                </b-row>

                <b-row>
                  <b-col class="text-right">
                    <b-button type="submit" variant="outline-dark">Registrar</b-button>
                  </b-col>
                </b-row>
              </b-form>
            </b-col>
          </b-row>
        </b-container>
    </b-modal>
</template>


<script lang="ts">
import Vue from 'vue'

export default Vue.extend({
  name: 'InsertNewUser',
  data() {
    return {
      persona: {
        name: '',
        email: '',
        password: '',
        password_confirmation: '',
        role: '',
      },
      roles: ['Administrador', 'Vendedor', 'Comprador'],
    }
  },
})
</script>