// Semana 17
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

// Semana 18
// Estruturas de repetição
// while
let i = 1;
while (i <= 10) {
  // comandos
  console.log(i);
  i++;
}

// for com autoincremento
console.log("for");
for (let j = 1; j <= 10; j++) {
  // comandos
  console.log(j);
}

// for..in
let frutas = ["banana", "manga", "jaca", "maçã"];
for (let indice in frutas){
  console.log(indice);
}

// for..of
for (let fruta of frutas){
  console.log(fruta);
}

// Objeto - JSON
let pessoa = {
  "idade": 18,
  "peso": 60,
  "altura": 1.80,
  "falar": function (){
    console.log("Estou falando!");
  }
};
pessoa.falar();
var quadrado = (x) => x * x
console.log(quadrado(2))

// Semana 19
// Função expressa
let elevar = function (x, potencia) {
  return x ** potencia;
}
// Função arrow
elevar = (x, potencia) => x ** potencia;

// Função declarativa
function minhaFuncao () {
  // comandos
  console.log("Entrou na minha função");
  for (var i = 0; i <= 3; i++) {
    let resultado = elevar(i, 2)
    //alert(resultado);
  }
}

minhaFuncao();

let falar = function () {
  console.log("Falar como eu queria!");
}

let pessoa1 = {
  "nome": "João",
  "falar": falar
}

pessoa1.falar();

// Classe
function Pessoa() {
  this.nome = "";
  let andar = function () {
    console.log("Estou andando!");
  }
  this.andar = andar;
}

var p1 = new Pessoa();
p1.nome = "Maria";
console.log(p1.nome);
p1.andar();
