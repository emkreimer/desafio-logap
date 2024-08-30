import { getFornecedores, getProdutoFornecedores, getEstoqueTotalFornecedor } from "@/api/fornecedor";
import { ref } from 'vue'


const estoqueTotal = ref<Record<number, number>>({})

const fetchFornecedores = async () => {
    const res = await getFornecedores()
    const fornecedores = res.data

    for (const empresa of fornecedores.value) {
        const stock = await getEstoqueTotalFornecedor(empresa.id);
        estoqueTotal.value[empresa.id] = stock;
    }   

    return fornecedores.value
}

const fetchProdutosFornecedor = async (id: number) => {
    const produtos = await getProdutoFornecedores(id)
    return produtos.data ?? []
}


export { fetchFornecedores, estoqueTotal, fetchProdutosFornecedor }