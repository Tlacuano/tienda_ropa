<template>
  <div>
    <b-row>
      <b-col class="centered">
        <h1>Mis favoritos</h1>
      </b-col>
    </b-row>
    <b-row class="tight-content">
      <b-col v-for="favoriteProduct in favorites" :key="favoriteProduct.id" cols="12" xl="3" lg="4" md="6"
             class="favorite-content">
        <b-card
            :img-src="favoriteProduct.image"
            :img-alt="favoriteProduct.title"
            img-top
            tag="article"
            style="max-width: 20rem;"
            class="mb-2"
        >
          <b-card-text>
            <b-row>
              <b-col cols="12">
                <b>Catálogo:</b> {{ favoriteProduct.catalogue }}
              </b-col>
              <b-col cols="12">
                <b>Color:</b> {{ favoriteProduct.color }}
              </b-col>
              <b-col cols="12" class="product-price">
                ${{ favoriteProduct.price }}
              </b-col>
            </b-row>
          </b-card-text>
          <template v-slot:footer>
            <b-row>
              <b-col cols="12">
                <b-select :ref="'sizeSelect-' + favoriteProduct.id" v-model="favoriteProduct.selectedSize"
                          :options="favoriteProduct.availableSizes" class="mb-2">
                  <template v-slot:first>
                    <option :value="null" disabled>Selecciona una talla</option>
                  </template>
                </b-select>
              </b-col>
              <b-col cols="12">
                <b-button variant="dark" block @click="handleProductClick(favoriteProduct)">Agregar al carrito
                </b-button>
              </b-col>
            </b-row>
          </template>
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>
<script lang="ts">
export default {
  name: "Favorites",
  data() {
    return {
      favorites: [
        {
          id: 1,
          title: "Camisa Regular Fit",
          image: `https://picsum.photos/300/400?random=$${Math.floor(Math.random() * 100)}`,
          price: 29.99,
          catalogue: "Primavera Santanera",
          color: "Azul claro",
          availableSizes: ["S", "M", "L", "XL"],
          selectedSize: null
        },
        {
          id: 2,
          title: "Abrigo de lana",
          image: `https://picsum.photos/300/400?random=$${Math.floor(Math.random() * 100)}`,
          price: 59.99,
          catalogue: "Otoño de tu Coño",
          color: "Negro",
          availableSizes: ["S", "M", "L", "XL"],
          selectedSize: null
        },
        {
          id: 3,
          title: "Pantalón de pana",
          image: `https://picsum.photos/300/400?random=$${Math.floor(Math.random() * 100)}`,
          price: 25.99,
          catalogue: "Otoño Follo",
          color: "Beige",
          availableSizes: ["S", "M", "L", "XL"],
          selectedSize: null
        },
        {
          id: 4,
          title: "Minifalda de Mezclilla",
          image: `https://picsum.photos/300/400?random=$${Math.floor(Math.random() * 100)}`,
          price: 15.99,
          catalogue: "Verano Patuano",
          color: "Azul indigo",
          availableSizes: ["S", "M", "L", "XL"],
          selectedSize: null
        },
        {
          id: 5,
          title: "Chamarra de cuero genuino",
          image: `https://picsum.photos/300/400?random=$${Math.floor(Math.random() * 100)}`,
          price: 79.99,
          catalogue: "Invierno Tepongo Elcuerno",
          color: "Negro Carbón",
          availableSizes: ["S", "M", "L", "XL"],
          selectedSize: null
        }
      ]
    }
  },

  methods: {
    handleProductClick(selectedProduct: any) {
      if (selectedProduct.selectedSize === null || selectedProduct.selectedSize === '') {

      }
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

.favorite-content {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 1rem;
}

.card {
  transition: all 0.4s ease-in-out;
}

.card:hover {
  box-shadow: 0 0 11px rgba(33, 33, 33, .2);
  transform: scale(1.01);
}

.card-img-top {
  max-height: 400px;
  object-fit: cover;
}

.card-img-top:hover {
  cursor: pointer;
}

.card-footer {
  background-color: white;
}

.product-price {
  font-weight: bold;
  color: #3f0388;
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


  .tight-content {
    margin: 1rem 1rem;
  }
}
</style>
