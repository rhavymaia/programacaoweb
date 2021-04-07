// Semana 5 - Questão 1
// Gerar uma lista em HTML com as tags <ul> e <li>.
function createList(quantidadeLi, texto) {
  console.log("criando a lista");
  for(var i =0; i < quantidadeLi; i++) {
    var node = document.createElement("li");
    var textnode = document.createTextNode(texto + " " + i);
    node.appendChild(textnode);

    document.getElementById("minhaLista").appendChild(node);
  }
}

createList(20, "IFPB");
