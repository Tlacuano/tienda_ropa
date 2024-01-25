<template>
    <b-container fluid>
        <b-row class="mt-4">
            <b-col>
                <h1>Gestion de productos</h1>
            </b-col>
        </b-row>
        <b-row class="mt-4">
            <b-col cols="5">
                <b-form-group>
                    <b-form-input id="search" type="text" placeholder="Ingrese su búsqueda"></b-form-input>
                </b-form-group>
            </b-col>
            <b-col cols="7" class="text-right">
                <b-button v-b-modal.insertNewProduct variant="outline-dark">Registrar producto</b-button>
            </b-col>
        </b-row>
        <b-row class="my-3">
            <b-col cols="12">
                <b-card class="container-product">
                    <section v-for="product in products" :key="product.id">
                        <div class="mb-1 container-product">
                            <b-row no-gutters>
                                <b-col lg="1" md="1" class="d-none d-lg-block">
                                    <b-img :src="product.productImage" alt="product image" rounded fluid thumbnail
                                        v-if="product.productImage"></b-img>
                                    <b-avatar class="mt-2 ml-3" :src="product.productImage" alt="product image"
                                        v-else></b-avatar>
                                </b-col>
                                <b-col lg="11" md="11">
                                    <b-row align-v="center" class="h-100 ">
                                        <b-col lg="3" md="3" sm="12">
                                            <h5 class="mb-1">{{ product.productName }}</h5>
                                            <p class="mb-1">{{ product.productDescription }}</p>
                                        </b-col>
                                        <b-col lg="3" md="3" sm="12">
                                            <div>
                                                <h6 class="mb-1" style="display: inline-block;">Precio: </h6>
                                                <p class="mb-1" style="display: inline-block; margin-left: 5px;">{{
                                                    product.productPrice }}</p>
                                            </div>
                                            <div>
                                                <h6 class="mb-1" style="display: inline-block;">Disponibles: </h6>
                                                <p class="mb-1" style="display: inline-block; margin-left: 5px;">{{
                                                    product.productStock }}</p>
                                            </div>
                                        </b-col>
                                        <b-col lg="2" md="3" sm="12">
                                            <div>
                                                <h6 class="mb-1" style="display: inline-block;">Tallas: </h6>
                                                <p class="mb-1" style="display: inline-block; margin-left: 5px;">{{
                                                    product.productSize }}</p>
                                            </div>
                                            <div>
                                                <h6 class="mb-1" style="display: inline-block;">Precio: </h6>
                                                <p class="mb-1" style="display: inline-block; margin-left: 5px;">{{
                                                    product.productPrice }}</p>
                                            </div>
                                        </b-col >
                                        <b-col lg="2" md="2" sm="12" >
                                            <b-badge variant="success" class="mb-1"
                                                v-if="product.productStatus === 'Habilitado'">
                                                En existencias
                                            </b-badge>
                                            <b-badge variant="danger" class="mb-1" v-else>
                                                Agotado
                                            </b-badge>
                                        </b-col>
                                        <b-col lg="2" md="1">
                                            <b-button v-b-modal.editProduct variant="outline-dark"
                                                class="mb-1">Editar</b-button>
                                            <b-button variant="outline-danger" class="mb-1">Eliminar</b-button>
                                        </b-col>
                                    </b-row>
                                </b-col>
                            </b-row>
                        </div>
                    </section>
                </b-card>
                <b-col cols="2" class="text-right">
                <b-pagination v-model="currentPage" :total-rows="rows" :per-page="perPage" aria-controls="my-table"
                    variant="outline-dark"></b-pagination>
            </b-col>
            </b-col>
        </b-row>
        <ProductEdit />
        <ProductRegistration />
    </b-container>
</template>

<script lang="ts">
import Vue from 'vue';
export default Vue.extend({

    name: 'LandingPageProductManagment',
    components: {
        ProductEdit: () => import('@/components/productSeller/ProductEdit.vue'),
        ProductRegistration: () => import('@/components/productSeller/ProductRegistration.vue'),
    },
    data() {
        return {
            currentPage: 1,
            perPage: 3,
            rows: 0,
            products: [
                {
                    id: '1',
                    productName: 'Jeans',
                    productDescription: 'Jeans de hombre',
                    productPrice: '10000',
                    productStock: '10',
                    productStatus: 'Habilitado',
                    productImage: 'https://www.levi.com.ar/media/catalog/product/cache/1/thumbnail/9df78eab33525d08d6e5fb8d27136e95/1/0/100-jeans-levi_s-501-original-fit-jeans-azul-00501-2467-1.jpg',
                    productSize: 'M',
                },

            ]
        }
    },
    methods: {

    }
})
</script>

<style >
.container-product {
    height: 65vh !important;
    overflow-y: scroll;
}

.container-product {
    border: 1px solid #e2e2e2;
    border-radius: 5px;
    padding: 9px;

}
.container-product:hover {
    background-color: #f2f2f2;
    border:1px solid #e2e2e2;
}
</style>