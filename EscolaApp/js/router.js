// Navegação.
escolaApp.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/home');

    $stateProvider
        .state('home', {
            url: '/home',
            templateUrl: 'home.html'
        })
        .state('escolas', {
            url: '/escolas',
            templateUrl: 'listarEscolas.html',
            controller: 'ListarEscolasCtrl'
        })
        .state('escolaPorCodigo', {
            url: '/escolas/:codEscola',
            templateUrl: 'pesquisarEscola.html',
            controller: 'PesquisarEscolaCtrl'
        })
        .state('tiposAvaliacao', {
            url: '/tiposavaliacao',
            templateUrl: 'listarTiposAvaliacao.html',
            controller: 'ListarTiposAvaliacaoCtrl'
        });
});
