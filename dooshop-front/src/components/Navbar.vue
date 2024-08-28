<template>
  <nav class="d-flex w-100 navbar rounded">
    <div class="container">
      <a href="/" class="navbar-brand">Doo App</a>
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link to="/" class="nav-link">Home</router-link>
        </li>
        <!-- <li class="nav-item">
          <router-link to="/products" class="nav-link">Products</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/about" class="nav-link">About</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/contact" class="nav-link">Contact</router-link>
        </li> -->
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
