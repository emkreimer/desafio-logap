import axios from "axios";
import { Produto } from "@/models/Produto";

const back_url = "http://localhost:8085/"

const getAllProdutos = async () => {
    return await axios.get("http://localhost:8085/")
}

export { getAllProdutos }