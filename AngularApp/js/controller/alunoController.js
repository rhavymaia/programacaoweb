angulaAppModulo.controller('alunoController', function (AlunoService, $scope) {

    $scope.alunos = [];

    $scope.adicionarAluno = function () {        
        
        AlunoService.cadastrarAluno($scope.aluno)
            .then(function (response) {
                // Chamado quando a resposta contém status de sucesso.
                // Exibir no console o conteúdo da resposta.
                console.log(response.data);
                
                // Criar aluno com o dado (Json) de resposta do servidor.
                var aluno = response.data;
                $scope.alunos.push(aluno);                
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