<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import HelloWorld from './components/HelloWorld.vue'
import Navbar from './components/Navbar.vue'
import ProductTable from './components/products/ProductTable.vue'
</script>

<template>
  <VContainer>
    <Navbar />
    <ProductTable />
  </VContainer>
</template>
