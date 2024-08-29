<script setup lang="ts">
import { ref, onMounted } from 'vue'
import ProductTable from '../../components/products/ProductTable.vue'
import Produto from '../../models/Produto'
import { getProdutos, allProdutos } from '../../services/produtoService'
import ProductHeader from '@/components/products/ProductHeader.vue'

onMounted(async () => {
  allProdutos.value = await getProdutos()
})
</script>

<template>
  <VContainer class="d-flex justify-center">
    <VCol>
      <ProductHeader />
      <VDivider class="my-10" />
      <VRow>
        <ProductTable :produtos="allProdutos" />
      </VRow>
    </VCol>
  </VContainer>
</template>
