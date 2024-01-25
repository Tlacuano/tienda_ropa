<template>
    <b-modal id="UserDetailsModal" hide-footer centered title="Información de cuenta">
        <b-container fluid>
            <b-row class="mt-3">
                <b-col class="text-center ">
                    <b-img style="width: 50%;" rounded="circle" class="image-department" :src="persona.picture" fluid alt="Fluid image"></b-img>
                </b-col>
            </b-row>

            <b-row>
                <b-col class="text-center">
                    <h4 class="mt-1">{{ persona.name }} {{ persona.lastname }} {{ persona.secondLastname }}</h4>
                </b-col>
            </b-row>
            <hr>

            <b-row>
                <b-col>
                    <b-form-group label="Fecha de nacimiento" label-for="birthday">
                        <b-form-input id="birthday" v-model="persona.birthday" type="text" placeholder="Ingrese su fecha de nacimiento" readonly></b-form-input>
                    </b-form-group>
                </b-col>
            </b-row>

            <b-row>
                <b-col>
                    <b-form-group label="Correo electrónico" label-for="email">
                        <b-form-input id="email" v-model="persona.email" type="email" placeholder="Ingrese su correo electrónico" readonly></b-form-input>
                    </b-form-group>
                </b-col>
            </b-row>

            <b-row>
                <b-col>
                    <b-card>
                        <b-card-body>
                            <b-list-group>
                                <b-list-group-item v-for="role in persona.roles" :key="role">{{ role }}</b-list-group-item>
                            </b-list-group>
                        </b-card-body>
                    </b-card>
                </b-col>
            </b-row>



        </b-container>
    </b-modal>
</template>

<script lang="ts">
import Vue from 'vue';

export default Vue.extend({
    name: 'UserDetailsModal',
    data() {
        return {
            persona: {
                name: 'Benito',
                lastname: 'Padalustro',
                secondLastname: 'Perez',
                birthday: '2003/12/01',
                email: 'amlover255_4T@gmail.com',
                picture: 'https://b.thumbs.redditmedia.com/hAJkepbU89rXBIuOLxMx2K--084yKu3g7eIgNSi6PXE.jpg',
                roles: ['Administrador', 'Usuario']
            },
        }
    },
    methods: {
        insertNewUser() {
            console.log(this.persona);
        }
    },
    mounted() {

    }
});

</script>