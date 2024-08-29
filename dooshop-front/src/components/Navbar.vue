<script setup lang="ts"></script>
<template>
  <VCard color="purple-darken-4" class="pt-4 px-3">
    <VToolbar color="purple-darken-4" class="d-flex">
      <v-toolbar-title class="text-h4">Doo Shop</v-toolbar-title>
      <VSpacer />
    </VToolbar>
    <div>
      <VTabs>
        <VTab to="/">Qual a vogal</VTab>
        <VTab to="/produtos">Nossos produtos</VTab>
        <VTab to="/fornecedores">Nossos fornecedores</VTab>
      </VTabs>
    </div>
  </VCard>
</template>

<style scoped>
.navbar {
  background-color: #333;
  padding: 1rem;
  color: white;
}

.navbar-brand {
  font-size: 1.5rem;
  color: white;
  text-decoration: none;
  margin-right: 1rem;
}

.navbar-nav {
  list-style: none;
  display: flex;
  gap: 1rem;
}

.nav-item {
  margin: 0;
}

.nav-link {
  color: white;
  text-decoration: none;
  transition: color 0.3s;
}

.nav-link:hover {
  color: #ddd;
}
</style>
