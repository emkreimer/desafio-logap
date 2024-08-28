<script setup lang="ts">
import { ref, onMounted } from 'vue'
import Produto from '../../models/Produto'

const dialog = ref(false)
defineProps<{ produto: Produto }>()
</script>

<template>
  <VBtn color="green-darken-4" size="small" @click="dialog = true" class="mr-2" rounded="lg"
    >New</VBtn
  >

  <VDialog v-model="dialog" width="auto">
    <VCard>
      <VCardTitle>Editar {{ produto.nome }}</VCardTitle>
      <VCardText>
        <VTextField label="Nome" v-model="produto.nome"></VTextField>
        <VTextField label="Preço" v-model="produto.valor"></VTextField>
        <VTextField label="Estoque" type="number" v-model="produto.estoque"></VTextField>
        <VDivider class="my-3" />
        <div class="d-flex justify-end">
          <VBtn variant="outlined" color="warning" @click="dialog = false">Cancelar</VBtn>
          <VBtn color="success" class="ml-3">Salvar</VBtn>
        </div>
      </VCardText>
    </VCard>
  </VDialog>
</template>
