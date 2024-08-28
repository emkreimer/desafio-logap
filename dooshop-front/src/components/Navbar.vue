<template>
  <nav class="w-100 navbar rounded">
    <div class="container my-3">
      <a href="/" class="navbar-brand">
        <span class="text-bold">Doo App</span>
      </a>
      <ul class="navbar-nav mt-4">
        <li class="nav-item">
          <router-link to="/produtos" class="nav-link">Nossos produtos</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/fornecedores" class="nav-link">Nossos fornecedores</router-link>
        </li>
      </ul>
    </div>
  </nav>
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
