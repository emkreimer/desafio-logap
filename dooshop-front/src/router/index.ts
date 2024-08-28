import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ProductView from '../views/product/ProductView.vue'
import FornecedorView from '../views/fornecedor/FornecedorView.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: ProductView
    },
    {
      path: '/produtos',
      name: 'produto',
      component: ProductView
    },
    {
      path: '/fornecedores',
      name: 'fornecedor',
      component: FornecedorView
    },
  ]
})

export default router
