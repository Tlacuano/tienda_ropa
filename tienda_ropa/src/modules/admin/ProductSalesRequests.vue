<template>
  <b-container fluid>
    <b-row class="mt-4">
      <b-col>
        <h1>Solicitudes de Venta de Productos</h1>
      </b-col>
    </b-row>
    <b-row class="mt-4">
      <b-col cols="2" class="text-right">
        <b-pagination
          v-model="currentPage"
          :total-rows="rows"
          :per-page="perPage"
          aria-controls="my-table"
          variant="outline-dark"
        ></b-pagination>
      </b-col>
    </b-row>
    <b-row class="my-3">
      <b-col cols="12">
        <b-card class="container-users">
          <section v-for="product in products" :key="product.id">
            <div class="mb-1 container-user">
              <b-row no-gutters>
                <b-col lg="1" class="d-none d-lg-block">
                  <b-img
                    :src="product.imageProduct"
                    alt="Foto de perfil"
                    rounded
                    fluid
                    thumbnail
                    v-if="product.imageProduct"
                  ></b-img>
                  <b-avatar
                    class="mt-2 ml-3"
                    :src="product.imageProduct"
                    alt="Foto de perfil"
                    v-else
                  ></b-avatar>
                </b-col>
                <b-col lg="11">
                  <b-row align-v="center" class="h-100">
                    <b-col>
                      <h5 class="mb-1">{{ product.name }}</h5>
                      <p class="mb-1">{{ product.apparelDepartment }}</p>
                    </b-col>
                    <b-col>
                      <h5 class="mb-1">{{ product.userName }}</h5>
                      <p class="mb-1">{{ product.userRole }}</p>
                    </b-col>
                    <b-col cols="auto" class="text-right">
                      <b-button
                        variant="outline-dark"
                        @click="openDetailsProductRequest(product)"
                        >Ver información</b-button
                      >
                    </b-col>
                  </b-row>
                </b-col>
              </b-row>
            </div>
          </section>
        </b-card>
      </b-col>
    </b-row>
    <DetailsProductRequest :product="selectedProduct" />
  </b-container>
</template>

<script lang="ts">
import Vue from "vue";

export default Vue.extend({
  name: "ProductSalesRequests",
  components: {
    DetailsProductRequest: () => import("./DetailsProductRequest.vue"),
  },
  data() {
    return {
      perPage: 5,
      currentPage: 1,
      selectedProduct: null,
      products: [
        {
          id: 1,
          name: "Camisa de cuadros",
          apparelDepartment: "Hombre",
          userRole: "Vendedor",
          userName: "Clark Kent",
          imageProduct: "https://th.bing.com/th/id/OIP.rt7h84Dqt7Af2odSr_ofdgHaLG?rs=1&pid=ImgDetMain",
          apparelCategory: "Camisas",
        },
        {
          id: 2,
          name: "Traje de baño",
          apparelDepartment: "Mujer",
          userRole: "Vendedor",
          userName: "Diana Prince",
          imageProduct: "https://th.bing.com/th/id/OIP.F3ULbjYklIVFBKtkX1EXRwHaO7?rs=1&pid=ImgDetMain",
          apparelCategory: "Trajes de baño",
        },
        {
          id: 3,
          name: "Top",
          apparelDepartment: "Mujer",
          userRole: "Vendedor",
          userName: "Kara Danvers",
          imageProduct: "https://th.bing.com/th/id/OIP.78jb1M_OAipeAYYWSPTN7AHaLb?rs=1&pid=ImgDetMain",
          apparelCategory: "Blusas",
        },
        {
          id: 4,
          name: "Pantalón",
          apparelDepartment: "Hombre",
          userRole: "Vendedor",
          userName: "Bruce Wayne",
          imageProduct: "https://www.bolf.es/spa_pl_Pantalon-jogger-cargo-para-hombre-negro-Bolf-701-79837_8.jpg",
          apparelCategory: "Pantalones",
        },
        {
          id: 5,
          name: "Saco",
          apparelDepartment: "Hombre",
          userRole: "Vendedor",
          userName: "Barry Allen",
          imageProduct: "https://i.pinimg.com/originals/48/80/2d/48802decdca5b4d456bf3eb32c433308.jpg",
          apparelCategory: "Sacos",
        },
      ],
    };
  },
  methods: {
    openDetailsProductRequest(product: any) {
      this.selectedProduct = product;

      this.$nextTick(() => {
        this.$bvModal.show("DetailsProductRequest");
      });
    },
  },
});
</script>

<style scoped>
container-users {
  height: 75vh !important;
  overflow-y: scroll;
}

.container-user {
  border: 1px solid #e2e2e2;
  border-radius: 5px;
  padding: 9px;
}
</style>
