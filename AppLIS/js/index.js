let idade = 18;
let peso = 60;
let altura = 1.89;

const PI = 3.14;

console.log("Sua idade é: " + idade);

function minhaFuncao(){}

function outraFuncao(minhaFuncao){
  // Callback
  /*
    Callback
  */
  minhaFuncao()
}

for (var i = 0; i <10; i++){
  console.log(i);
}

let mangas = ["Tommy", "Rosa", "Espada"];
for (let manga of mangas){
  console.log(manga);
}

let pessoa = {
  "nome": "José",
  "nascimento": new Date(),
  "altura": 1.80
}

for (let p in pessoa){
  console.log(pessoa[p]);
}
