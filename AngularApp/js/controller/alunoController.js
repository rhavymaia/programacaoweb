angulaAppModulo.controller('alunoController', function (AlunoService, $scope) {

    $scope.alunos = [];

    $scope.adicionaAluno = function () {
        $scope.alunos.push({
            id: $scope.aluno.id,
            nome: $scope.aluno.nome,
            matricula: $scope.aluno.matricula
        });
    };

    $scope.listarAlunos = function () {
        AlunoService.listarAlunos()
            .then(function (response) {
                $scope.alunos = response.data;
            });
    };

    $scope.pesquisarAlunoPorNome = function () {

    };
});