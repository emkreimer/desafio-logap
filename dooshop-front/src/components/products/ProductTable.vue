<script setup lang="ts">
import Produto from '../../models/Produto'

defineProps<{ produtos: Produto[] }>()
</script>
<template>
  <VTable fixed-header class="rounded">
    <thead>
      <tr>
        <th>Nome</th>
        <th>Preço</th>
        <th>Estoque</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="p in produtos" :key="p.id">
        <td>{{ p.nome }}</td>
        <td>teste</td>
        <td>teste</td>
      </tr>
    </tbody>
  </VTable>
</template>
