angulaAppModulo.config(function ($stateProvider, $urlRouterProvider) {
    
    // Rota padrão.
    $urlRouterProvider.otherwise("/");
    
    // Estados
    $stateProvider
        .state('home', {
            url: '/',
            templateUrl: 'home.html'
        })
        .state('cadastrar', {
            url: '/cadastrar',
            templateUrl: 'cadastrar.html'
        })
        .state('listar', {
            url: '/listar',
            templateUrl: 'listar.html'
        })
});