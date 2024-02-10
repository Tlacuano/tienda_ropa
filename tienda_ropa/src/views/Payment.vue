<template>
    <b-container fluid>
        <b-row class="mt-4">
                <b-col id="tittle">
                    <h1>Metodo de pago</h1>
                </b-col>
            </b-row>
            

    <b-row class="mt-4">
      <b-col>
        <h2>Productos en el Carrito</h2>
        <b-list-group>
          <b-list-group-item v-for="(product, index) in cartProducts" :key="index">
            {{ product.name }} - {{ product.price }} USD
          </b-list-group-item>
        </b-list-group>
      </b-col>
    </b-row>
    <b-row class="mt-4">
        <b-col>
        <h1>Total a Pagar</h1>
        <p>{{ totalAmount }} USD</p>
      </b-col>
            </b-row>
    

    <b-row class="mt-4">
      <b-col id="paymentMethod">
        <h2>Método de Pago</h2>

        <b-form-group label="Selecciona un Método de Pago">
          <b-form-select v-model="selectedPaymentMethod" :options="paymentMethods"></b-form-select>
        </b-form-group>
      </b-col>
    </b-row>

    <b-row class="mt-4">
      <b-col>
        <b-button @click="goToShipping" variant="primary">Siguiente</b-button>
      </b-col>
    </b-row>
  </b-container>
</template>

<script lang="ts">

import Vue from 'vue'


export default Vue.extend({
  data() {
    return {
      totalAmount: 0,
      selectedPaymentMethod: null,
      paymentMethods: ['Tarjeta de Crédito', 'PayPal', 'Otro'],
      cartProducts: [
        { name: 'Camisa', price: 30 },
        { name: 'Pantalón', price: 40 },
      ],
    };
  },
  computed: {
    totalAmount() {
      return this.cartProducts.reduce((total, product) => total + product.price, 0);
    },
  },
  methods: {
    goToShipping() {
      if (this.selectedPaymentMethod) {
        this.$router.push({ name: 'shippingAddress' });
      } else {
        alert('Por favor, selecciona un método de pago');
      }
    },
  },
});
</script>