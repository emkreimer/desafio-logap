<script setup lang="ts">
import ProductTable from '../../components/products/ProductTable.vue'
import { getProdutos } from '../../services/produtoService'

const allProdutos = await getProdutos()
</script>

<template>
  <ProductTable />
</template>
