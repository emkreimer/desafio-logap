<script setup lang="ts">
import AddProduct from './AddProduct.vue'
import { novoProduto } from '@/services/produtoService'
</script>
<template>
  <VRow>
    <VCol cols="12">
      <VCardTitle class="d-flex justify-center w-100">Lista de Produtos Oferecidos</VCardTitle>
    </VCol>
  </VRow>
  <VRow>
    <VCard class="w-100">
      <VCardText class="d-flex justify-end">
        <AddProduct :produto="novoProduto" :edicao="false" />
      </VCardText>
    </VCard>
  </VRow>
</template>
