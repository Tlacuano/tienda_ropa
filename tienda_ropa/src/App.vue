<script lang="ts">
import Vue from 'vue'
import ProductCategories from "@/views/ProductCategories.vue";


export default Vue.extend({
  name: 'App',
  components: {
    ProductCategories
  },
})
</script>

<template>
  <div id="app">
    <b-container fluid>
      <ProductCategories />
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