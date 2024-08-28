import { getAllProdutos } from "@/api/produto";
import { Categoria } from "@/enums/Categoria";
import { ref} from 'vue'
import type { Produto } from "@/models/Produto";

const novoProduto: Produto = ref({
    id: null,
    nome: '',
    estoque: 0,
    categoria: ''

})
const getProdutos = async () => {
    const produtos = await getAllProdutos()
    return produtos.data ?? []
}

const categoriaOptions: Categoria[] = [Categoria.CEREAIS, Categoria.FRUTAS, Categoria.LEGUMES]

export {getProdutos, categoriaOptions, novoProduto }