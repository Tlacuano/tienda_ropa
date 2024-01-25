<template>
  <div>
    <b-row>
      <b-col class="centered">
        <h1>Mi carrito</h1>
      </b-col>
    </b-row>
    <b-row class="tight-content">
      <b-col cols="12" xl="8">
        <b-row no-gutters>
          <b-col cols="12" v-for="item in cartItems" :key="item.id">
            <b-card
                :title="item.title"
                :img-src="item.image"
                :img-alt="item.title"
                img-left
                tag="article"
                class="mb-2"
            >
              <b-card-text>
                <b-row>
                  <b-col cols="6">
                    <b>Número de artículo:</b> {{ item.productNumber }}
                  </b-col>
                  <b-col cols="6">
                    <b>Catálogo:</b> {{ item.catalogue }}
                  </b-col>
                  <b-col cols="6">
                    <b>Talla:</b> {{ item.selectedSize }}
                  </b-col>
                  <b-col cols="6">
                    <b>Color:</b> {{ item.color }}
                  </b-col>
                  <b-col cols="12" class="product-price">
                    <b class="text-black-50">Total:</b> ${{ item.price * item.quantity }}
                  </b-col>
                </b-row>
                <b-row class="mt-2">
                  <b-col cols="8">
                    <b-select
                        v-model="item.quantity"
                        :options="quantityOptions"
                    >
                    </b-select>
                  </b-col>
                  <b-col cols="4">
                    <b-button @click="removeItemFromCart(item.id)" variant="danger" block>
                      <b-icon icon="trash"></b-icon>
                    </b-button>
                  </b-col>
                </b-row>
              </b-card-text>
            </b-card>
          </b-col>
        </b-row>
      </b-col>
      <b-col cols="12" xl="4">
        <b-card no-body class="mb-2">
          <b-list-group flush>
            <b-list-group-item>
              <b-row>
                <b-col cols="12" v-for="item in cartItems" :key="item.id">
                  <b-row>
                    <b-col cols="7">
                      <b>{{ item.title }}</b>
                    </b-col>
                    <b-col cols="5" class="text-right">
                      ${{ item.price * item.quantity }}
                    </b-col>
                  </b-row>
                </b-col>
              </b-row>
            </b-list-group-item>
            <b-list-group-item>
              <b-row>
                <b-col cols="7">
                  <b>Subtotal</b>
                </b-col>
                <b-col cols="5" class="text-right">
                  ${{ cartItems.reduce((total, item) => total + (item.price * item.quantity), 0) }}
                </b-col>
              </b-row>
            </b-list-group-item>
            <b-list-group-item>
              <b-row>
                <b-col cols="4">
                  <b>Envío</b>
                </b-col>
                <b-col cols="8" class="text-right">
                  $4.99
                </b-col>
              </b-row>
            </b-list-group-item>
            <b-list-group-item>
              <b-row>
                <b-col cols="12">
                  <h4><b>Total</b></h4>
                </b-col>
                <b-col cols="12" class="product-price">
                  ${{ cartItems.reduce((total, item) => total + (item.price * item.quantity), 0) + 4.99 }}
                </b-col>
              </b-row>
            </b-list-group-item>
            <b-list-group-item>
              <b-button variant="dark" block>Continuar con la compra</b-button>
            </b-list-group-item>
            <b-list-group-item>
              <b-row>
                <b-col cols="12">
                  Aceptamos los siguientes métodos de pago:
                </b-col>
                <b-col cols="12">
                  <ul>
                    <li>
                      <b-icon icon="credit-card-2-front" class="mr-2"></b-icon>
                      Visa, MasterCard, American Express
                    </li>
                    <li>
                      <b-icon icon="coin" class="mr-2"></b-icon>
                      PayPal
                    </li>
                    <li>
                      <b-icon icon="bank" class="mr-2"></b-icon>
                      Transferencia bancaria
                    </li>
                    <li>
                      <b-icon icon="cash" class="mr-2"></b-icon>
                      Efectivo
                    </li>
                  </ul>
                </b-col>
              </b-row>
            </b-list-group-item>
          </b-list-group>
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>
<script lang="ts">
export default {
  name: "ShoppingCart",
  data() {
    return {
      quantityOptions: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
      cartItems: [
        {
          id: 1,
          title: "Camisa Regular Fit",
          productNumber: 1234567890,
          image: `https://picsum.photos/300/400?random=$${Math.floor(Math.random() * 100)}`,
          price: 29.99,
          catalogue: "Primavera Santanera",
          color: "Azul claro",
          availableSizes: ["S", "M", "L", "XL"],
          selectedSize: "M",
          quantity: 1
        },
        {
          id: 2,
          title: "Abrigo de lana",
          productNumber: 1234567890,
          image: `https://picsum.photos/300/400?random=$${Math.floor(Math.random() * 100)}`,
          price: 59.99,
          catalogue: "Otoño de Ensueño",
          color: "Negro",
          availableSizes: ["S", "M", "XL"],
          selectedSize: "S",
          quantity: 1
        },
        {
          id: 3,
          title: "Pantalón de pana",
          productNumber: 1234567890,
          image: `https://picsum.photos/300/400?random=$${Math.floor(Math.random() * 100)}`,
          price: 25.99,
          catalogue: "Otoño Hoyo",
          color: "Beige",
          availableSizes: ["M", "L", "XL"],
          selectedSize: "M",
          quantity: 1
        },
        {
          id: 4,
          title: "Minifalda de Mezclilla",
          productNumber: 1234567890,
          image: `https://picsum.photos/300/400?random=$${Math.floor(Math.random() * 100)}`,
          price: 15.99,
          catalogue: "Verano Urano",
          color: "Azul indigo",
          availableSizes: ["S", "M", "L", "XL"],
          selectedSize: "L",
          quantity: 1
        },
        {
          id: 5,
          title: "Chamarra de cuero genuino",
          productNumber: 1234567890,
          image: `https://picsum.photos/300/400?random=$${Math.floor(Math.random() * 100)}`,
          price: 79.99,
          catalogue: "Invierno Invernal",
          color: "Negro Carbón",
          availableSizes: ["S", "M", "L"],
          selectedSize: "M",
          quantity: 1
        }
      ]
    }
  },

  methods: {
    removeItemFromCart(itemId: number) {
      // TODO: Handle remove item from card button press
    }
  }
}
</script>

<style scoped>
.centered {
  text-align: center;
}

.tight-content {
  margin: 1rem 15rem;
}

.card {
  transition: all 0.4s ease-in-out;
}

.card:hover {
  box-shadow: 0 0 11px rgba(33, 33, 33, .2);
  transform: scale(1.01);
}

.card-img-left {
  max-height: 200px;
  object-fit: cover;
}

.card-img-left:hover {
  cursor: pointer;
}

.card-footer {
  background-color: white;
}

.product-price {
  font-weight: bold;
  color: #cc0000;
}

@media (max-width: 1200px) {
  .card-title {
    font-size: 1.2rem;
  }

  .tight-content {
    margin: 1rem 10rem;
  }
}

@media (max-width: 768px) {
  .card-title {
    font-size: 1rem;
  }

  .tight-content {
    margin: 1rem 5rem;
  }
}

@media (max-width: 576px) {
  .card-img-left {
    max-height: 100px;
  }

  .tight-content {
    margin: 1rem 1rem;
  }
}
</style>
