export class Usuarios {

    constructor(
        public id: number, 
        public nome: String, 
        public data_nascimento: Date, 
        public email: String, 
        public senha: String
    ) { }
}