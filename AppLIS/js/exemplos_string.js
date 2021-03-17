let frase = "Olá, mundo!";
let complemento = "Turma de TSI."
let resultado = frase + " " + complemento;
console.log(resultado); //Olá, mundo!Turma de TSI.
let letra = resultado[0];
let tamanho = resultado.length;
console.log(tamanho);

let ultimaLetra = resultado[tamanho-1];
console.log(ultimaLetra);
let i = 0
while(i<tamanho) {
  console.log(resultado[i]);
  i++;
}

// slice - fatiamento
console.log(resultado.slice(5, 10));
// Upper e Lower case.
console.log(resultado.toUpperCase());
console.log(resultado.toLowerCase());

// Substituir
resultado = resultado.replace("mundo","Marcella");
console.log(resultado);

let nome = " Severino da Silva Cavalcante ";
console.log(nome.length);
nome = nome.trim();
console.log(nome.length);

let divisaoNome = nome.split(" ");
console.log(divisaoNome);
let primeiroNome = divisaoNome[0];
// sobrenome completo seja gerado automaticamente
// independente do tamanho do sobrenome.
// Entrada: Severino da Silva Cavalcante
// Saída:  da Silva Cavalcante.
let sobrenome = divisaoNome[1] + divisaoNome[2];
