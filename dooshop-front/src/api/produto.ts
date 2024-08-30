import axios from "axios";
import { Produto } from "@/models/Produto";

const API = import.meta.env.VITE_BACKEND_URL

const getAllProdutos = async () => {
    return await axios.get(`${API}`)
}

const salvar = async (produto: Produto) => {
    return await axios.post(`${API}`, produto)
}

const deletar = async (id: number) => {
    return await axios.delete(`${API}/del?id=${id}`)
}

const gerarRelatorio = async () => {
    return await axios.get(`${API}/relatorio`, { responseType: 'blob' })
}


export { getAllProdutos, salvar, deletar, gerarRelatorio }