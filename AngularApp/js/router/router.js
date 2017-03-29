angulaAppModulo.config(function ($routeProvider, $locationProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'home.html'
        })
        .when('/cadastrar', {
            templateUrl: 'cadastrar.html'
        })
        .when('/listar', {
            templateUrl: 'listar.html'
        })
        .otherwise('/');
});