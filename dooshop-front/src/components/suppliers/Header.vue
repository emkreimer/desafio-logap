<script setup lang="ts">
import { imprimirRelatorio } from '../../services/produtoService'
</script>

<template>
  <VRow>
    <VCol>
      <VCardTitle class="d-flex justify-center w-100">Fornecedores Parceiros</VCardTitle>
    </VCol>
  </VRow>
  <VRow>
    <VCard class="w-100">
      <VCardText class="d-flex justify-end">
        <VBtn
          variant="outlined"
          color="success"
          size="small"
          rounded="lg"
          @click="imprimirRelatorio()"
          >Gerar relatório</VBtn
        >
      </VCardText>
    </VCard>
  </VRow>
</template>
