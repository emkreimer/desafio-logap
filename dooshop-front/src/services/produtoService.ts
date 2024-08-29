import { getAllProdutos, salvar, deletar } from "@/api/produto";
import { Categoria } from "@/enums/Categoria";
import { ref} from 'vue'
import type { Produto } from "@/models/Produto";

const allProdutos = ref<Produto[]>([])
const novoProduto= ref<Produto>({
    nome: '',
    estoque: 0,
    categoria: Categoria.CEREAIS
})

const getProdutos = async () => {
    const produtos = await getAllProdutos()
    return produtos.data ?? []
}

const salvarProduto = async (produto: Produto, categoria: any) => {
    produto.categoria = categoria
    await salvar(produto)
    allProdutos.value = await getProdutos()

}

const deletarProduto = async (id: number) => {
    const res = await deletar(id)
    allProdutos.value = await getProdutos()
    return res.data
    
}

const categoriaOptions = Object.keys(Categoria).map(key => ({
    text: key,
  }));



export {getProdutos, categoriaOptions, novoProduto, salvarProduto, allProdutos, deletarProduto }