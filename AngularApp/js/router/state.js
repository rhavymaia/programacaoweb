angulaAppModulo.config(function ($stateProvider) {    
    $stateProvider
		.state('home', {
			url: '/',
			templateUrl: 'home.html'
		})
        .state('cadastrar', {
            url: '/cadastrar',
			templateUrl: 'cadastrar.html'
		})
        .state('listar', {
            url: '/listar',
			templateUrl: 'listar.html'
		})
});