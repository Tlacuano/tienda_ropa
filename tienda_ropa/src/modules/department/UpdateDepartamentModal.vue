<template>
    <b-modal id="UpdateDepartamentModal" hide-footer centered title="Editar información">
        <b-row >
            <b-col>
                <b-form-group label="Nombre">
                    <b-form-input v-model="department.name" type="text" placeholder="Nombre del departamento"></b-form-input>
                </b-form-group>
            </b-col>
        </b-row>
        <b-row>
            <b-col>
                <b-form-group label="Estado">
                    <b-form-select v-model="department.status">
                        <b-form-select-option value="habilitado">Habilitado</b-form-select-option>
                        <b-form-select-option value="deshabilitado">Deshabilitado</b-form-select-option>
                    </b-form-select>
                </b-form-group>
            </b-col>
        </b-row>
        <b-row class="mb-4">
            <b-col>
                <b-form-group label="Imagen">
                    <b-form-file  placeholder="Seleccione una imagen" @change="handleImageChange($event)"></b-form-file>
                </b-form-group>
            </b-col>
        </b-row>
        <b-row>
            <b-col class="text-center">
                <img :src="newImage ? newImage : department.image" alt="Imagen seleccionada" class="img-fluid" >
            </b-col>
        </b-row>
        <hr>
        <b-row>
            <b-col class="text-right">
                <b-button variant="dark" class="mt-3">Guardar</b-button>
            </b-col>
        </b-row>
    </b-modal>
</template>

<script lang="ts">
import Vue from 'vue';

export default Vue.extend({
    name: 'UpdateDepartamentModal',
    data() {
        return {
            department:{
                id: 1,
                name: 'Hombre',
                status: 'habilitado',
                image: 'https://cdn2.coppel.com/images/emarketing/landings/2022/octubre/tendencias-hombres/Mobile/Bloques-1/2a_bloques1_m_kazbet1.jpg',
            },
            newImage: null as any,
        
        }
    },
    methods: {
        async handleImageChange(event : any) {
            const fileInput = event.target;
      
            if (fileInput.files.length > 0) {
                const selectedFile = fileInput.files[0];

                const reader = new FileReader();

                reader.onload = (e) => {
                    this.newImage = e.target!.result 
                };
                reader.readAsDataURL(selectedFile);
                
            }
        },
    }
});
</script>

