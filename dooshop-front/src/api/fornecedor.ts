import axios from "axios";
import { Empresa } from "@/models/Empresa";

const API = import.meta.env.VITE_BACKEND_URL

const getFornecedores = async () => {
    return await axios.get(`${API}/fornecedores`)
}

const getProdutoFornecedores = async (id: number) => {
    return await axios.get(`${API}/fornecedores/${id}`)
}

const getEstoqueTotalFornecedor = async (id: number) => {
    return await axios.get(`${API}/fornecedores/estoque/${id}`)
}

export { getFornecedores, getProdutoFornecedores, getEstoqueTotalFornecedor }