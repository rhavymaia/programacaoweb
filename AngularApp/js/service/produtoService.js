angulaAppModulo.factory("produtoService", function($http){

  var _listarProdutos = function (){
		return $http.get(_path + "/listar/")
	};

  return {
		listarProdutos: _listarProdutos
	};
});
