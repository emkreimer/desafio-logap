import { createRouter, createWebHistory } from 'vue-router'
import ProductView from '../views/product/ProductView.vue'
import FornecedorView from '../views/fornecedor/FornecedorView.vue'
import VowelView from '../views/VowelView.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: VowelView
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
