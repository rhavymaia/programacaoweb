// Inicializar o módulo.
let nomeApp = 'EscolaWebApp';
let modulos = ['ngMaterial', 'ngMessages'];
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
var alunoController = function($scope, $mdToast, alunoApi) {

  $scope.aluno = {};
  let aluno = $scope.aluno;

  $scope.cadastrar = function() {
    // Converter formato da data: brazilian -> american.
    var data = moment(aluno.nascimento, "DD/MM/YYYY");
    aluno.nascimento = data.format("YYYY-MM-DD");

    alunoApi.cadastrar(aluno)
      .then(function(response) {
        var toast = $mdToast.simple()
            .textContent('O aluno foi cadastrado com sucesso!')
            .position('top right')
            .action('OK')
            .hideDelay(6000);
        $mdToast.show(toast);

        delete $scope.aluno;
        $scope.aluno = {};
        $scope.alunoForm.$setPristine();
        $scope.alunoForm.$setUntouched();
      })
      .catch(function(error) {
        var toast = $mdToast.simple()
            .textContent('Algum problema ocorreu no envio dos dados.')
            .position('top right')
            .action('OK')
            .hideDelay(6000);
        $mdToast.show(toast);
      });
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
