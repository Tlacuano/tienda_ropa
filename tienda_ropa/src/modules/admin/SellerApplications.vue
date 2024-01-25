<template>
  <b-container fluid>
    <b-row class="mt-4">
      <b-col>
        <h1>Solicitudes de Vendedores</h1>
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
          <section v-for="user in users" :key="user.id">
            <div class="mb-1 container-user">
              <b-row no-gutters>
                <b-col lg="1" class="d-none d-lg-block">
                  <b-img
                    :src="user.imageProfile"
                    alt="Foto de perfil"
                    rounded
                    fluid
                    thumbnail
                    v-if="user.imageProfile"
                  ></b-img>
                  <b-avatar
                    class="mt-2 ml-3"
                    :src="user.imageProfile"
                    alt="Foto de perfil"
                    v-else
                  ></b-avatar>
                </b-col>
                <b-col lg="11">
                  <b-row align-v="center" class="h-100">
                    <b-col>
                      <h5 class="mb-1">{{ user.name }}</h5>
                      <p class="mb-1">{{ user.role }}</p>
                    </b-col>
                    <b-col>
                      <h5 class="mb-1">{{ user.email }}</h5>
                      <p class="mb-1">{{ user.telefono }}</p>
                    </b-col>
                    <b-col cols="auto">
                      <b-badge
                        variant="success"
                        class="mb-1"
                        v-if="user.status === 'habilitado'"
                      ></b-badge>
                      {{ user.status }}
                    </b-col>
                    <b-col cols="auto" class="text-right">
                      <b-button
                        variant="outline-dark"
                        @click="openDetailsSellerApplication(user)"
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
    <DetailsSellerApplication :user="selectedUser" />
  </b-container>
</template>

<script lang="ts">
import Vue from "vue";

export default Vue.extend({
  name: "SellerApplications",
  components: {
    DetailsSellerApplication: () => import("./DetailsSellerApplication.vue"),
  },
  data() {
    return {
      perPage: 5,
      currentPage: 1,
      selectedUser: null,
      users: [
        {
          id: 1,
          name: "Juan Perez",
          email: "correo@gmail.com",
          telefono: "123456789",
          role: "comprador",
          status: "habilitado",
          imageProfile: null,
        },
        {
          id: 2,
          name: "Jane Doe",
          email: "otroCorreo@gmail.com",
          telefono: "123456789",
          role: "comprador",
          status: "habilitado",
          imageProfile: null,
        },
        {
          id: 3,
          name: "Kara Danvers",
          email: "kara@gmail.com",
          telefono: "123456789",
          role: "comprador",
          status: "habilitado",
          imageProfile: null,
        },
        {
          id: 4,
          name: "Clark Kent",
          email: "otrocorreo@gmail.com",
          telefono: "123456789",
          role: "comprador",
          status: "habilitado",
          imageProfile: null,
        },
        {
          id: 5,
          name: "Bruce Wayne",
          email: "bruce@wayne.com",
          telefono: "123456789",
          role: "comprador",
          status: "habilitado",
          imageProfile: null,
        },
        {
          id: 6,
          name: "Diana Prince",
          email: "diana@gmail.com",
          telefono: "123456789",
          role: "comprador",
          status: "habilitado",
          imageProfile: null,
        },
        {
          id: 7,
          name: "Barry Allen",
          email: "barry@gmail.com",
          telefono: "123456789",
          role: "comprador",
          status: "habilitado",
          imageProfile: null,
        },
      ],
    };
  },
  methods: {
    openDetailsSellerApplication(user: any) {
      this.selectedUser = user;

      this.$nextTick(() => {
        this.$bvModal.show("DetailsSellerApplication");
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
