<script setup lang="ts">
import { ref, onMounted } from 'vue'
import type Produto from '../../models/Produto'
import { categoriaOptions } from '../../services/produtoService'

defineProps<{ produto: Produto; edicao: boolean }>()

const dialog = ref(false)
</script>

<template>
  <VBtn color="success" size="small" @click="dialog = true" class="mr-2" rounded="lg">
    {{ edicao ? 'Add' : 'Novo produto' }}
  </VBtn>

  <VDialog v-model="dialog" width="auto">
    <VCard>
      <VCardTitle>Editar {{ produto.nome }}</VCardTitle>
      <VCardText>
        <VTextField label="Nome" v-model="produto.nome"></VTextField>
        <VTextField label="Preço" v-model="produto.valor"></VTextField>
        <VTextField label="Estoque" type="number" v-model="produto.estoque"></VTextField>
        <VSelect label="Categoria" v-model="produto.categoria" :items="categoriaOptions" />
        <VDivider class="my-3" />
        <div class="d-flex justify-end">
          <VBtn variant="outlined" color="warning" @click="dialog = false">Cancelar</VBtn>
          <VBtn color="success" class="ml-3">Salvar</VBtn>
        </div>
      </VCardText>
    </VCard>
  </VDialog>
</template>
