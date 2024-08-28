<script setup lang="ts">
import type Empresa from '../../models/Empresa'
import { sumEstoque } from '@/services/fornecedorService'

defineProps<{ empresas: Empresa[] }>()
</script>
<template>
  <div class="w-100">
    <VTable fixed-header class="rounded">
      <thead>
        <tr>
          <th>Nome</th>
          <th>N° Produtos</th>
          <th>Total em estoque</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="e in empresas" :key="e.id">
          <td>{{ e.nome }}</td>
          <td>{{ e.produtos.length }}</td>
          <td>{{ sumEstoque(e) }}</td>
        </tr>
      </tbody>
    </VTable>
  </div>
</template>
