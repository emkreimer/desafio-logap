<script setup lang="ts">
import { getVowel } from '@/api/vogal'
import { ref } from 'vue'

const texto = ref('')
const show = ref(false)
const res = ref({})

const showAnswer = async () => {
  res.value = await getVowel(texto.value)
  show.value = true
}
</script>
<template>
  <VContainer class="mt-10">
    <VCol>
      <VRow class="d-flex justify-center align-center">
        <VCard class="px-5">
          <VCardTitle class="my-5">Qual é a vogal?</VCardTitle>
          <VCardText>
            As regras:
            <ul class="mt-3 ml-5">
              <li>O caractere retornado deve ser uma vogal;</li>
              <li>O caractere deve ser antecedido por uma consoante;</li>
              <li>A consoante mencionada deve ser antecedida por uma vogal;</li>
              <li>A vogal não pode ser repetida.</li>
            </ul>
            <VDivider class="my-5" />
            <VTextField
              variant="outlined"
              label="String"
              v-model="texto"
              @keyup.enter="showAnswer()"
            >
            </VTextField>
            <div v-show="show">
              <p>
                A vogal encontrada foi a letra <span class="text-green">{{ res.vogal }}</span
                >!
              </p>
            </div>
          </VCardText>
        </VCard>
      </VRow>
    </VCol>
  </VContainer>
</template>
