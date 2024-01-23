<template>
    <b-container fluid>
        <b-row class="mt-4">
            <b-col>
                <h1>Usuarios</h1>
            </b-col>
        </b-row>
        <b-row class="mt-4">
            <b-col cols="5">
                <b-form-group >
                    <b-form-input id="search" type="text" placeholder="Ingrese su búsqueda"></b-form-input>
                </b-form-group>
            </b-col>
            <b-col cols="2" class="text-right">
                <b-pagination
                    v-model="currentPage"
                    :total-rows="rows"
                    :per-page="perPage"
                    aria-controls="my-table"
                    variant="outline-dark"
                ></b-pagination>
            </b-col>
            <b-col cols="5" class="text-right">
                <b-button v-b-modal.insertNewUser variant="outline-dark">Registrar cuenta</b-button>
            </b-col>
        </b-row>
        <b-row class="my-3">
            <b-col cols="12">
                <b-card  class="container-users">
                    <section v-for="user in users" :key="user.id">
                        <div class="mb-1 container-user">
                            <b-row no-gutters>
                                <b-col lg="1" class="d-none d-lg-block">
                                    <b-img
                                        :src="user.imageProfile"
                                        alt="Foto perfil"
                                        rounded
                                        fluid
                                        thumbnail
                                        v-if="user.imageProfile"
                                    ></b-img>
                                    <b-avatar
                                        class="mt-2 ml-3"
                                        :src="user.imageProfile"
                                        alt="Foto perfil"
                                        v-else
                                    ></b-avatar>
                                </b-col>
                                <b-col lg="11">
                                    <b-row align-v="center" class="h-100">
                                        <b-col>
                                            <h5 class="mb-1">{{ user.name }}</h5>
                                            <p class="mb-1">{{ user.role }}</p>
                                        </b-col>
                                        <b-col cols="auto">
                                            <b-badge
                                                variant="success"
                                                class="mb-1"
                                                v-if="user.status === 'habilidato'"
                                            >
                                            </b-badge>
                                            <b-badge
                                                variant="danger"
                                                class="mb-1"
                                                v-else
                                            >
                                                Desabilitado
                                            </b-badge>
                                        </b-col>
                                        <b-col cols="auto">
                                            <font-awesome-icon
                                                v-b-tooltip.hover="'Deshabilitar'"
                                                icon="circle-down"
                                                size="2xl"
                                                v-if="user.status === 'habilidato'"
                                                class="selectable"
                                                
                                            />
                                            <font-awesome-icon
                                                v-b-tooltip.hover="'Habilitar'"
                                                icon="circle-up"
                                                size="2xl"
                                                v-else
                                                style="color: #1ea440;"
                                                class="selectable"
                                            />
                                        </b-col>
                                    </b-row>
                                </b-col>
                            </b-row>
                        </div>
                    </section>
                </b-card>
            </b-col>
        </b-row> 
        
        <InsertNewUser />
    </b-container>
</template>

<script lang="ts">
import Vue from 'vue'

export default Vue.extend({
    name: 'UserManagment',
    components: {
        InsertNewUser: () => import('./InsertNewUserModal.vue'),
    },
    data() {
        return {
            perPage: 5, // Número de elementos por página
            currentPage: 1, // Página actual
            users: [
                {
                    id: 1,
                    name: 'John Doe Enriquez de la Cruz',
                    email: 'unCorreo@gmail.com',
                    role: 'administrador',
                    status: 'habilidato',
                    imageProfile: null,
                },
                {
                    id: 2,
                    name: 'Jane Smith',
                    email: 'otroCorreo@gmail.com',
                    role: 'vendedor',
                    status: 'habilidato',
                    imageProfile: null,
                },
                {
                    id: 3,
                    name: 'Carlos Rodríguez',
                    email: 'correoCarlos@gmail.com',
                    role: 'comprador',
                    status: 'Desabilitado',
                    imageProfile: null,
                },
                {
                    id: 4,
                    name: 'Ana Pérez',
                    email: 'ana@email.com',
                    role: 'administrador, vendedor',
                    status: 'habilidato',
                    imageProfile: null,
                },
                {
                    id: 5,
                    name: 'José López',
                    email: 'jose@email.com',
                    role: 'vendedor, comprador, administrador',
                    status: 'Desabilitado',
                    imageProfile: null,
                },
                {
                    id: 6,
                    name: 'María García',
                    email: 'maria@email.com',
                    role: 'administrador',
                    status: 'habilidato',
                    imageProfile: null,
                },
                {
                    id: 7,
                    name: 'Pedro Ramírez',
                    email: 'pedro@email.com',
                    role: 'comprador',
                    status: 'habilidato',
                    imageProfile: null,
                },
                {
                    id: 8,
                    name: 'Laura Fernández',
                    email: 'laura@email.com',
                    role: 'vendedor',
                    status: 'Desabilitado',
                    imageProfile: null,
                },
                {
                    id: 9,
                    name: 'Roberto Martínez',
                    email: 'roberto@email.com',
                    role: 'administrador, vendedor',
                    status: 'habilidato',
                    imageProfile: null,
                },
                {
                    id: 10,
                    name: 'Isabel Sánchez',
                    email: 'isabel@email.com',
                    role: 'comprador',
                    status: 'Desabilitado',
                    imageProfile: null,
                },
                {
                    id: 11,
                    name: 'Daniel Jiménez',
                    email: 'daniel@email.com',
                    role: 'vendedor',
                    status: 'habilidato',
                    imageProfile: null,
                },
                {
                    id: 12,
                    name: 'Carmen Torres',
                    email: 'carmen@email.com',
                    role: 'administrador',
                    status: 'habilidato',
                    imageProfile: null,
                },
                {
                    id: 13,
                    name: 'Miguel González',
                    email: 'miguel@email.com',
                    role: 'comprador',
                    status: 'Desabilitado',
                    imageProfile: null,
                },
                {
                    id: 14,
                    name: 'Elena Ruiz',
                    email: 'elena@email.com',
                    role: 'vendedor',
                    status: 'habilidato',
                    imageProfile: null,
                },
                {
                    id: 15,
                    name: 'Francisco Herrera',
                    email: 'francisco@email.com',
                    role: 'administrador, vendedor',
                    status: 'habilidato',
                    imageProfile: null,
                },
                {
                    id: 16,
                    name: 'Sofía Díaz',
                    email: 'sofia@email.com',
                    role: 'comprador',
                    status: 'Desabilitado',
                    imageProfile: null,
                },
                {
                    id: 17,
                    name: 'Javier Castro',
                    email: 'javier@email.com',
                    role: 'vendedor',
                    status: 'habilidato',
                    imageProfile: null,
                },
                {
                    id: 18,
                    name: 'Luisa Martín',
                    email: 'luisa@email.com',
                    role: 'administrador',
                    status: 'habilidato',
                    imageProfile: null,
                },
                {
                    id: 19,
                    name: 'Raúl Núñez',
                    email: 'raul@email.com',
                    role: 'comprador',
                    status: 'Desabilitado',
                    imageProfile: null,
                },
                {
                    id: 20,
                    name: 'Beatriz Romero',
                    email: 'beatriz@email.com',
                    role: 'vendedor',
                    status: 'habilidato',
                    imageProfile: null,
                },
                {
                    id: 21,
                    name: 'Fernando Vargas',
                    email: 'fernando@email.com',
                    role: 'administrador, vendedor',
                    status: 'habilidato',
                    imageProfile: null,
                },
                {
                    id: 22,
                    name: 'Lucía Ortega',
                    email: 'lucia@email.com',
                    role: 'comprador',
                    status: 'Desabilitado',
                    imageProfile: null,
                },
                {
                    id: 23,
                    name: 'Alberto Medina',
                    email: 'alberto@email.com',
                    role: 'vendedor',
                    status: 'habilidato',
                    imageProfile: null,
                },
                {
                    id: 24,
                    name: 'Rosa Mendoza',
                    email: 'rosa@email.com',
                    role: 'administrador',
                    status: 'habilidato',
                    imageProfile: null,
                },
                {
                    id: 25,
                    name: 'Pablo Herrera',
                    email: 'pablo@email.com',
                    role: 'comprador',
                    status: 'Desabilitado',
                    imageProfile: null,
                },
            ],
        }
    },
    methods: {
        handleChangeStatus(id: number, status: boolean) {
            const user = this.users.find((user) => user.id === id)
            if (user) {
                user.status = status ? 'habilitado' : 'Desabilitado'
            }
        },
    },
})
</script>

<style>
    .container-users{
        height: 75vh !important;
        overflow-y: scroll;
    }

    .container-user{
        border: 1px solid #e2e2e2;
        border-radius: 5px;
        padding: 9px;
        
    }
</style>


