<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import Navbar from './components/Navbar.vue'
</script>

<template>
  <v-app>
    <v-main>
      <Navbar />
      <RouterView />
    </v-main>
  </v-app>
</template>

<style>
html,
body,
#app {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
}
</style>
