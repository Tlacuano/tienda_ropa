<template>
    <b-modal id="editProduct" title="Editar producto" size="xl" hide-footer centered>
        <div>
            <b-form>
                <div class="row">
                    <div class="col-md-6 col-sm-12 p-3 mb-1">
                        <b-form-group id="input-group-1" label="Nombre del producto:" label-for="input-1">
                            <b-form-input id="input-1" type="text" required
                                placeholder="Ingrese el nombre del producto"></b-form-input>
                        </b-form-group>
                        <b-form-group id="input-group-2" label="Descripción del producto:" label-for="input-2">
                            <b-form-input id="input-2" type="text" required
                                placeholder="Ingrese la descripción del producto"></b-form-input>
                        </b-form-group>
                        <b-form-group id="input-group-3" label="Precio del producto:" label-for="input-3">
                            <b-form-input id="input-3" type="number" required
                                placeholder="Ingrese el precio del producto"></b-form-input>
                        </b-form-group>
                        <b-form-group id="input-group-4" label="Piezas disponibles:" label-for="input-4">
                            <b-form-input id="input-4" type="number" required
                                placeholder="Ingrese las prendas disponibles del producto"></b-form-input>
                        </b-form-group>
                    </div>
                    <div class="col-md-6 col-sm-12 p-3 mb-1">
                        <b-form-group id="input-group-5" label="Tallas del producto:" label-for="input-5">
                            <b-form-input id="input-5" type="text" required
                                placeholder="Ingrese Las tallas del producto"></b-form-input>
                        </b-form-group>
                        <b-form-group id="input-group-6" label="Departamento del producto:" label-for="input-6">
                            <b-form-select v-model="selected" :options="options"></b-form-select>
                        </b-form-group>
                        <b-form-group id="input-group-6" label="Categoria del producto:" label-for="input-6">
                            <b-form-select v-model="selected" :options="options2"></b-form-select>
                        </b-form-group>
                        <b-form-group id="input-group-7" label="Imagenes del producto:" label-for="input-7">
                            <b-form-file multiple id="input-7" @change="previewImage"
                                accept=".jpg, .png, .gif" placeholder="Selecciona las imagenes"></b-form-file>
                        </b-form-group>
                    </div>
                </div>

                <div class="row">
                    <div class="col-2" v-for="file in files">
                        <b-img v-if="file" :src="file" fluid alt="Image"></b-img>
                    </div>
                </div>

            </b-form>
        </div>
        <div class="row">
            <div class="col end-0">
                <b-button class="mt-3 end-0" variant="outline-success"
                    @click="$bvModal.hide('insertNewProduct')">Registrar</b-button>
                <b-button class="mt-3 end-0" variant="outline-danger"
                    @click="$bvModal.hide('insertNewProduct')">Cerrar</b-button>
            </div>
        </div>

    </b-modal>
</template>

<script lang="ts">
import Vue from 'vue';
export default Vue.extend({
    data() {
        return {
            selected: null,
            options: [
                { value: null, text: 'Selecciona un departamento' },
                { value: 'a', text: 'Hombre' },
                { value: 'b', text: 'Mujer' },
                { value: 'c', text: 'Niño/Niña' },
            ],
            options2: [
                { value: null, text: 'Selecciona una categoria' },
                { value: 'a', text: 'Camisas' },
                { value: 'b', text: 'Pantalones' },
                { value: 'c', text: 'Zapatos' },
            ],
            files: [] as Array<string | ArrayBuffer | null>,
        }
    },
    methods: {
        previewImage(event: Event) {
            const input = event.target as HTMLInputElement;
            if (input.files) {                
                for (let i = 0; i < input.files.length; i++) {
                    const reader = new FileReader();
                    reader.onload = (e) => {
                        if (e.target) {                            
                            this.files.push(e.target.result);
                        }
                    };
                    reader.readAsDataURL(input.files[i]);
                }
            }
            console.log(this.files);
            
        }
    }
})
</script>

<style  scoped></style>