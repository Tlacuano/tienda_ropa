<script lang="ts">
import Vue from 'vue'
import ProductInformation from "@/views/ProductInformation.vue";
import Favorites from "@/views/Favorites.vue";
import ShoppingCart from "@/views/ShoppingCart.vue";
import LandingPage from "@/views/LandingPage.vue";

export default Vue.extend({
  name: 'App',
  components: {
    LandingPage,
    ProductInformation,
    Favorites,
    ShoppingCart
  },
})
</script>

<template>
  <div id="app">
    <b-container fluid>
      <LandingPage />
    </b-container>
  </div>
</template>

<style scoped>
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  height: 100vh;
  width: 100vw;
  overflow-x: hidden;
  font-size: 14px;
}

</style>
