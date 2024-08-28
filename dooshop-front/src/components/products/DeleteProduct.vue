<script setup lang="ts">
import { ref, onMounted } from 'vue'
import Produto from '../../models/Produto'

const dialog = ref(false)
defineProps<{ produto: Produto }>()
</script>

<template>
  <VBtn variant="outlined" @click="dialog = true">
    <VIcon>mdi-delete</VIcon>
  </VBtn>

  <VDialog v-model="dialog" width="auto">
    <VCard>
      <VCardTitle>Tem certeza de que deseja DELETAR {{ produto.nome }}?</VCardTitle>
    </VCard>
  </VDialog>
</template>
