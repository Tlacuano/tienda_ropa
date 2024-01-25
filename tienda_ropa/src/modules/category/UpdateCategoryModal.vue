<template>
    <b-modal id="UpdateCategoryModal" title="Actualizar categoría" centered hide-footer>
        <b-container fluid>
            <b-row>
                <b-col cols="12" md="6">
                    <b-form-group label="Nombre">
                        <b-form-input v-model="category.name" />
                    </b-form-group>
                </b-col>
                <b-col cols="12" md="6">
                    <b-form-group label="Estado">
                        <b-form-select v-model="category.status">
                            <b-form-select-option value="habilitado">Habilitado</b-form-select-option>
                            <b-form-select-option value="deshabilitado">Deshabilitado</b-form-select-option>
                        </b-form-select>
                    </b-form-group>
                </b-col>
            </b-row>
            <hr>
            <b-row>
                <b-col class="text-right">
                    <b-button variant="dark">Guardar</b-button>
                </b-col>
            </b-row>
        </b-container>
    </b-modal>
</template>

<script lang="ts">

import Vue from 'vue';

export default Vue.extend({
    name: 'UpdateCategoryModal',
    data() {
        return {
            category: {
                id: 1,
                name: 'Ropa de baño',
                status: 'habilitado',
            },
        };
    },
});
</script>