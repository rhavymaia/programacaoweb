// JSON
let nome = "João da Silva";

let veiculo = {
  "motadora": "Fiat"
}

let pessoa = {
  "nome": "João da Silva", // String
  "idade": 18, // Inteiro
  "altura": 1.85, // Ponto flutuante
  "enderecos": ["Rua Paraguai, Centro - S/N", "Dom Pedro II, Centro - SN"] // Lista
};

let pessoas = [
  {
    "nome": "João da Silva",
    "idade": 18,
    "altura": 1.85,
    "enderecos": ["Rua Paraguai, Centro - S/N", "Dom Pedro II, Centro - SN"]
  },
  {
    "nome": "Maria da Silva",
    "idade": 20,
    "altura": 1.95,
    "enderecos": ["Rua Paraguai, Centro - S/N", "Dom Pedro II, Centro - SN"]
  }
];

console.log(pessoa);

// Iterando os elementos de pessoa.enderecos.
for (indice in pessoa.enderecos) {
  console.log(pessoa.enderecos[indice]);
}

for (endereco of pessoa.enderecos) {
  console.log(endereco);
}

// Acessando e atribuindo o primeiro elemento da lista de JSON.
let item = pessoas[0];
