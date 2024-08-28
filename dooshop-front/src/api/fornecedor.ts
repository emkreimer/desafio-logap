import axios from "axios";
import { Empresa } from "@/models/Empresa";

const getFornecedores = async () => {
    return await axios.get("http://localhost:8085/fornecedores")
}

export { getFornecedores }