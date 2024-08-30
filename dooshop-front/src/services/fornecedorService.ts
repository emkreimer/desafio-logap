import { getFornecedores, getProdutoFornecedores, getEstoqueTotalFornecedor } from "@/api/fornecedor";
import { ref } from 'vue'
import type {Empresa} from '../models/Empresa'

const loading = ref(false)
const empresas = ref<Empresa[]>([])
const estoqueTotal = ref<Record<number, number>>({})


const fetchFornecedores = async () => {
    const res = await getFornecedores()
    

    // for (const empresa of res.data.value) {
    //     const stock = await getEstoqueTotalFornecedor(empresa.id);
    //     estoqueTotal.value[empresa.id] = stock;
    // }  
    
    return res.data
}

const fetchProdutosFornecedor = async (id: number) => {
    const produtos = await getProdutoFornecedores(id)
    return produtos.data ?? []
}


export { fetchFornecedores, estoqueTotal, empresas, fetchProdutosFornecedor, loading }