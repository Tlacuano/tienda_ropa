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
            <b-col cols="12" class="container-section">
                <b-list-group>
                    <b-list-group-item v-for="category in paginatedCategories" :key="category.id" class="highlight-on-hover">
                        <b-row no-gutters align-h="between">
                            <b-col>
                                <div class="text-ellipsis">
                                    <h5>
                                        {{ category.name }}
                                    </h5>
                                </div>
                            </b-col>
                            <b-col>
                                <b-badge v-if="category.status === 'habilitado'" variant="light">Habilitado</b-badge>
                                <b-badge v-else variant="danger">Deshabilitado</b-badge>
                            </b-col>
                            <b-col cols="auto">
                                <b-dropdown variant="link-dark" toggle-class="text-decoration-none" no-caret>
                                    <template #button-content>
                                        <b-icon icon="three-dots-vertical"></b-icon>
                                    </template>
                                    <b-dropdown-item v-b-modal.CategoryDetailsModal>
                                        <b-row>
                                            <b-col>
                                                <small>Detalles</small>
                                            </b-col>
                                            <b-col cols="auto">
                                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                            </b-col>
                                        </b-row>
                                    </b-dropdown-item>
                                    <b-dropdown-item v-b-modal.UpdateCategoryModal>
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
                                        <b-row v-if="category.status !== 'habilitado'">
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
        height: 68vh !important;
        overflow-y: scroll;
    }

    .container-category{
        border: 1px solid #e2e2e2;
        border-radius: 5px;
        padding: 9px;
    }

    .container-category:hover{
        background-color: #f2f2f2;
    }

</style>