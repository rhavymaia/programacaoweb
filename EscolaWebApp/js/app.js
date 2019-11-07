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
var alunoController = function($scope, alunoApi) {

  $scope.aluno = {};
  let aluno = $scope.aluno;

  $scope.cadastrar = function() {
    alunoApi.cadastrar(aluno)
      .then(function(response) {
        console.log("Requisição enviada e recebida com sucesso");
        console.log(response);
      })
      .catch(function(error) {
        console.log("Houve um problema na requisição");
        console.error(error);
      });
    /*
    alunoApi.cadastrar($scope.aluno)
      .then(function(response) {})
      .catch(function(error) {});
    */

  }
}

app.controller('AlunoController', alunoController);

// Aluno - Factory
var alunoFactory = function($http) {

  var baseUrl = "http://127.0.0.1:5000";

  var _cadastrar = function(aluno) {
    return $http.post(baseUrl + "/aluno", aluno);
  };

  var _listar = function() {
    return $http.get(baseUrl + "/alunos");
  };

  var _pesquisarPorId = function(id) {
    return $http.get(baseUrl + "/alunos/" + encodeURI(id));
  };

  return {
    cadastrar: _cadastrar,
    listar: _listar,
    pesquisarPorId: _pesquisarPorId
  };
}

app.factory("alunoApi", alunoFactory);
