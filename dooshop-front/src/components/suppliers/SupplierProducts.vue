<script setup lang="ts">
import { ref } from 'vue'
import { fetchProdutosFornecedor } from '../../services/fornecedorService'
import type { Produto } from '../../models/Produto'
import ProductTable from '../products/ProductTable.vue'

const props = defineProps<{ id: number }>()
const dialog = ref(false)
const produtos = ref<Produto[]>([])

const showDialog = async () => {
  produtos.value = await fetchProdutosFornecedor(props.id)
  dialog.value = true
}
</script>

<template>
  <VBtn variant="outlined" color="success" size="small" @click="showDialog()" rounded="lg"
    >...</VBtn
  >

  <VDialog v-model="dialog">
    <ProductTable :produtos="produtos" />
  </VDialog>
</template>
