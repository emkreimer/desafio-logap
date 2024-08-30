import { Categoria } from "@/enums/Categoria";
export class Produto {
    id: number | undefined  = undefined;
    nome: string = '';
    estoque: number = 0;
    valor: number = 0;
    categoria: Categoria = Categoria.CEREAIS;
    
}