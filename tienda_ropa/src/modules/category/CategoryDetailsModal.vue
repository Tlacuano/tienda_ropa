<template>
    <b-modal id="CategoryDetailsModal" title="Categoría" centered hide-footer>
        <b-container fluid>
            <b-row>
                <b-col cols="12" md="6">
                    <b-form-group label="Nombre">
                        <b-form-input v-model="category.name" disabled />
                    </b-form-group>
                </b-col>
                <b-col cols="12" md="6">
                    <b-form-group label="Estado">
                        <b-form-input v-model="category.status" disabled />
                    </b-form-group>
                </b-col>
            </b-row>
        </b-container>
    </b-modal>
</template>

<script lang="ts">
import Vue from 'vue';

export default Vue.extend({
    name: 'CategoryDetailsModal',
    data() {
        return {
            category: {
                id: 1,
                name: 'Ropa de baño',
                status: 'habilidato',
            },
        };
    },
});
</script>