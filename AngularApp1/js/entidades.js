class Agenda {
    constructor (proprietario) {
        this.proprietario = proprietario;
        this.contatos = [];
    }
    
    contarContatos () {
        return this.contatos.length;
    }
}

class Contato {
    constructor (criacao, pessoa, telefone) {
        this.criacao = criacao;
    }
}

class Pessoa {
    constructor (nome, nascimento, email) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }
}

class Telefone {
    constructor (numero, ddd, codigoPais) {
        this.numero = numero;
        this.ddd = ddd;
        this.codigoPais = codigoPais;
    }
}

var proprietario = new Pessoa("Timmers", "01/01/2001", "timmers@gmail.com");
var agenda = new Agenda(proprietario);