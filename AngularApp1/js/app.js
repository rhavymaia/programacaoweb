// Inicializar o módulo.
var app = angular.module('AngularApp', []);

app.controller('meuController', function($scope) {
    
    $scope.aluno = "maria";
    
    $scope.alunos = ["João", "Maria", "José"];
    
    $scope.mudarAluno = function() {
        console.log($scope.aluno);
        $scope.aluno = "Marcos";
    }
});