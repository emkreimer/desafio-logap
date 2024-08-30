<script setup lang="ts">
import { ref, onMounted } from 'vue'
import type { Produto } from '../../models/Produto'
import { Categoria } from '../../enums/Categoria'
import { categoriaOptions, salvarProduto } from '../../services/produtoService'

const props = defineProps<{ produto: Produto; edicao: boolean }>()

const selectedCategoria = ref<Categoria>(props.produto.categoria)
const dialog = ref(false)
</script>

<template>
  <VBtn
    variant="outlined"
    color="success"
    size="small"
    @click="dialog = true"
    class="mr-2"
    rounded="lg"
  >
    {{ edicao ? '+' : 'Novo produto' }}
  </VBtn>

  <VDialog v-model="dialog" width="auto">
    <VCard>
      <VCardTitle>{{
        edicao ? 'Editar ' + props.produto.nome : 'Cadastrar novo produto'
      }}</VCardTitle>
      <VCardText>
        <VTextField label="Nome" v-model="props.produto.nome"></VTextField>
        <VTextField label="Preço" type="number" v-model="props.produto.valor"></VTextField>
        <VTextField label="Estoque" type="number" v-model="props.produto.estoque"></VTextField>

        <VSelect
          label="Categoria"
          v-model="selectedCategoria"
          :items="categoriaOptions"
          item-title="text"
          item-value="text"
        />
        <VDivider class="my-3" />
        <div class="d-flex justify-end">
          <VBtn variant="outlined" color="warning" @click="dialog = false">Cancelar</VBtn>
          <VBtn
            color="success"
            class="ml-3"
            @click="salvarProduto(props.produto, selectedCategoria), (dialog = false)"
            >Salvar</VBtn
          >
        </div>
      </VCardText>
    </VCard>
  </VDialog>
</template>
