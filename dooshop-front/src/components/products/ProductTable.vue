<script setup lang="ts">
import { Produto } from '../../models/Produto'
import DeleteProduct from './DeleteProduct.vue'
import AddProduct from './AddProduct.vue'
import { loading } from '../../services/produtoService'

const props = defineProps<{ produtos: Produto[]; dialog: boolean }>()
</script>
<template>
  <div class="w-100">
    <VTable fixed-header class="rounded">
      <VOverlay v-model="loading" class="d-flex align-center justify-center">
        <VProgressCircular indeterminate />
      </VOverlay>
      <thead>
        <tr>
          <th>Nome</th>
          <th>Preço</th>
          <th>Estoque</th>
          <th>Categoria</th>
          <th v-if="!dialog">Ações</th>
        </tr>
      </thead>

      <tbody v-if="produtos.length > 0">
        <tr v-for="p in produtos" :key="p.id">
          <td>{{ p.nome }}</td>
          <td>{{ p.valor ? 'R$ ' + p.valor : '-' }}</td>
          <td>{{ p.estoque }}</td>
          <td>{{ p.categoria.charAt(0) + p.categoria.substring(1).toLowerCase() }}</td>
          <td v-if="!dialog">
            <AddProduct :produto="p" :edicao="true" />
            <DeleteProduct :produto="p" />
          </td>
        </tr>
      </tbody>
      <VCard v-else class="py-5 ml-3"> Não há produtos disponíveis por enquanto. </VCard>
    </VTable>
  </div>
</template>
