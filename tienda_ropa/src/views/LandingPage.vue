<template>
  <div>
    <b-row class="p-4">
      <b-col class="centered">
        <h1>Tienda de ropa</h1>
      </b-col>
    </b-row>
    <b-row class="tight-content">
      <b-col class="mb-2" cols="12" xl="4">
        <b-card
            overlay
            :img-src="'https://picsum.photos/300/400?random=' + Math.floor(Math.random() * 100) +'&grayscale&blur'"
            img-alt="Mujer"
            text-variant="white"
        >
          <b-card-text class="centered">
            <p class="mb-0">Ir a departamento</p>
            <h1>MUJER</h1>
          </b-card-text>
        </b-card>
      </b-col>
      <b-col class="mb-2" cols="12" xl="4">
        <b-card
            overlay
            :img-src="'https://picsum.photos/300/400?random=' + Math.floor(Math.random() * 100) +'&grayscale&blur'"
            img-alt="Mujer"
            text-variant="white"
        >
          <b-card-text class="centered">
            <p class="mb-0">Ir a departamento</p>
            <h1>HOMBRE</h1>
          </b-card-text>
        </b-card>
      </b-col>
      <b-col class="mb-2" cols="12" xl="4">
        <b-card
            overlay
            :img-src="'https://picsum.photos/300/400?random=' + Math.floor(Math.random() * 100) +'&grayscale&blur'"
            img-alt="Mujer"
            text-variant="white"
        >
          <b-card-text class="centered">
            <p class="mb-0">Ir a departamento</p>
            <h1>NIÑOS</h1>
          </b-card-text>
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>
<script lang="ts">
export default {
  name: "LandingPage",
  data() {
    return {}
  },
}
</script>

<style scoped>
.centered {
  text-align: center;
}

.tight-content {
  margin: 1rem 3rem;
}

.card {
  transition: all 0.4s ease-in-out;
}

.card:hover {
  box-shadow: 0 0 11px rgba(33, 33, 33, .2);
  transform: scale(1.01);
}

@media (max-width: 1199px) {
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
