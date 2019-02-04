// Controller - Pesquisar Escola pelo código.
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

escolaApp.controller("PesquisarEscolaCtrl", pesquisarEscolaCtrl);