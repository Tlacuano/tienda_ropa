<template>
  <b-modal
    id="DetailsProductRequest"
    title="Detalles de Solicitud de Venta"
    hide-footer
    centered
  >
    <b-container fluid>
      <b-row>
        <b-col>
          <div class="mb-3">
            <h4>{{ product.name }}</h4>
            <p>
              <strong>Departamento del Producto:</strong
              >{{ product.apparelDepartment }}
            </p>
            <p>
              <strong>Categoria del Producto:</strong
              >{{ product.apparelCategory }}
            </p>
            <p><strong>Nombre del Usuario:</strong>{{ product.userName }}</p>
          </div>
          <div v-if="product.imageProduct" class="mb-3">
            <b-img
              :src="product.imageProduct"
              alt="Foto del producto"
              fluid
              thumbnail
            ></b-img>
          </div>
        </b-col>
      </b-row>
    </b-container>
  </b-modal>
</template>

<script lang="ts">
import Vue from "vue";

export default Vue.extend({
  name: "DetailsProductRequest",
  props: {
    product: Object,
  },
  data() {
    return {
      methods: {},
    };
  },
});
</script>

<style scoped></style>
