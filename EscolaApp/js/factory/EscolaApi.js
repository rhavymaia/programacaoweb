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