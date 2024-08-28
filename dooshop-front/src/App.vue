<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import HelloWorld from './components/HelloWorld.vue'
import Navbar from './components/Navbar.vue'
import ProductTable from './components/products/ProductTable.vue'
</script>

<template>
  <VContainer fluid>
    <Navbar />
    <RouterView />
  </VContainer>
</template>

<style>
html,
body,
#app {
  height: 100%;
  width: 100%;
  margin: 0;
}
</style>
