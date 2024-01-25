<template>
    <b-modal id="InsertDepartmentModal" hide-footer centered title="Registrar departamento">
        <b-row>
            <b-col>
                <b-form-group label="Nombre">
                    <b-form-input placeholder="Ingrese el nombre del departamento" v-model="department.name"></b-form-input>
                </b-form-group>
            </b-col>
        </b-row>
        <b-row>
            <b-col>
                <b-form-group label="Estado">
                    <b-form-select  v-model="department.status">
                        <b-form-select-option value="">Seleccione una opción</b-form-select-option>
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
                <img v-if="department.image" :src="department.image" alt="Imagen seleccionada" class="img-fluid" >
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
    name: 'InsertDepartmentModal',
    data() {
        return {
            department:{
                name: '',
                status: '',
                image: null as any,
            },
        
        }
    },
    methods: {
        async handleImageChange(event : any) {
            const fileInput = event.target;
            const file = fileInput.files[0];
            const fileReader = new FileReader();
            fileReader.readAsDataURL(file);
            fileReader.onload = () => {
                this.department.image = fileReader.result;
            }
        }
    },
    mounted() {

    }
});

</script>