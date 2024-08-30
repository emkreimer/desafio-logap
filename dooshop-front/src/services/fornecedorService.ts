import { getFornecedores, getProdutoFornecedores, getEstoqueTotalFornecedor } from "@/api/fornecedor";
import { ref } from 'vue'
import type {Empresa} from '../models/Empresa'

const empresas = ref<Empresa[]>([])
const estoqueTotal = ref<Record<number, number>>({})


const fetchFornecedores = async () => {
    const res = await getFornecedores()
    const empresas = res.data

    for (const empresa of empresas.value) {
        const stock = await getEstoqueTotalFornecedor(empresa.id);
        estoqueTotal.value[empresa.id] = stock;
    }   
}

const fetchProdutosFornecedor = async (id: number) => {
    const produtos = await getProdutoFornecedores(id)
    return produtos.data ?? []
}


export { fetchFornecedores, estoqueTotal, empresas, fetchProdutosFornecedor }