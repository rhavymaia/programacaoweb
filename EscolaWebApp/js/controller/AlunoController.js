var alunoController = function($scope, $mdToast, $state, alunoApi) {

  $scope.aluno = {};

  $scope.cadastrar = function() {
    // Criar uma cópia do aluno do $scope.
    let aluno = angular.copy($scope.aluno);

    // Converter formato da data: brazilian -> american.
    var data = moment(aluno.nascimento, "DD/MM/YYYY");
    aluno.nascimento = data.format("YYYY-MM-DD");

    alunoApi.cadastrar(aluno)
      .then(function(response) {

        // Limpar formulário.
        limparFormulario();

        // Redirecionamento de página.
        $state.transitionTo('alunos', {reload: true, inherit: false, notify: true});

        // Caixa de confirmação - Toast
        var toast = $mdToast.simple()
          .textContent('O aluno foi cadastrado com sucesso!')
          .position('top right')
          .action('OK')
          .hideDelay(6000);
        $mdToast.show(toast);
      })
      .catch(function(error) {
        var toast = $mdToast.simple()
          .textContent('Algum problema ocorreu no envio dos dados.')
          .position('top right')
          .action('OK')
          .hideDelay(6000);
        $mdToast.show(toast);
      });
  };

  let limparFormulario = function() {

    // Reinicializa a variável aluno.
    angular.copy({}, $scope.aluno);

    // Reinicializa o estado do campo para os eventos e validação.
    // É necessário indicar o atributo name no formulário <form>
    $scope.alunoForm.$setPristine();
    $scope.alunoForm.$setUntouched();
    $scope.alunoForm.$setValidity();
  }
}

app.controller('AlunoController', alunoController);
