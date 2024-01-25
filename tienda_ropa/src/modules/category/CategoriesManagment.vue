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
                <b-button v-b-modal.InsertCategoryModal  variant="dark">Crear categoria</b-button>
            </b-col>
        </b-row>
        <b-row class="my-3">
            <b-col cols="12">
                <b-card class="container-categories">
                    <section v-for="category in paginatedCategories" :key="category.id">
                        <div class="container-category">
                            <b-row no-gutters>
                                <b-col class="ml-3">
                                    <h5 v-b-modal.CategoryDetailsModal class="mt-1">{{ category.name }}</h5>
                                </b-col>
                                <b-col cols="auto" class="pt-2 ">
                                    <b-badge
                                        variant="danger"
                                        class="mb-1 mr-5"
                                        v-if="category.status !== 'habilidato'"
                                    >
                                        Desabilitado
                                    </b-badge>
                                </b-col>
                                <b-col cols="auto">
                                    <font-awesome-icon
                                        v-b-tooltip.hover="'Deshabilitar'"
                                        icon="circle-down"
                                        size="2xl"
                                        v-if="category.status === 'habilidato'"
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
                                        <b-dropdown-item v-b-modal.UpdateCategoryModal>
                                            <span>Editar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <font-awesome-icon icon="pen" />
                                            </span>
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