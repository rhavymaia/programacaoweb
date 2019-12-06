var alunosController = function($scope, $mdToast, alunoApi) {

  $scope.alunos = [];

  $scope.listar = function() {
    console.log("Listando")
    alunoApi.listar()
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
    $scope.alunos = [];
  };

}

app.controller('AlunosController', alunosController);
