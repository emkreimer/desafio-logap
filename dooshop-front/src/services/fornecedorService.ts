import { getFornecedores, getProdutoFornecedores, getEstoqueTotalFornecedor } from "@/api/fornecedor";
import { ref } from 'vue'
import type {Empresa} from '../models/Empresa'

const loading = ref(false)
const empresas = ref<Empresa[]>([])
const estoqueTotal = ref<Record<number, number>>({})


const fetchFornecedores = async () => {
    const res = await getFornecedores()
    return res.data
}

const getEstoqueFornecedor = async (id: number) => {
    return await getEstoqueTotalFornecedor(id);
}

const fetchProdutosFornecedor = async (id: number) => {
    const produtos = await getProdutoFornecedores(id)
    return produtos.data ?? []
}

const sumEstoque = (empresa: Empresa) => {
    let sum = 0
    empresa.produtos.forEach((p) => {
        sum += p.estoque
    })
    return sum
}


export { fetchFornecedores, estoqueTotal, empresas, fetchProdutosFornecedor, getEstoqueFornecedor, sumEstoque, loading }