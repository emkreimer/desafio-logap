<script setup lang="ts">
import { onMounted } from 'vue'
import SupplierTable from '../../components/suppliers/SupplierTable.vue'
import { fetchFornecedores, empresas, loading } from '../../services/fornecedorService'
import Header from '../../components/suppliers/Header.vue'
import type { Empresa } from '../../models/Empresa'

onMounted(async () => {
  loading.value = true
  empresas.value = await fetchFornecedores()
  loading.value = false
})
</script>
<template>
  <VContainer class="d-flex justify-center">
    <VCol>
      <Header />
      <VDivider class="my-10" />
      <VRow>
        <SupplierTable :empresas="empresas" />
      </VRow>
    </VCol>
  </VContainer>
</template>
