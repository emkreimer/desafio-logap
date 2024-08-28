<script setup lang="ts">
import { ref, onMounted } from 'vue'
import SupplierTable from '../../components/suppliers/SupplierTable.vue'
import { fetchFornecedores } from '../../services/fornecedorService'
import type Empresa from '../../models/Empresa'

const empresas = ref<Empresa[]>([])
onMounted(async () => {
  empresas.value = await fetchFornecedores()
})
</script>
<template>
  <VContainer class="d-flex justify-center">
    <SupplierTable :empresas="empresas" />
  </VContainer>
</template>
