<template>
  <div>
    <b-row class="tight-content">
      <b-col>
        <b-carousel
            id="carousel-1"
            :interval="4000"
            controls
            indicators
            style="text-shadow: 1px 1px 2px #333;"
        >
          <b-carousel-slide
              caption="Gran rebaja en pantalones"
              :img-src="'https://picsum.photos/1200/500?random=' + Math.floor(Math.random() * 100)"
          ></b-carousel-slide>
          <b-carousel-slide
              caption="Outlet de primavera"
              :img-src="'https://picsum.photos/1200/500?random=' + Math.floor(Math.random() * 100)"
          ></b-carousel-slide>
          <b-carousel-slide
              caption="Descuentos en chamarras de piel"
              :img-src="'https://picsum.photos/1200/500?random=' + Math.floor(Math.random() * 100)"
          ></b-carousel-slide>
        </b-carousel>
      </b-col>
    </b-row>
    <b-row class="tight-content">
      <b-col class="mb-3" cols="12">
        <h2 class="centered">Mas vendidos</h2>
      </b-col>
      <b-col v-for="product in products" :key="product.id" cols="12" xl="3" lg="4" md="6"
             class="products-content">
        <b-card
            :img-src="product.image"
            :img-alt="product.title"
            img-top
            tag="article"
            style="max-width: 20rem;"
            class="mb-2"
            body-class="p-2"
        >
          <b-card-text>
            <b-row no-gutters>
              <b-col>
                <b-row>
                  <b-col cols="10">
                    <b>{{ product.title }}</b>
                  </b-col>
                  <b-col cols="12">
                    ${{ product.price }}
                  </b-col>
                  <b-col cols="12">
                    {{ product.catalogue }}
                  </b-col>
                  <b-col cols="12">
                    {{ product.color }}
                  </b-col>
                </b-row>
              </b-col>
              <b-col cols="2">
                <b-button variant="light" size="sm" @click="addToFavorites(product)">
                  <b-icon :icon="product.isFavorite ? 'heart-fill' : 'heart'" variant="dark"></b-icon>
                </b-button>
              </b-col>
            </b-row>
          </b-card-text>
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>
<script lang="ts">
import Vue from "vue";

export default Vue.extend({
      name: "ProductCategories",
      data() {
        return {
          products: [
            {
              id: 1,
              title: "Camisa Regular Fit",
              image: `https://picsum.photos/300/400?random=$${Math.floor(Math.random() * 100)}`,
              price: 29.99,
              catalogue: "Primavera Santanera",
              color: "Azul claro",
              availableSizes: ["S", "M", "L", "XL"],
              selectedSize: null,
              isFavorite: false
            },
            {
              id: 2,
              title: "Abrigo de lana",
              image: `https://picsum.photos/300/400?random=$${Math.floor(Math.random() * 100)}`,
              price: 59.99,
              catalogue: "Otoño de Ensueño",
              color: "Negro",
              availableSizes: ["S", "M", "XL"],
              selectedSize: null,
              isFavorite: false
            },
            {
              id: 3,
              title: "Pantalón de pana",
              image: `https://picsum.photos/300/400?random=$${Math.floor(Math.random() * 100)}`,
              price: 25.99,
              catalogue: "Otoño Hoyo",
              color: "Beige",
              availableSizes: ["M", "L", "XL"],
              selectedSize: null,
              isFavorite: false
            },
            {
              id: 4,
              title: "Minifalda de Mezclilla",
              image: `https://picsum.photos/300/400?random=$${Math.floor(Math.random() * 100)}`,
              price: 15.99,
              catalogue: "Verano Urano",
              color: "Azul indigo",
              availableSizes: ["S", "M", "L", "XL"],
              selectedSize: null,
              isFavorite: false
            },
            {
              id: 5,
              title: "Chamarra de cuero genuino",
              image: `https://picsum.photos/300/400?random=$${Math.floor(Math.random() * 100)}`,
              price: 79.99,
              catalogue: "Invierno Invernal",
              color: "Negro Carbón",
              availableSizes: ["S", "M", "L"],
              selectedSize: null,
              isFavorite: false
            }
          ],
        }
      },

      methods: {
        handleProductClick(selectedProduct: any) {
          if (selectedProduct.selectedSize === null || selectedProduct.selectedSize === '') {
            // TODO: Handle the product click
          }
        },

        addToFavorites(product: any) {
          // search in products
          const foundProduct = this.products.indexOf(product)
          if (foundProduct != -1) {
            this.products[foundProduct].isFavorite = !this.products[foundProduct].isFavorite
          }
        }
      }
    }
)
</script>

<style scoped>
.centered {
  text-align: center;
}

.tight-content {
  margin: 1rem 10rem;
}

.products-content {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 1rem;
}

.card {
  transition: all 0.4s ease-in-out;
  height: 100%;
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

@media (max-width: 1200px) {
  .card-title {
    font-size: 1.2rem;
  }

  .tight-content {
    margin: 1rem 8rem;
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
