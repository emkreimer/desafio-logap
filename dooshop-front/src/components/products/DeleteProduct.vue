<script setup lang="ts">
import { ref } from 'vue'
import { deletarProduto } from '@/services/produtoService'
import { Produto } from '../../models/Produto'

const dialog = ref(false)
defineProps<{ produto: Produto }>()
</script>

<template>
  <VBtn variant="outlined" color="red" size="small" @click="dialog = true" rounded="lg">-</VBtn>

  <VDialog v-model="dialog" width="auto" v-if="produto.id">
    <VCard>
      <VCardTitle class="my-3">Tem certeza de que deseja deletar {{ produto.nome }}?</VCardTitle>
      <VCardText>
        <div class="d-flex justify-end">
          <VBtn variant="outlined" color="warning" @click="dialog = false">Cancelar</VBtn>
          <VBtn color="red" class="ml-3" @click="deletarProduto(produto.id), (dialog = false)"
            >Deletar</VBtn
          >
        </div>
      </VCardText>
    </VCard>
  </VDialog>
</template>
