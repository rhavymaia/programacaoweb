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
  $scope.nome = "";
  $scope.matricula = "";
  $scope.cpf = "";
  $scope.nascimento = "";
  $scope.id_endereço = "";
  $scope.id_endereço = "";

  $scope.cadastrar = function() {
    alunoApi.cadastrar($scope.aluno)
      .then(function(response) {})
      .catch(function(error) {});
    $scope.alunoForm.$setPristine();
  }
}

app.controller('AlunoController', alunoController);

// Aluno - Factory
var alunoFactory = function($http) {

  var baseUrl = "localhost:5000";
  var path = baseUrl + "/aluno";

  var _cadastrar = function(aluno) {
    return $http.post(_path, aluno)
  };

  var _atualizar = function(aluno) {
    return $http.put(_path, aluno)
  };

  var _buscarPorId = function(id) {
    return $http.get(_path + "/" + encodeURI(id))
  };

  var _listar = function() {
    return $http.get(_path)
  };

  return {
    cadastrar: _cadastrar,
    atualizar: _atualizar,
    buscarPorId: _buscarPorId,
    listar: _listar
  };
}

app.factory("alunoApi", alunoFactory);
