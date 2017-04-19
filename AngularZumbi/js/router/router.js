zumbiAppModulo.config(function ($routeProvider, $locationProvider) {

    // Remover a exclamação (!) da URL
    var SEM_PREFIXO = '';
    $locationProvider.hashPrefix(SEM_PREFIXO);

    $routeProvider
        .when("/", {
            templateUrl: "home.html"
        })
        .when("/contato", {
            templateUrl: "contato.html"
        })
        .when("/cadastro", {
            templateUrl: "cadastro.html"
        })
        .otherwise({redirectTo: '/'});
});