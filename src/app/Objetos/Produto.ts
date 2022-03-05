export class Produto {
    
    constructor(
        public id: number, 
        public nome: String, 
        public preco: number, 
        private desconto: number = 10
        ) { }

    public aplicarDesconto = (preco: number) => {
        return preco - this.desconto;
    }
}