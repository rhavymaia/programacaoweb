angulaAppModulo
    .config(function ($stateProvider, $urlRouterProvider) {

        // Rota padrão.
        $urlRouterProvider.otherwise("/");

        // Estados
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'home.html'
            })
    
            // Subrota Aluno
            .state('aluno', {
                abstract: true,
                url: '/aluno',
                templateUrl: 'aluno.html' // Novo ui-view
            })
            .state('aluno.cadastrar', {
                url: '/cadastrar',
                templateUrl: 'cadastrarAluno.html'
            })
            .state('aluno.listar', {
                url: '/listar',
                templateUrl: 'listarAluno.html'
            })
    })
    //take all whitespace out of string
    .filter('nospace', function () {
        return function (value) {
            return (!value) ? '' : value.replace(/ /g, '');
        };
    })
    //replace uppercase to regular case
    .filter('humanizeDoc', function () {
        return function (doc) {
            if (!doc) return;
            if (doc.type === 'directive') {
                return doc.name.replace(/([A-Z])/g, function ($1) {
                    return '-' + $1.toLowerCase();
                });
            }

            return doc.label || doc.name;
        }
    });