<template>
  <div>
    <b-row class="tight-content">
      <b-col cols="12" xl="6">
        <!-- Images -->
        <b-carousel
            id="product-carousel"
            controls
            indicators
            background="#ababab"
            fade
            img-width="480"
            img-height="1024"
            style="text-shadow: 1px 1px 2px #333;"
        >
          <b-carousel-slide
              class="max-height"
              v-for="(image, index) in product.images"
              :key="index"
              :img-src="image"
              :alt="product.title"
          ></b-carousel-slide>
        </b-carousel>
      </b-col>
      <!-- Description -->
      <b-col cols="12" xl="6">
        <b-card
            :title="product.title"
            :sub-title="product.catalogue"
        >
          <b-card-text>
            <b-row>
              <b-col cols="12">
                <b-card-text>
                  <b>Descripción:</b> {{ product.description }}
                </b-card-text>
              </b-col>
              <b-col cols="12">
                <b-card-text>
                  <small>
                    Número de producto: {{ product.productNumber }}
                  </small>
                </b-card-text>
              </b-col>
              <b-col cols="12">
                <b-card-text>
                  <b>Disponibles: </b>
                  <b-badge pill variant="dark">
                    {{ product.availableQuantity }}
                  </b-badge>
                </b-card-text>
              </b-col>
              <b-col cols="12">
                <b-card-text>
                  <b-row no-gutters>
                    <b-col cols="12">
                      <b>Tallas disponibles:</b>
                    </b-col>
                    <b-col cols="12">
                      <b-form-radio-group
                          class="blocky"
                          v-model="product.selectedSize"
                          :options="product.availableSizes"
                          name="size"
                          buttons
                          button-variant="outline-dark"
                          size="sm"
                      ></b-form-radio-group>
                    </b-col>
                  </b-row>
                </b-card-text>
              </b-col>
              <b-col cols="12">
                <b-card-text>
                  <b-row no-gutters>
                    <b-col cols="12">
                      <b>Colores disponibles:</b>
                    </b-col>
                    <b-col cols="12">
                      <b-form-select
                          class="blocky"
                          v-model="product.color"
                          :options="product.availableColors"
                          size="sm"
                      >
                        <template #first>
                          <b-form-select-option
                              :value="null"
                              disabled
                          >Selecciona un color
                          </b-form-select-option
                          >
                        </template>
                      </b-form-select>
                    </b-col>
                  </b-row>
                </b-card-text>
              </b-col>
              <b-col cols="12">
                <b-card-text>
                  <b>Cantidad:</b>
                  <b-input-group>
                    <b-input-group-prepend>
                      <b-button
                          variant="outline-dark"
                          @click="product.quantity > 1 ? product.quantity-- : null"
                      >
                        <b-icon icon="dash"></b-icon>
                      </b-button>
                    </b-input-group-prepend>
                    <b-form-input
                        v-model="product.quantity"
                        type="number"
                        min="1"
                        max="product.availableQuantity"
                        class="text-center"
                        readonly
                    ></b-form-input>
                    <b-input-group-append>
                      <b-button
                          variant="outline-dark"
                          @click="product.quantity < product.availableQuantity ? product.quantity++ : null"
                      >
                        <b-icon icon="plus"></b-icon>
                      </b-button>
                    </b-input-group-append>
                  </b-input-group>
                </b-card-text>
              </b-col>
              <b-col class="mt-2" cols="12">
                <b-card-text>
                  <b>Costo:</b>
                  <b class="product-price">
                    ${{ (product.price * product.quantity).toFixed(2) }}
                  </b>
                </b-card-text>
              </b-col>
            </b-row>
          </b-card-text>
          <b-card-footer>
            <b-row no-gutters>
              <b-col cols="12">
                <b-button :disabled="!canAddToCart(this.product)" variant="dark" block>
                  <b-icon icon="cart-plus"></b-icon>
                  Agregar al carrito
                </b-button>
              </b-col>
            </b-row>
          </b-card-footer>
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>
<script lang="ts">
export default {
  name: "ProductInformation",
  data() {
    return {
      product: {
        id: 1,
        title: "Abrigo Regular Fit",
        description: "Abrigo en mezcla afieltrada de lana suave. Modelo con solapas de muesca y botones al frente. Botones decorativos en los puños y abertura sencilla en la parte posterior. Bolsillos frontales con solapa y un bolsillo interior. Forro de sarga.",
        images: [
          `https://picsum.photos/300/400?random=${Math.floor(Math.random() * 100)}`,
          `https://picsum.photos/300/400?random=${Math.floor(Math.random() * 100)}`,
          `https://picsum.photos/300/400?random=${Math.floor(Math.random() * 100)}`,
          `https://picsum.photos/300/400?random=${Math.floor(Math.random() * 100)}`,
          `https://picsum.photos/300/400?random=${Math.floor(Math.random() * 100)}`,
        ],
        price: 39.99,
        availableQuantity: 8,
        quantity: 1,
        productNumber: "123456",
        catalogue: "Ropa de Copa",
        availableSizes: ["XS", "S", "M", "L", "XL"],
        selectedSize: null,
        availableColors: ["Marrón", "Blanco", "Beige", "Negro", "Carbón"],
        color: null,
      }
    }
  },

  methods: {
    canAddToCart(product: any) {
      return !(!product.selectedSize || !product.color || !product.quantity);
    }
  }
}
</script>

<style scoped>
.centered {
  text-align: center;
}

.max-height {
  max-height: 95vh;
}

.blocky {
  width: 100%;
}

.tight-content {
  margin: 1rem 13rem;
}

.card-text {
  margin-top: 1rem;
}

.card-footer {
  background-color: white;
  padding-left: 0;
  padding-right: 0;
  padding-bottom: 0;
}

.product-price {
  font-weight: bold;
  color: #cc0000;
}

@media (max-width: 1200px) {
  .card-title {
    font-size: 1.2rem;
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
