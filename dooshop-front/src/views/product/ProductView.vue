<script setup lang="ts">
import { ref, onMounted } from 'vue'
import ProductTable from '../../components/products/ProductTable.vue'
import Produto from '../../models/Produto'
import { getProdutos } from '../../services/produtoService'

const allProdutos = ref<Produto[]>([])
onMounted(async () => {
  allProdutos.value = await getProdutos()
})
</script>

<template>
  <VContainer class="d-flex justify-center">
    <ProductTable :produtos="allProdutos" />
  </VContainer>
</template>
