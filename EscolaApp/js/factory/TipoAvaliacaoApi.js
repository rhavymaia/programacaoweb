// Factory - API
var tipoAvaliacaoApi = function ($http) {

    var _getTiposAvaliacao = function () {
        return $http.get(baseUrl + "/rest/tiposavaliacao");
    };
    
    var _getTiposAvaliacaoPorNome = function (nome) {
        return $http.get(baseUrl + "/rest/tiposavaliacao?nome=" + encodeURIComponent(nome));
    };

    return {
        getTiposAvaliacao: _getTiposAvaliacao,
        getTiposAvaliacaoPorNome: _getTiposAvaliacaoPorNome
    };
}

escolaApp.factory("tipoAvaliacaoApi", tipoAvaliacaoApi);