import Vue from 'vue'

import App from './App.vue'
import router from './router'

import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'

// Importacion de estilos de bootstrap
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue)
Vue.use(IconsPlugin)


//importacion de fontawesome
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faUserSecret , faPen, faTrash, faCircleUp, faCircleDown } from '@fortawesome/free-solid-svg-icons'

library.add(faUserSecret, faPen, faTrash, faCircleUp, faCircleDown);
Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.config.productionTip = false

//importacion css global
import './utils/main.css'


new Vue({
  router,
  render: (h) => h(App)
}).$mount('#app')
