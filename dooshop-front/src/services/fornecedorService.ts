import { getFornecedores, getProdutoFornecedores, getEstoqueTotalFornecedor } from "@/api/fornecedor";

const fetchFornecedores = async () => {
    const fornecedores = await getFornecedores()
    return fornecedores.data ?? []
}

const fetchProdutosFornecedor = async (id: number) => {
    const produtos = await getProdutoFornecedores(id)
    return produtos.data ?? []
}

const sumEstoque = async (id: number) => {
    const estoque = await getEstoqueTotalFornecedor(id)
    return estoque.data ?? 0
}

export { fetchFornecedores, sumEstoque, fetchProdutosFornecedor }