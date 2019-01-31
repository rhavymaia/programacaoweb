var escolaApp = angular.module("AngularApp", ["ui.router", 'ngMaterial', 'ngMessages', 'ngMdIcons'
    ]);

var baseUrl = "http://mobile-aceite.tcu.gov.br:80/nossaEscolaRS";

// Factory - API
var escolaApi = function ($http) {

    var _getEscolas = function (quantidadeDeItens) {
        return $http.get(baseUrl + "/rest/escolas?quantidadeDeItens=" +
            quantidadeDeItens);
    };

    var _getEscola = function (codEscola) {
        return $http.get(baseUrl + "/rest/escolas/" + codEscola);
    };

    var _getAvaliacoes = function () {
        return $http.get(baseUrl + "/rest/tiposavaliacao");
    };

    return {
        getEscolas: _getEscolas,
        getEscola: _getEscola,
        getAvaliacoes: _getAvaliacoes
    };
}

escolaApp.factory("escolaApi", escolaApi);

// Controllers
var listarEscolaCtrl = function ($scope, $mdToast, escolaApi) {

    $scope.escolas = [];
    $scope.quantidades = [10, 20, 30, 40, 50, 100];

    $scope.listarEscola = function (quantidade) {

        escolaApi.getEscolas(quantidade)
            .then(function (response) {
                // Toast
                var toast = $mdToast.simple()
                    .textContent('As escolas foram listadas abaixo.')
                    .position('top right')
                    .action('OK')
                    .hideDelay(6000)
                    .toastClass('my-success');
                $mdToast.show(toast);

                $scope.escolas = response.data;
            })
            .catch(function (error) {
                var toast = $mdToast.simple()
                    .textContent('Algum problema ocorreu na solicitação dos dados das escolas.')
                    .position('top right')
                    .action('OK')
                    .hideDelay(6000)
                    .toastClass('my-error');
                $mdToast.show(toast);

                console.error(error);
            });
    }
};

var pesquisarEscolaCtrl = function ($scope, $stateParams, escolaApi) {

    $scope.escola = {};
    $scope.codEscola = $stateParams.codEscola;

    $scope.pesquisarEscola = function (codEscola) {
        escolaApi.getEscola(codEscola)
            .then(function (response) {
                $scope.escola = response.data;
            })
            .catch(function (error) {
                console.error(error);
            });
    }

    let inicializarEscola = function() {
        var codEscola = $stateParams.codEscola;
        console.log(codEscola);
    }

    inicializarEscola();
};

escolaApp.controller("ListarEscolaCtrl", listarEscolaCtrl);
escolaApp.controller("PesquisarEscolaCtrl", pesquisarEscolaCtrl);

// Navegação.
escolaApp.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/home');

    $stateProvider
        .state('home', {
            url: '/home',
            templateUrl: 'home.html'
        })
        .state('listar', {
            url: '/escolas',
            templateUrl: 'listarEscolas.html',
            controller: 'ListarEscolaCtrl'
        })
        .state('pesquisar', {
            url: '/escolas/:codEscola',
            templateUrl: 'pesquisarEscola.html',
            controller: 'PesquisarEscolaCtrl'
        })
});
