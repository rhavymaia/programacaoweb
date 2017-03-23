angulaAppModulo.config(function($routeProvider, $locationProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'home.html'
        })
        .when('/cadastro', {
            templateUrl: 'cadastro.html'
        })
        .when('/listar', {
            templateUrl: 'listar.html'
        });
});