angulaAppModulo.controller('alunoController', function (AlunoService, $scope, $state) {

    $scope.alunos = [];

    $scope.adicionarAluno = function () {        
        
        AlunoService.cadastrarAluno($scope.aluno)
            .then(function (response) {
                // Chamado quando a resposta contém status de sucesso.
                // Exibir no console o conteúdo da resposta.
                console.log(response.data);
            });
    };

    $scope.listarAlunos = function () {
        AlunoService.listarAlunos()
            .then(function (response) {
                $scope.alunos = response.data;
            });
    };

    $scope.pesquisarAlunoPorNome = function (nome) {
        AlunoService.consultarAlunoByNome(nome)
            .then(function (response) {
                $scope.alunos = response.data;
            });
    };
    
    $scope.redirecionar = function () {        
        $state.transitionTo('home');
    };
});