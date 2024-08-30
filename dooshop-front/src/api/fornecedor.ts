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
    const res = await axios.get(`${API}/fornecedores/estoque/${id}`)
    return res.data ?? 0
}

export { getFornecedores, getProdutoFornecedores, getEstoqueTotalFornecedor }