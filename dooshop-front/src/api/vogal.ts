import axios from "axios"

const getVowel = async (word: string) => {
    const res = await axios.post(`http://localhost:8085/caracteres?word=${word}`)
    return res.data
}

export { getVowel }

