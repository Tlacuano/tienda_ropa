<template>
    <b-container fluid>
        <b-row class="mt-4">
            <b-col>
                <h1>Departamentos</h1>
            </b-col>
        </b-row>
        <b-row class="mt-4" align-h="between">
            <b-col cols="12" lg="5">
                <b-form-group >
                    <b-form-input id="search" type="text" placeholder="Ingrese su búsqueda"></b-form-input>
                </b-form-group>
            </b-col>
            <b-col cols="auto" class="text-right">
                <b-button v-b-modal.insertNewUser variant="dark" v-b-modal.InsertDepartmentModal >Registrar departamento</b-button>
            </b-col>
        </b-row>
        <b-row class="my-3">
            <b-col cols="12">
                <b-card class="container-departments">
                    <section v-for="departament in departments" :key="departament.id">
                        <div class="mb-1 container-department" >
                            <b-row no-gutters>
                                <b-col class="ml-3">
                                    <h5  v-b-modal.DepartamentDetailsModal class="mt-1">{{departament.name}}</h5>
                                </b-col>
                                <b-col cols="auto" class="pt-2 ">
                                    <b-badge
                                        variant="danger"
                                        class="mb-1 mr-5"
                                        v-if="departament.status !== 'habilidato'"
                                    >
                                        Desabilitado
                                    </b-badge>
                                </b-col>
                                <b-col cols="auto">
                                    <font-awesome-icon
                                        v-b-tooltip.hover="'Deshabilitar'"
                                        icon="circle-down"
                                        size="2xl"
                                        v-if="departament.status === 'habilidato'"
                                        class="selectable pt-1"
                                                
                                    />
                                    <font-awesome-icon
                                        v-b-tooltip.hover="'Habilitar'"
                                        icon="circle-up"
                                        size="2xl"
                                        v-else
                                        style="color: #1ea440;"
                                        class="selectable pt-1"
                                    />
                                </b-col>
                                <b-col cols="auto">
                                    <b-dropdown   variant="link-dark" toggle-class="text-decoration-none" no-caret >
                                        <template #button-content>
                                            <b-icon icon="three-dots-vertical"></b-icon>
                                        </template>
                                        <b-dropdown-item v-b-modal.UpdateDepartamentModal >
                                            <span>Editar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <font-awesome-icon icon="pen"/></span>
                                        </b-dropdown-item>
                                        
                                    </b-dropdown>
                                </b-col>
                            </b-row>
                        </div>
                    </section>
                </b-card>
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
    name: 'DepartmentsManagment',
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
                    status: 'habilidato',
                },
                {
                    id: 2,
                    name: 'Mujer',
                    status: 'habilidato',
                },
                {
                    id: 3,
                    name: 'Niño',
                    status: 'habilidato',
                },
                {
                    id: 4,
                    name: 'Niña',
                    status: 'habilidato',
                },
                {
                    id: 5,
                    name: 'Bebé',
                    status: 'deshabilidato',
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

    }
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