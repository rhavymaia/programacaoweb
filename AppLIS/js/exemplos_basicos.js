var idade = 18;
console.log(idade);
const PI = 3.14;
console.log(PI);
//PI = 3.141516; Não pode reatribuir valor a uma constante.
let peso = 60;
console.log(peso);

let nome = "João da Silva";

let matriculado = true;

// Estrutura de condição composto
if (matriculado == true) {
  console.log("Aluno(a) está matriculado(a)")
} else {
  console.log("Aluno(a) não está matriculado(a)")
}

// Estrutura de condição com if composto, aninhado e encadeado.
if (idade >= 18){
  // condição verdadeira
  console.log("Você é maior de idade.");
} else {
  // condição falsa
  console.log("Você é menor de idade.");

  if (idade >= 2 && idade <=10) {
    console.log("e também é criança.")
  } else if (idade > 0) {
    console.log("e também é bebê.")
  }
}
// Estruturas de repetiçãoptimize
let i = 1;
while (i <= 10) {
  // comando
  console.log(i);
  i++;
}

//for elemento in range(1, 10 + 1):
  //comandos
for (let j = 1; j <= 10; j++) {
  console.log(j);
}

let frutas = ["uva", "manga", "banana", "morango"];
//for fruta in frutas:
  //print(fruta)
for (indice in frutas) {
  console.log(indice + " - " + frutas[indice]);
}

for (fruta of frutas) {
  console.log(fruta);
}

// Função
//def exibirMensagemConsole():
  //print("Mensagem")
let somar = function(n1, n2) {
  let resultado = n1 + n2;
  return resultado;
}

somar = (n1, n2) => n1 + n2;

function exibirMensagemConsole(mensagem, qtdExibicoes, andar) {
  andar(); // Função passada como parâmetro.
  qtdExibicoes = somar(qtdExibicoes, 1); // retorna a soma de dois números.
  console.log(mensagem);
  console.log(
    "Quantidade de vezes que foram chamadas a exibição no console:"
    + qtdExibicoes);
}

let andar = function(n1, n2) {
  console.log("Estou andando!")
}

for (let i = 0; i < 3; i++) {
  exibirMensagemConsole("Texto da mensagem", i, andar);
}
