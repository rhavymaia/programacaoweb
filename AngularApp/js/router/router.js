angulaAppModulo.config(function($routeProvider) {
    $routeProvider
        .when('/home', {
            templateUrl: 'home.html'
        })
        .when('/cadastro', {
            templateUrl: 'cadastro.html'
        })
        .when('/listar', {
            templateUrl: 'listar.html'
        });
});