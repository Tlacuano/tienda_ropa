<template>
    <b-container fluid>
        <b-row class="mt-4">
            <b-col>
                <h1>Departamentos</h1>
            </b-col>
        </b-row>
        <b-row>
            <b-col cols="12">
                <b-card class="container-departments">
                    <section v-for="departament in departments" :key="departament.id">
                        <div class="mb-1 container-department">
                            <b-row no-gutters>
                                <b-col class="ml-3">
                                    <h5 class="mt-1">{{departament.name}}</h5>
                                </b-col>
                                <b-col cols="auto" class="pt-2 px-5">
                                    <b-badge
                                        variant="danger"
                                        class="mb-1"
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
                                        <b-dropdown-item @click="EliminarOpinion(opinion)" >
                                            <span>Eliminar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <font-awesome-icon icon="trash"/></span>
                                        </b-dropdown-item>
                                        <b-dropdown-item @click="EliminarOpinion(opinion)" >
                                            <span>Editar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
    </b-container>
</template>

<script lang="ts">
import Vue from 'vue';

export default Vue.extend({
    name: 'DepartmentsManagment',
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
            ]
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
        height: 75vh !important;
        overflow-y: scroll;
    }

    .container-department{
        border: 1px solid #e2e2e2;
        border-radius: 5px;
        padding: 11px;
        
    }
</style>