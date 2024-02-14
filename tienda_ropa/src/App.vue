<script lang="ts">
import Vue from 'vue'

export default Vue.extend({
  name: 'App',
  components: {   
    UserManagement : () => import('@/modules/user/UserManagement.vue'),
    DepartmentsManagement : () => import('@/modules/department/DepartmentsManagement.vue'),
    CategoriesManagement : () => import('@/modules/category/CategoriesManagement.vue'),
},


})
</script>

<template>
  <div id="app">

    <b-container fluid>  
      <CategoriesManagement />
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