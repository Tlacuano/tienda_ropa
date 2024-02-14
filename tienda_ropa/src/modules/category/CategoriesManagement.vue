<template>
    <b-container fluid>
        <b-row class="mt-4">
            <b-col class="text-center">
                <h1>Categorias</h1>
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
                <b-button v-b-modal.InsertCategoryModal  variant="dark">Resgistrar</b-button>
            </b-col>
        </b-row>
        <b-row class="my-3">
            <b-col cols="12" >
                <section class="container-section">
                    <b-row>
                        <b-col lg="4" v-for="category in paginatedCategories" :key="category.id" class="container-category">
                            <b-card no-body class="highlight-on-hover mb-1">
                                <b-row>
                                    <b-col class="mx-3 mt-2">
                                        <div  class="d-inline-block text-truncate" style="max-width: 160px;">
                                            <h5>{{ category.name }}</h5>
                                        </div>
                                    </b-col>
                                    <b-col cols="auto mt-1">
                                        <b-badge
                                            variant="light"
                                            class="mb-1"
                                            v-if="category.status === 'habilitado'"
                                        >
                                            Habilitado
                                        </b-badge>
                                        <b-badge
                                            variant="danger"
                                            class="mb-1"
                                            v-if="category.status !== 'habilitado'"
                                        >
                                            Desabilitado
                                        </b-badge>
                                        <b-dropdown   variant="link-dark" toggle-class="text-decoration-none" no-caret >
                                            <template #button-content>
                                                <b-icon icon="three-dots-vertical"></b-icon>
                                            </template>
                                            <b-dropdown-item v-b-modal.CategoryDetailsModal>
                                                <b-row>
                                                    <b-col>
                                                        <small>Detalles</small>
                                                    </b-col>
                                                </b-row>
                                            </b-dropdown-item>
                                            <b-dropdown-item v-b-modal.UpdateCategoryModal>
                                                <b-row>
                                                    <b-col>
                                                        <small>Actualizar</small>
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
                    :total-rows="categories.length"
                    :per-page="perPage"
                    aria-controls="my-table"
                    variant="dark"
                ></b-pagination>
            </b-col>
        </b-row>

        <CategoryDetailsModal />
        <UpdateCategoryModal />
        <InsertCategoryModal />
    </b-container>
</template>

<script lang="ts">
import Vue from 'vue';

export default Vue.extend({
    name: 'CategoriesManagement',
    data() {
        return {
            categories: [
                {
                    id: 1,
                    name: 'Vestidos',
                    status: 'habilitado',
                },
                {
                    id: 2,
                    name: 'Blusas',
                    status: 'habilitado',
                },
                {
                    id: 3,
                    name: 'Pantalones',
                    status: 'habilitado',
                },
                {
                    id: 4,
                    name: 'Zapatos',
                    status: 'habilitado',
                },
                {
                    id: 5,
                    name: 'Joggers',
                    status: 'deshabilitado',
                },
                {
                    id: 6,
                    name: 'Shorts',
                    status: 'deshabilitado',
                },
                {
                    id: 7,
                    name: 'Ropa interior',
                    status: 'deshabilitado',
                },
                {
                    id: 8,
                    name: 'Ropa de baño',
                    status: 'deshabilitado',
                },
                {
                    id: 9,
                    name: 'Camisas',
                    status: 'deshabilitado',
                }
            ],
            currentPage: 1,
            perPage: 8,
        
        }
    },
    components: {
        CategoryDetailsModal: () => import('./CategoryDetailsModal.vue'),
        UpdateCategoryModal: () => import('./UpdateCategoryModal.vue'),
        InsertCategoryModal: () => import('./InsertCategoryModal.vue'),
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
        min-height: 67vh !important;
        overflow-x: hidden ;
    }

    .container-category{
        width: 100%;
    }


</style>