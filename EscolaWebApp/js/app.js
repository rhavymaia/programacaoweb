// Inicializar o módulo.
let nomeApp = 'EscolaWebApp';
let modulos = [];
var app = angular.module(nomeApp, modulos);

// Estrutura básica para uma função no controlador.
var meuPrimeiroController = function($scope){
  $scope.logradouro = "Outro valor";
  $scope.numero1 = 0;
  $scope.numero2 = 0;
  let nome = "João";
  $scope.nome = nome;

  $scope.somar = function(numero1, numero2) {
    $scope.resultado = somar(numero1, numero2);
  }

  function somar(numero1, numero2) { 
    return numero1 + numero2;
  }
}

app.controller('MeuPrimeiroController', meuPrimeiroController);

var meuSegundoController = function($scope){
}

app.controller('MeuSegundoController', meuSegundoController);
