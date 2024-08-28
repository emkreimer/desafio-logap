<script setup lang="ts">
import Produto from '../../models/Produto'
import DeleteProduct from './DeleteProduct.vue'

defineProps<{ produtos: Produto[] }>()
</script>
<template>
  <VTable fixed-header class="rounded">
    <thead>
      <tr>
        <th>Nome</th>
        <th>Preço</th>
        <th>Estoque</th>
        <th>Categoria</th>
        <th>Ações</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="p in produtos" :key="p.id">
        <td>{{ p.nome }}</td>
        <td>{{ p.valor ? p.valor : '-' }}</td>
        <td>{{ p.estoque }}</td>
        <td>{{ p.categoria.charAt(0) + p.categoria.substring(1).toLowerCase() }}</td>
        <td>
          <DeleteProduct :produto="p" />
        </td>
      </tr>
    </tbody>
  </VTable>
</template>
