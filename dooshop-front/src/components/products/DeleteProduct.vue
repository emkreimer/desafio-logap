<script setup lang="ts">
import { ref, onMounted } from 'vue'
import Produto from '../../models/Produto'

const dialog = ref(false)
defineProps<{ produto: Produto }>()
</script>

<template>
  <VBtn variant="outlined" color="red" size="small" @click="dialog = true" rounded="lg">-</VBtn>

  <VDialog v-model="dialog" width="auto">
    <VCard>
      <VCardTitle class="my-3">Tem certeza de que deseja deletar {{ produto.nome }}?</VCardTitle>
      <VCardText>
        <div class="d-flex justify-end">
          <VBtn variant="outlined" color="warning" @click="dialog = false">Cancelar</VBtn>
          <VBtn color="red" class="ml-3">Deletar</VBtn>
        </div>
      </VCardText>
    </VCard>
  </VDialog>
</template>
