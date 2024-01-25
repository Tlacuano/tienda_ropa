<template>
    <b-container fluid>
        <b-row class="mt-4">
            <b-col>
                <h1>Categorias</h1>
            </b-col>
        </b-row>
        <b-row class="mt-4" align-h="between">
            <b-col cols="12" lg="5">
                <b-form-group >
                    <b-form-input id="search" type="text" placeholder="Ingrese su búsqueda"></b-form-input>
                </b-form-group>
            </b-col>
            <b-col cols="auto" class="text-right">
                <b-button  variant="dark">Crear categoria</b-button>
            </b-col>
        </b-row>
        <b-row class="my-3">
            <b-col cols="12">
                <b-card class="container-categories">

                </b-card>
            </b-col>
        </b-row>
        <b-row>
            <b-col>
                <b-pagination
                    v-model="currentPage"
                    :total-rows="categories.length"
                    :per-page="perPage"
                    aria-controls="my-table"
                    variant="dark"
                ></b-pagination>
            </b-col>
        </b-row>
    </b-container>
</template>

<script lang="ts">
import Vue from 'vue';

export default Vue.extend({
    name: 'CategoriesManagment',
    data() {
        return {
            categories: [
                {
                    id: 1,
                    name: 'Vestidos',
                    status: 'habilidato',
                },
                {
                    id: 2,
                    name: 'Blusas',
                    status: 'habilidato',
                },
                {
                    id: 3,
                    name: 'Pantalones',
                    status: 'habilidato',
                },
                {
                    id: 4,
                    name: 'Zapatos',
                    status: 'habilidato',
                },
                {
                    id: 5,
                    name: 'Joggers',
                    status: 'deshabilidato',
                },
                {
                    id: 6,
                    name: 'Shorts',
                    status: 'deshabilidato',
                },
                {
                    id: 7,
                    name: 'Ropa interior',
                    status: 'deshabilidato',
                },
                {
                    id: 9,
                    name: 'Ropa de baño',
                    status: 'deshabilidato',
                },
                {
                    id: 10,
                    name: 'Camisas',
                    status: 'deshabilidato',
                }
            ],
            currentPage: 1,
            perPage: 7,
        
        }
    },
    methods: {

    },
    computed: {
        paginatedCategories() {
            const startIndex = (this.currentPage - 1) * this.perPage;
            const endIndex = startIndex + this.perPage;
            return this.categories.slice(startIndex, endIndex);
        },
    },
});

</script>

<style scoped>
    .container-categories {
        height: 68vh !important;
        overflow-y: scroll;
    }

</style>