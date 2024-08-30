import axios from "axios"

const API = import.meta.env.VITE_BACKEND_URL

const getVowel = async (word: string) => {
    const res = await axios.post(`${API}/caracteres?word=${word}`)
    return res.data
}

export { getVowel }

