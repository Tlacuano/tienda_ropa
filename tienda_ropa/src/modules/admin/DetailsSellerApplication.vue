<template>
  <b-modal
    id="DetailsSellerApplication"
    title="Detalles de Solicitud"
    hide-footer
    centered
  >
    <b-container fluid>
      <b-row>
        <b-col>
          <div class="mb-3">
            <h4>{{ user.name }}</h4>
            <p><strong>Correo:</strong>{{ user.email }}</p>
            <p><strong>Telefono:</strong>{{ user.telefono }}</p>
            <p><strong>Rol:</strong>{{ user.role }}</p>
            <p><strong>Estado:</strong>{{user.status}}</p>
          </div>
          <div v-if="user.imageProfile" class="mb-3">
            <b-img
              :src="user.imageProfile"
              alt="Foto de Perfil"
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
  name: "DetailsSellerApplication",
  props: {
    user: Object,
  },
  data() {
    return {
      methods: {},
    };
  },
});
</script>

<style scoped></style>
