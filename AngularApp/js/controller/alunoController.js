angulaAppModulo.controller('alunoController', function (AlunoService, $scope, $state) {

    var TAMANHO_MINIMO_PESQUISA = 3;
    
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
        
        console.log("Nome: " + nome);
        
        if(nome.length > TAMANHO_MINIMO_PESQUISA) {
            AlunoService.consultarAlunoByNome(nome)
                .then(function (response) {
                    $scope.alunos = response.data;
                });
        }        
    };
    
    $scope.limparFormulario = function() {
        
        // Reinicializa as variáveis nome e alunos.
        $scope.nome = "";
        angular.copy({}, $scope.alunos);
        
        // Reinicializa o estado do campo para os eventos e validação.
        // É necessário indicar o atributo name no formulário <form>
        $scope.formPesquisa.$setPristine();
        $scope.formPesquisa.$setValidity();
    }
    
    $scope.redirecionar = function () {        
        $state.transitionTo('home');
    };
});