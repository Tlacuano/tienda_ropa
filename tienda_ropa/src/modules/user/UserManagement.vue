<template>
    <b-container fluid>
        <b-row class="mt-4">
            <b-col class="text-center">
                <h1>Usuarios</h1>
            </b-col>
        </b-row>
        <b-row class="mt-4" align-h="between">
            <b-col cols="12" lg="5">
                <b-form-group>
                    <div class="position-relative">
                        <b-form-input id="search" type="text" placeholder="Buscar..." class="pr-5"></b-form-input>
                        <font-awesome-icon icon="magnifying-glass" class="search-icon"></font-awesome-icon>
                    </div>
                </b-form-group>>
            </b-col>
            <b-col cols="auto" class="text-right">
                <b-button v-b-modal.insertNewUser variant="dark">Registrar</b-button>
            </b-col>
        </b-row>
        <b-row class="my-3">
            <b-col cols="12">
                <b-row  class="container-users" align-h="between">
                    <b-col lg="4" v-for="user in paginatedUsers" :key="user.id">
                        <b-card no-body class="highlight-on-hover container-user" >
                            <b-row class="m-2" no-gutters>
                                <b-col class="px-2" cols="auto">
                                    <b-avatar variant="secondary" :src="user.imageProfile"/>
                                </b-col>
                                <b-col>
                                    <b-row>
                                        <b-col>
                                            <div class="text-ellipsis">{{user.name}}</div>
                                        </b-col>
                                    </b-row>
                                    <b-row>
                                        <b-col>
                                            <div class="text-ellipsis text-secondary" style="max-width: 90%;">{{user.role}}</div>
                                        </b-col>
                                    </b-row>
                                </b-col>
                                <b-col cols="auto">
                                    <b-badge
                                        variant="light"
                                        class="mb-1"
                                        v-if="user.status === 'habilitado'"
                                        @click="handleChangeStatus(user.id, false)"
                                    >
                                        Habilitado
                                    </b-badge>
                                    <b-badge
                                        variant="danger"
                                        class="mb-1"
                                        v-if="user.status !== 'habilitado'"
                                    >
                                        Desabilitado
                                    </b-badge>
                                    
                                    <b-dropdown   variant="link-dark" toggle-class="text-decoration-none" no-caret >
                                        <template #button-content>
                                            <b-icon icon="three-dots-vertical"></b-icon>
                                        </template>
                                        <b-dropdown-item>
                                            <b-row v-if="user.status !== 'habilitado'">
                                                <b-col>
                                                    <small>Habilitar</small>
                                                </b-col>
                                                <b-col>
                                                    <font-awesome-icon icon="circle-up"></font-awesome-icon>
                                                </b-col>
                                            </b-row>

                                            <b-row v-else>
                                                <b-col cols="auto">
                                                    <small>Desabilitar</small> 
                                                </b-col>
                                                <b-col>
                                                    <font-awesome-icon icon="circle-down"></font-awesome-icon>
                                                </b-col>
                                            </b-row>
                                        </b-dropdown-item>
                                        
                                    </b-dropdown>
                                </b-col>
                            </b-row>
                        </b-card>
                    </b-col>
                </b-row>
            </b-col>
        </b-row> 
        <b-row>
            <b-col>
                <b-pagination
                    v-model="currentPage"
                    :total-rows="users.length"
                    :per-page="perPage"
                    aria-controls="my-table"
                    variant="dark"
                ></b-pagination>
            </b-col>
        </b-row>
        <UserDetailsModal />
        <InsertNewUser />
    </b-container>
</template>

<script lang="ts">
import Vue from 'vue'

export default Vue.extend({
    name: 'UserManagement',
    components: {
        InsertNewUser: () => import('./InsertNewUserModal.vue'),
        UserDetailsModal: () => import('./UserDetailsModal.vue'),
    },
    data() {
        return {
            perPage: 24, // Número de elementos por página
            currentPage: 1, // Página actual
            users: [
                {
                    id: 1,
                    name: 'John Doe Enriquez de la Cruz',
                    email: 'unCorreo@gmail.com',
                    role: 'administrador',
                    status: 'habilitado',
                    imageProfile: null,
                },
                {
                    id: 2,
                    name: 'Jane Smith',
                    email: 'otroCorreo@gmail.com',
                    role: 'vendedor',
                    status: 'habilitado',
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
                    status: 'habilitado',
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
                    status: 'habilitado',
                    imageProfile: null,
                },
                {
                    id: 7,
                    name: 'Pedro Ramírez',
                    email: 'pedro@email.com',
                    role: 'comprador',
                    status: 'habilitado',
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
                    status: 'habilitado',
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
                    status: 'habilitado',
                    imageProfile: null,
                },
                {
                    id: 12,
                    name: 'Carmen Torres',
                    email: 'carmen@email.com',
                    role: 'administrador',
                    status: 'habilitado',
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
                    status: 'habilitado',
                    imageProfile: null,
                },
                {
                    id: 15,
                    name: 'Francisco Herrera',
                    email: 'francisco@email.com',
                    role: 'administrador, vendedor',
                    status: 'habilitado',
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
                    status: 'habilitado',
                    imageProfile: null,
                },
                {
                    id: 18,
                    name: 'Luisa Martín',
                    email: 'luisa@email.com',
                    role: 'administrador',
                    status: 'habilitado',
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
                    status: 'habilitado',
                    imageProfile: null,
                },
                {
                    id: 21,
                    name: 'Fernando Vargas',
                    email: 'fernando@email.com',
                    role: 'administrador, vendedor',
                    status: 'habilitado',
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
                    status: 'habilitado',
                    imageProfile: null,
                },
                {
                    id: 24,
                    name: 'Rosa Mendoza',
                    email: 'rosa@email.com',
                    role: 'administrador',
                    status: 'habilitado',
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
    computed: {
        paginatedUsers() {
            const startIndex = (this.currentPage - 1) * this.perPage;
            const endIndex = startIndex + this.perPage;
            return this.users.slice(startIndex, endIndex);
        },
    },
})
</script>

<style>
    .container-users{
        height: 68vh !important;
        overflow-x: hidden ;
    }

    .container-user{
        width: 100%;
    }
</style>


