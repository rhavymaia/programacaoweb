var alunosController = function($scope, $mdToast, alunoApi) {

  $scope.alunos = [];

  let listar = function() {
      alunoApi.listar(nome)
        .then(function(response) {
          $scope.alunos = response.data;
        })
        .catch(function(error) {

        });
  };

  $scope.pesquisar = function(nome) {
    if (nome.length >= 3) {
      alunoApi.buscarPorNome(nome)
        .then(function(response) {
          $scope.alunos = response.data;
        })
        .catch(function(error) {

        });
    }
  };

  $scope.limparBusca = function() {
    $scope.nome = "";
    $scope.apresentacoes = [];
  };

}

app.controller('AlunosController', alunosController);
