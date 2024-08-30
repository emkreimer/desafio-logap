<script setup lang="ts">
import type { Empresa } from '../../models/Empresa'
import { estoqueTotal, loading } from '@/services/fornecedorService'
import SupplierProducts from './SupplierProducts.vue'

defineProps<{ empresas: Empresa[] }>()
</script>
<template>
  <div class="w-100">
    <VTable fixed-header class="rounded">
      <VOverlay v-model="loading" contained class="d-flex align-center justify-center">
        <VProgressCircular indeterminate />
      </VOverlay>
      <thead>
        <tr>
          <th>Nome</th>
          <th>N° Produtos</th>
          <th>Total em estoque</th>
          <th>Ações</th>
        </tr>
      </thead>
      <tbody v-if="empresas.length > 0">
        <tr v-for="e in empresas" :key="e.id">
          <td>{{ e.nome }}</td>
          <td>{{ e.produtos.length }}</td>
          <td>teste</td>
          <td>
            <SupplierProducts :id="Number(e.id)" />
          </td>
        </tr>
      </tbody>
      <VCard v-else class="py-5 ml-3"> Parece que não há parceiros disponíveis... </VCard>
    </VTable>
  </div>
</template>
