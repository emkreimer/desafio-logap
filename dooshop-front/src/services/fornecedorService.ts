import { getFornecedores } from "@/api/fornecedor";
import type { Empresa } from "@/models/Empresa";

const fetchFornecedores = async () => {
    const fornecedores = await getFornecedores()
    return fornecedores.data ?? []
}

const sumEstoque = (empresa: Empresa) => {
    return empresa.produtos.reduce((total, produto) => total + produto.estoque, 0)
}

export { fetchFornecedores, sumEstoque  }