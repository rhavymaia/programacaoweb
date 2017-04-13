angulaAppModulo.config(function ($stateProvider, $urlRouterProvider) {
    
    // Rota padrão.
    $urlRouterProvider.otherwise("/");
    
    // Estados
    $stateProvider
        .state('home', {
            url: '/',
            templateUrl: 'home.html'
        })
        .state("/aluno/cadastrar", {
            url: '/aluno/cadastrar',
            templateUrl: 'cadastrarAluno.html'
        })
        .state('/aluno/listar', {
            url: '/aluno/listar',
            templateUrl: 'listarAluno.html'
        })
});