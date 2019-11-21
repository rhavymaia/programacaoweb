// Aluno - Factory
var alunoFactory = function($http) {

  var baseUrl = "http://127.0.0.1:5000";

  var _cadastrar = function(aluno) {
    return $http.post(baseUrl + "/aluno", aluno);
  };

  var _listar = function() {
    return $http.get(baseUrl + "/alunos");
  };

  var _pesquisarPorId = function(id) {
    return $http.get(baseUrl + "/alunos/" + encodeURI(id));
  };

  return {
    cadastrar: _cadastrar,
    listar: _listar,
    pesquisarPorId: _pesquisarPorId
  };
}

app.factory("alunoApi", alunoFactory);
