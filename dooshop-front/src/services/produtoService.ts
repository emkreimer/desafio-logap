import { getAllProdutos } from "@/api/produto";

const getProdutos = async () => {
    const produtos = await getAllProdutos()
    return produtos.data ?? [];
}

export {getProdutos}