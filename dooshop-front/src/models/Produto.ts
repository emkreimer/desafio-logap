import { Categoria } from "@/enums/Categoria";
export class Produto {
    id?: number;
    nome: string;
    estoque: number;
    categoria: Categoria;
    
}