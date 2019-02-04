// Controller - Listar Escolas
var listarEscolasCtrl = function ($scope, $mdToast, escolaApi) {

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

escolaApp.controller("ListarEscolasCtrl", listarEscolasCtrl);