// Inicializar o módulo.
let nomeApp = 'EscolaWebApp';
let modulos = ["ngMessages"];
var app = angular.module(nomeApp, modulos);

// Estrutura básica para uma função no controlador.
var homeController = function($scope) {
  $scope.nome = "";

  $scope.desejarBoasVindas = function() {
    let nome = $scope.nome;
    $scope.mensagem = "Olá, " + nome;
  }
}

app.controller('HomeController', homeController);

// Aluno - Controller
var alunoController = function($scope) {

  $scope.aluno = {};

  $scope.cadastrar = function() {
    alunoApi.cadastrar($scope.aluno)
      .then(function(response) {})
      .catch(function(error) {});
  }
}

app.controller('AlunoController', alunoController);

// Aluno - Factory
var alunoFactory = function($http) {

  var baseUrl = "localhost:5000";

  var _cadastrar = function(aluno) {
    return $http.post(baseUrl + "/aluno", aluno);
  };

  return {
    cadastrar: _cadastrar
  };
}

app.factory("alunoApi", alunoFactory);
