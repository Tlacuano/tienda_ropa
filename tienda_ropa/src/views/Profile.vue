<template>
    <div>
        <b-container fluid>
            <b-row class="mt-4">
                <b-col id="tittle">
                    <h1>Perfil</h1>
                </b-col>
            </b-row>
            <b-row id="information" class="mt-4">
                <b-col class="align-items-center">
                    <b-card>
                        <b-row>
                            <b-col>
                                <b-card-text>
                                    <b-card-title>Información Personal</b-card-title>
                                    <b-row>
                                        <b-col cols="12" md="6">
                                            <b-form-group label="Nombre">
                                                <b-form-input v-model="user.name" :disabled="!editMode"></b-form-input>
                                            </b-form-group>
                                        </b-col>
                                        <b-col cols="12" md="6">
                                            <b-form-group label="Apellidos">
                                                <b-form-input v-model="user.surname" :disabled="!editMode"></b-form-input>
                                            </b-form-group>
                                        </b-col>
                                    </b-row>
                                    <b-row>
                                        <b-col cols="12" md="6">
                                            <b-form-group label="Email">
                                                <b-form-input v-model="user.email" :disabled="!editMode"></b-form-input>
                                            </b-form-group>
                                        </b-col>
                                        <b-col cols="12" md="6">
                                            <b-form-group label="Contraseña">
                                                <div class="input-group">
                                                    <b-input v-model="user.password"
                                                        :type="showPassword ? 'text' : 'password'" :disabled="!editMode"
                                                        class="mr-2"></b-input>
                                                    <b-button @click="togglePasswordVisibility" variant="light">
                                                        <b-icon
                                                            :icon="showPassword ? 'eye-slash-fill' : 'eye-fill'"></b-icon>
                                                    </b-button>
                                                </div>
                                            </b-form-group>
                                        </b-col>

                                    </b-row>

                                    <b-row>
                                        <b-col cols="12" md="6">
                                            <b-form-group label="Fecha de nacimiento">
                                                <b-form-input type="date" v-model="user.birthdate"
                                                    :disabled="!editMode"></b-form-input>
                                            </b-form-group>
                                        </b-col>

                                        <b-col cols="12" md="6">
                                            <b-form-group label="Teléfono">
                                                <b-form-input v-model="user.phone" :disabled="!editMode"></b-form-input>
                                            </b-form-group>
                                        </b-col>
                                    </b-row>
                                </b-card-text>
                            </b-col>
                            <b-col>
                                <b-form-group id="picture" label="Foto de Perfil">
                                    <div class="profile-image-container" @mouseover="showFileInput = true"
                                        @mouseleave="showFileInput = false">
                                        <b-img v-if="user.profileImage" :src="user.profileImage" fluid thumbnail
                                            alt="Foto de Perfil"></b-img>
                                        <input type="file" v-if="showFileInput" @change="handleFileChange"
                                            accept="image/*" />
                                    </div>
                                </b-form-group>
                            </b-col>
                        </b-row>
                    </b-card>
                    <b-row id="buttons">
                        <b-col id="contentButtons">
                            <b-button variant="primary" @click="editMode = !editMode" class="mr-2">{{ editMode ? 'Cancelar'
                                : 'Editar'
                            }}</b-button>
                            <b-button variant="success" v-if="editMode">Guardar</b-button>
                        </b-col>
                    </b-row>
                </b-col>

            </b-row>

        </b-container>
    </div>
</template>

<script lang="ts">

import Vue from 'vue'

export default Vue.extend({
    data() {
        return {
            user: {
                name: 'Emilio',
                surname: 'Véjar',
                email: 'emilio@gmail.com',
                password: '123456789',
                birthdate: '',
                phone: '7774223659',
                profileImage: '',
            },
            validationErrors: {
        name: '',
        password: '',
        phone: '',
        email: '',
      },
            showFileInput: false,
            editMode: false,
            showPassword: false,
        }
    },
    mounted() {
        this.getUser()
    },
    methods: {
        getUser() {

        },


        handleFileChange(event: Event) {
            const fileInput = event.target as HTMLInputElement;
            const file = fileInput.files?.[0];
            if (file) {
                const reader = new FileReader();
                reader.onload = (e) => {
                    this.user.profileImage = e.target?.result as string;
                };
                reader.readAsDataURL(file);
            }
        },
        togglePasswordVisibility() {
            this.showPassword = !this.showPassword;
        },


        validateName() {
      const regex = /^[a-zA-Z\s]+$/;
      if (!regex.test(this.user.name)) {
        this.validationErrors.name = 'Nombre debe contener solo letras y espacios';
      } else {
        this.validationErrors.name = '';
      }
    },

    validatePassword() {
      const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/;
      if (!passwordRegex.test(this.user.password)) {
        this.validationErrors.password =
          'Contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula y un número';
      } else {
        this.validationErrors.password = '';
      }
    },

    validatePhone() {
      const phoneRegex = /^\d{10}$/;
      if (!phoneRegex.test(this.user.phone)) {
        this.validationErrors.phone = 'Teléfono debe tener 10 dígitos';
      } else {
        this.validationErrors.phone = '';
      }
    },

    validateEmail() {
      const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      if (!emailRegex.test(this.user.email)) {
        this.validationErrors.email = 'Email no válido';
      } else {
        this.validationErrors.email = '';
      }
    },

    validateAllFields() {
      this.validateName();
      this.validatePassword();
      this.validatePhone();
      this.validateEmail();
      
    },

    save() {
        this.validateAllFields();
        const hasErrors = Object.keys(this.validationErrors).some(
        (error) => error.length > 0
        );

        
}
    }

})

</script>

<style>
#buttons {
    margin-top: 20px;
}

#contentButtons {
    display: flex;
    justify-content: center;
}

.profile-image-container {
    position: absolute;
    width: 150px;
    height: 150px;
    overflow: hidden;
    border-radius: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
    cursor: pointer;
    border: 1px solid #ddd;
}

.profile-image-container input {
    position: absolute;
    top: 0;
    left: 0;
    width: 50%;
    height: 50%;
    opacity: 0;
    cursor: pointer;
}

#picture {
    width: 150px;
    margin: auto;
    font-size: 1.5rem;
    margin-top: 5%;

}

#information{
    width: 90%;
    margin: auto;

}
#tittle{
    margin-bottom: 40px;
}
</style>