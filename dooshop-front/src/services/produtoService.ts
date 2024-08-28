import { getAllProdutos } from "@/api/produto";

const getProdutos = async () => {
    return getAllProdutos();
}

export {getProdutos}