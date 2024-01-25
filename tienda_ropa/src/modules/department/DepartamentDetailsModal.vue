<template>
    <b-modal id="DepartamentDetailsModal" hide-footer centered>
        <b-row class="mt-3">
            <b-col class="text-center ">
                <b-img class="image-department" :src="department.image" fluid alt="Fluid image"></b-img>
            </b-col>
        </b-row>
        <hr>
        <b-row>
            <b-col class="text-center">
                <h4 class="mt-1">{{department.name}}</h4>
            </b-col>
        </b-row>
    </b-modal>
</template>

<script lang="ts">
import Vue from 'vue';

export default Vue.extend({
    name: 'DepartamentDetailsModal',
    data() {
        return {
            department:{
                id: 1,
                name: 'Hombre',
                status: 'habilidato',
                image: 'https://cdn2.coppel.com/images/emarketing/landings/2022/octubre/tendencias-hombres/Mobile/Bloques-1/2a_bloques1_m_kazbet1.jpg',
            }
        
        }
    },
    methods: {

    },
    mounted() {

    }
});

</script>

<style>
 

    .image-department {
        box-shadow: 1px 3px 5px 5px rgba(0, 0, 0, 0.1);
    }
</style>