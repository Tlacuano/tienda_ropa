<template>
    <b-container fluid>
        <b-row class="mt-3">
            <b-col class="text-center">
                <h1>Departamentos</h1>
            </b-col>
        </b-row>
        <b-row class="mt-4" align-h="between">
            <b-col cols="12" lg="5">
                <b-form-group>
                    <div class="position-relative">
                        <b-form-input id="search" type="text" placeholder="Buscar..." class="pr-5"></b-form-input>
                        <font-awesome-icon icon="magnifying-glass" class="search-icon"></font-awesome-icon>
                    </div>
                </b-form-group>
            </b-col>
            <b-col cols="auto" class="text-right">
                <b-button v-b-modal.insertNewUser variant="dark" v-b-modal.InsertDepartmentModal >Registrar</b-button>
            </b-col>
        </b-row>
        <b-row class="my-3">
            <b-col cols="12" >
                <section class="container-section">
                    <b-row >
                        <b-col lg="4" v-for="department in paginatedDepartments" :key="department.id" class="container-department">
                            <b-card no-body class="highlight-on-hover mb-1">
                                <b-row>
                                    <b-col class="mx-3 mt-2">
                                        <div  class="d-inline-block text-truncate" style="max-width: 160px;">
                                            <h5>{{ department.name }}</h5>
                                        </div>
                                    </b-col>
                                    <b-col cols="auto mt-1">
                                        <b-badge
                                            variant="light"
                                            class="mb-1"
                                            v-if="department.status === 'habilitado'"
                                        >
                                            Habilitado
                                        </b-badge>
                                        <b-badge
                                            variant="danger"
                                            class="mb-1"
                                            v-if="department.status !== 'habilitado'"
                                        >
                                            Desabilitado
                                        </b-badge>


                                        <b-dropdown   variant="link-dark" toggle-class="text-decoration-none" no-caret >
                                            <template #button-content>
                                                <b-icon icon="three-dots-vertical"></b-icon>
                                            </template>

                                            
                                            <b-dropdown-item v-b-modal.DepartamentDetailsModal>
                                                <b-row>
                                                    <b-col>
                                                        <small>Detalles</small>
                                                    </b-col>
                                                </b-row>
                                            </b-dropdown-item>
                                            <b-dropdown-item v-b-modal.UpdateDepartamentModal>
                                                <b-row>
                                                    <b-col>
                                                        <small>Editar</small>
                                                    </b-col>
                                                </b-row>
                                            </b-dropdown-item>
                                            <b-dropdown-item>
                                                <b-row v-if="department.status !== 'habilitado'">
                                                    <b-col>
                                                        <small>Habilitar</small>
                                                    </b-col>
                                                </b-row>

                                                <b-row v-else>
                                                    <b-col >
                                                        <small>Desabilitar</small> 
                                                    </b-col>
                                                </b-row>
                                            </b-dropdown-item>
                                        </b-dropdown>
                                    </b-col>
                                </b-row>
                            </b-card>
                        </b-col>
                    </b-row>
                </section>
            </b-col>
        </b-row>
        <b-row>
            <b-col>
                <b-pagination
                    align="center"
                    v-model="currentPage"
                    :total-rows="rows"
                    :per-page="perPage"
                    aria-controls="my-table"
                ></b-pagination>
            </b-col>
        </b-row>
        <DepartamentDetailsModal/>
        <UpdateDepartamentModal/>
        <InsertDepartmentModal/>
    </b-container>
</template>

<script lang="ts">
import Vue from 'vue';

export default Vue.extend({
    name: 'DepartmentsManagement',
    components: {
        DepartamentDetailsModal: () => import('./DepartamentDetailsModal.vue'),
        UpdateDepartamentModal: () => import('./UpdateDepartamentModal.vue'),
        InsertDepartmentModal: () => import('./InsertDepartmentModal.vue'),
    },
    data() {
        return {
            departments: [
                {
                    id: 1,
                    name: 'Hombre',
                    status: 'habilitado',
                },
                {
                    id: 2,
                    name: 'Mujer',
                    status: 'habilitado',
                },
                {
                    id: 3,
                    name: 'Niño',
                    status: 'habilitado',
                },
                {
                    id: 4,
                    name: 'Niña',
                    status: 'habilitado',
                },
                {
                    id: 5,
                    name: 'Bebé',
                    status: 'deshabilitado',
                },
            ],
            currentPage: 1,
            perPage: 5,
            rows: 10,
        
        }
    },
    methods: {

    },
    mounted() {

    },
    computed: {
        paginatedDepartments() {
            const startIndex = (this.currentPage - 1) * this.perPage;
            const endIndex = startIndex + this.perPage;
            return this.departments.slice(startIndex, endIndex);
        },
    },
});
</script>


<style>
    .container-departments{
        min-height: 67vh !important;
        overflow-x: hidden ;
    }

    .container-departament{
        width: 100%;
    }

</style>