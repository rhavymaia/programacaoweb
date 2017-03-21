angulaAppModulo.factory("AlunoService", function($http) {

    var urlBase = "http://localhost:8080/RestEasyApp";
    
    var _listarAlunos = function() {
        return $http.get(urlBase + "/aluno/listar/")
    };
    
    var _cadastrarAluno = function(aluno){
		return $http.post(urlBase + "/inserir", aluno)
	};

    return {
        listarAlunos: _listarAlunos,
        cadastrarAluno: _cadastrarAluno
    };
});