<script setup lang="ts">
import { ref, onMounted } from 'vue'
import SupplierTable from '../../components/suppliers/SupplierTable.vue'
import { fetchFornecedores } from '../../services/fornecedorService'
import Header from '../../components/suppliers/Header.vue'
import type { Empresa } from '../../models/Empresa'

const empresas = ref<Empresa[]>([])
onMounted(async () => {
  empresas.value = await fetchFornecedores()
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
