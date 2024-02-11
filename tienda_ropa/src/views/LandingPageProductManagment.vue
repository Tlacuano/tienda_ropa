<template>
    <div class="container-fluid product-management">
        <div class="text-center mb-4">
            <h1>Gestión de productos</h1>
        </div>
        <div class="text-right">
            <b-button variant="dark" v-b-modal.insertNewProduct>Registrar producto</b-button>
        </div>
        <br />
        <br />
        <b-row>
            <b-col lg="4" md="4" sm="6" cols="12" v-for="product in products" :key="product.id" class="mb-3">
                <b-card no-body>
                    <b-row no-gutters>
                        <b-col cols="5" sm="4" md="4" lg="4" class="overflow-hidden img-product">
                            <img :src="product.imageUrl" alt="Imagen del producto" class="img" />
                        </b-col>
                        <b-col cols="5" sm="6" md="7" lg="7">
                            <b-card-text class="container-text">
                                <h2>{{ product.name }}</h2>
                                <p class="product-price"><b>Precio: $</b>{{ product.price }}</p>
                                <p class="product-stock"><b>Piezas disponibles: </b> {{ product.stock }}</p>
                                <p class="product-category"><b>Categoría: </b> {{ product.category }}</p>
                                <p class="product-department"><b>Departamento: </b> {{ product.department }}
                                </p>
                            </b-card-text>
                        </b-col>
                        <b-col cols="1" sm="1" md="1" lg="1" class="dropdown" @click="toggleDropdown">
                            <button class="dropbtn">•••</button>
                            <div class="dropdown-content">
                                <a href="#" v-b-modal.editProduct>Editar</a>
                                <a href="#">Eliminar</a>
                            </div>
                        </b-col>
                    </b-row>
                </b-card>
            </b-col>
        </b-row>
        <ProductRegistration />
        <ProductEdit />
    </div>
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
            isDropdownOpen: false,
            products: [
                // Aquí irían los datos de tus productos
                {
                    id: 1,
                    name: 'Jeans',
                    price: 599,
                    stock: 10,
                    category: 'Mujer',
                    department: 'Pantalón',
                    imageUrl: 'https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F08%2Fe0%2F08e0a403c8a13297700045643d5c39e90e8e1c1e.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BLOOKBOOK%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/mobilefullscreen]'
                },
                {
                    id: 2,
                    name: 'Jeans',
                    price: 599,
                    stock: 10,
                    category: 'Mujer',
                    department: 'Pantalón',
                    imageUrl: 'https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F08%2Fe0%2F08e0a403c8a13297700045643d5c39e90e8e1c1e.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BLOOKBOOK%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/mobilefullscreen]'
                },
                {
                    id: 3,
                    name: 'Jeans',
                    price: 599,
                    stock: 10,
                    category: 'Mujer',
                    department: 'Pantalón',
                    imageUrl: 'https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F08%2Fe0%2F08e0a403c8a13297700045643d5c39e90e8e1c1e.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BLOOKBOOK%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/mobilefullscreen]'
                },

                // ... otros productos
            ]
        }
    },
    methods: {
        toggleDropdown() {
            this.isDropdownOpen = !this.isDropdownOpen;
        },
        editItem() {
            // Lógica para editar
        },
        deleteItem() {
            // Lógica para eliminar
        },
        closeDropdown() {
            if (this.isDropdownOpen) {
                this.isDropdownOpen = false;
            }
        },
    },
    mounted() {
        document.addEventListener('click', (event) => {
            if (!this.$el.contains(event.target)) {
                this.closeDropdown();
            }
        });
    },
    beforeDestroy() {
        document.removeEventListener('click', this.closeDropdown);
    },
})
</script>

<style >
.product-management {
    padding: 20px;
}

.container-text {
    margin-left: 20px;
    margin-top: 5px;
}

.img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}

.img-product {
    width: 100%;
    height: auto;
}

@media (max-width:575px) {
    .img-product {
        width: 100%;
        height: auto;        
    }

    .img {
        width: 100%;
        height: 100%;
        object-fit: cover;
    }
}

@media (max-width:767px) {
    .img-product {
        width: 100%;
        height: auto;
        
    }
    .img {
        width: 100%;
        height: 100%;
        object-fit: cover;
    }
}

@media (max-width: 767px) {
    .product-management {
        padding: 10px;
    }


}

.container-btn {
    margin-top: 15px;
}

.dropdown {
    position: relative;
    display: inline-block;
    margin-top: 15px;
}

/* Estilo para el botón que desencadena el dropdown */
.dropbtn {
    background: transparent;
    border: none;
    font-size: 16px;
    /* Ajusta esto según sea necesario */
    cursor: pointer;
    transform: rotate(90deg);
    overflow: visible;
}

/* Estilo para el contenido del dropdown */
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
    z-index: 1;
    overflow: visible;
    right: 0;
}

/* Estilos para los ítems del dropdown */
.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

/* Muestra el dropdown al pasar el mouse */
.dropdown:hover .dropdown-content {
    display: block;
}

/* Cambia el color de los ítems del dropdown al pasar el mouse */
.dropdown-content a:hover {
    background-color: #ddd;
}</style>