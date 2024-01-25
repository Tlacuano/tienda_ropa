<template>
    <b-modal id="insertNewUser" title="Crear cuenta" hide-footer centered size="lg">
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

                  <b-col>
                    <b-form-group label="Primer apellido" label-for="lastname">
                      <b-form-input id="lastname" v-model="persona.lastname" type="text" placeholder="Ingrese su apellido" required></b-form-input>
                    </b-form-group>
                  </b-col>

                  <b-col>
                    <b-form-group label="Segundo apellido" label-for="secondLastname">
                      <b-form-input id="secondLastname" v-model="persona.secondLastname" type="text" placeholder="Ingrese su segundo apellido" required></b-form-input>
                    </b-form-group>
                  </b-col>
                </b-row>
                
                <b-row>
                  <b-col>
                    <b-form-group label="Fecha de nacimiento" label-for="birthday">
                      <b-calendar :max="new Date()" id="birthday" v-model="persona.birthday" placeholder="Ingrese su fecha de nacimiento" required></b-calendar>
                    </b-form-group>
                  </b-col>

                  <b-col>
                    <b-row class="m-0">
                      <b-form-group label="Foto de perfil" label-for="picture">
                        <b-form-file id="picture" @change="handleImageChange($event)" type="file" placeholder="Ingrese su foto" required></b-form-file>
                      </b-form-group>
                    </b-row>

                    <b-row>
                      <b-col class="text-center">
                        <b-img style="max-width: 80%;" v-if="persona.picture" :src="persona.picture" fluid alt="Fluid image"></b-img>
                      </b-col>
                    </b-row>
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

                <hr>
                <b-row>
                  <b-col class="text-right">
                    <b-button type="submit" variant="dark">Registrar</b-button>
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
        lastname: '',
        secondLastname: '',
        birthday: '',
        picture: null as any,
        email: '',
        password: '',
        password_confirmation: '',
        role: '',
      },
      roles: ['Administrador', 'Vendedor', 'Comprador'],
    }
  },
  methods: {
    async handleImageChange(event: any) {
      const fileInput = event.target
      const file = fileInput.files[0]

      if (file) {
        const reader = new FileReader()
        reader.onload = (e: any) => {
          this.persona.picture = e.target.result
        }
        reader.readAsDataURL(file)
      }
    },
  },
})
</script>