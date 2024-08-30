import { Produto } from "./Produto";

export class Empresa {
    id?: number;
    nome: string = '';
    produtos: Produto[] = [];
}