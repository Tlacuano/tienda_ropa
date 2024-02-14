<template>
    <b-modal id="DepartamentDetailsModal" hide-footer centered size="lg" title="Departamento">
        <b-row class="my-3">
            <b-col>
                <b-container fluid>
                    <b-row>
                        <b-col>
                            <b-form-group label="Nombre:" label-for="id">
                                <b-form-input
                                    id="id"
                                    v-model="department.name"
                                    readonly
                                ></b-form-input>
                            </b-form-group>
                        </b-col>
                    </b-row>
                    <b-row>
                        <b-col>
                            <b-form-group label="Estado:" label-for="status">
                                <b-form-input
                                    id="status"
                                    v-model="department.status"
                                    readonly
                                ></b-form-input>
                            </b-form-group>
                        </b-col>
                    </b-row>
                    <b-row>
                        <b-col>
                            <b-form-group label="Productos Registrados:" label-for="registaredProducts">
                                <b-form-input
                                    id="registaredProducts"
                                    v-model="department.registaredProducts"
                                    readonly
                                ></b-form-input>
                            </b-form-group>
                        </b-col>
                    </b-row>
                    <b-row>
                        <b-col>
                            <b-form-group label="Ventas Totales:" label-for="totalSales">
                                <b-form-input
                                    id="totalSales"
                                    v-model="department.totalSales"
                                    readonly
                                ></b-form-input>
                            </b-form-group>
                        </b-col>
                    </b-row>


                </b-container>
            </b-col>
            <b-col>
                <b-img
                    class="image-department"
                    fluid
                    
                    :src="department.image"
                    alt="image"
                ></b-img>
            </b-col>
        </b-row>
    </b-modal>
</template>

<script lang="ts">
import Vue from 'vue';

export default Vue.extend({
    name: 'DepartamentDetailsModal',
    data() {
        return {
            department:{
                id: 1,
                name: 'Hombre',
                status: 'habilidato',
                image: 'https://cdn2.coppel.com/images/emarketing/landings/2022/octubre/tendencias-hombres/Mobile/Bloques-1/2a_bloques1_m_kazbet1.jpg',
                registaredProducts: 10,
                totalSales: 1000,
            }
        
        }
    },
    methods: {

    },
    mounted() {

    }
});

</script>

<style>
    .image-department {
        box-shadow: 1px 3px 5px 5px rgba(0, 0, 0, 0.1);
    }
</style>