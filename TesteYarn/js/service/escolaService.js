angulaAppModulo.factory("EscolaService", function($http) {

    var urlBase = "http://localhost:8080/RestEasyApp";
    
    var _getEscolas = function() {
        return $http.get(urlBase + "/escola/listar/")
    };

    return {
        getEscolas: _getEscolas
    };
});