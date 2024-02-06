<script lang="ts">
import Vue from 'vue'
import LandingPageProductManagment from './views/LandingPageProductManagment.vue';

export default Vue.extend({
  name: 'App',
  components: {   
    LandingPageProductManagment
},
})
</script>

<template>
  <div id="app">
    <b-container fluid>  
      <LandingPageProductManagment />        
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