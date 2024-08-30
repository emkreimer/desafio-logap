<script setup lang="ts">
import { onMounted } from 'vue'
import ProductTable from '../../components/products/ProductTable.vue'
import { getProdutos, allProdutos, loading } from '../../services/produtoService'
import ProductHeader from '@/components/products/ProductHeader.vue'

onMounted(async () => {
  loading.value = true
  allProdutos.value = await getProdutos()
  loading.value = false
})
</script>

<template>
  <VContainer class="d-flex justify-center">
    <VCol>
      <ProductHeader />
      <VDivider class="my-10" />
      <VRow>
        <ProductTable :produtos="allProdutos" :dialog="false" />
      </VRow>
    </VCol>
  </VContainer>
</template>
