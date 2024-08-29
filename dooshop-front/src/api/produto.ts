import axios from "axios";
import { Produto } from "@/models/Produto";

const back_url = "http://localhost:8085/"

const getAllProdutos = async () => {
    return await axios.get("http://localhost:8085/")
}

const salvar = async (produto: Produto) => {
    return await axios.post("http://localhost:8085", produto)
}

const deletar = async (id: number) => {
    return await axios.delete(`http://localhost:8085?id=${id}`)
}

export { getAllProdutos, salvar, deletar }