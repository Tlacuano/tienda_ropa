<template>
    <b-container fluid>
        <b-row class="mt-4">
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
            <b-col cols="12" class="container-section">
                <b-list-group >
                    <b-list-group-item v-for="department in paginatedDepartments" :key="department.id" class="highlight-on-hover">
                        <b-row no-gutters align-h="between">
                            <b-col>
                                <div class="text-ellipsis">
                                    <h5>
                                        {{ department.name }}
                                    </h5>
                                </div>
                            </b-col>
                            <b-col>
                                <b-badge v-if="department.status === 'habilitado'" variant="light">Habilitado</b-badge>
                                <b-badge v-else variant="danger">Deshabilitado</b-badge>
                            </b-col>
                            <b-col cols="auto">
                                <b-dropdown   variant="link-dark" toggle-class="text-decoration-none" no-caret >
                                    <template #button-content>
                                        <b-icon icon="three-dots-vertical"></b-icon>
                                    </template>

                                    
                                    <b-dropdown-item v-b-modal.DepartamentDetailsModal>
                                        <b-row>
                                            <b-col>
                                                <small>Detalles</small>
                                            </b-col>
                                            <b-col cols="auto">
                                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                            </b-col>
                                        </b-row>
                                    </b-dropdown-item>
                                    <b-dropdown-item v-b-modal.UpdateDepartamentModal>
                                        <b-row>
                                            <b-col>
                                                <small>Editar</small>
                                            </b-col>
                                            <b-col cols="auto">
                                                <font-awesome-icon icon="pen"></font-awesome-icon>
                                            </b-col>
                                        </b-row>
                                    </b-dropdown-item>
                                    <b-dropdown-item>
                                        <b-row v-if="department.status !== 'habilitado'">
                                            <b-col>
                                                <small>Habilitar</small>
                                            </b-col>
                                            <b-col cols="auto">
                                                <font-awesome-icon icon="circle-up"></font-awesome-icon>
                                            </b-col>
                                        </b-row>

                                        <b-row v-else>
                                            <b-col >
                                                <small>Desabilitar</small> 
                                            </b-col>
                                            <b-col cols="auto">
                                                <font-awesome-icon icon="circle-down"></font-awesome-icon>
                                            </b-col>
                                            </b-row>
                                    </b-dropdown-item>

                                </b-dropdown>
                            </b-col>
                        </b-row>
                    </b-list-group-item>
                </b-list-group>
            </b-col>
        </b-row>
        <b-row>
            <b-col>
                <b-pagination
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
        height: 68vh !important;
        overflow-y: scroll;
    }

    .container-department{
        border: 1px solid #e2e2e2;
        border-radius: 5px;
        padding: 9px;
        
    }

    .container-department:hover{
        background-color: #f2f2f2;
        border: 1px solid #e2e2e2;
    }
</style>