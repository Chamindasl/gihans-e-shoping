'use strict';
var app = angular.module('app', [
    'ngRoute'
]);

app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
                when('/index', {
                    templateUrl: 'views/index.html',
                    controller: 'IndexCtrl'
                }).
                when('/p2', {
                    templateUrl: 'views/cart.html',
                    controller: 'IndexCtrl'
                }).
                otherwise({
                    redirectTo: '/index'
                });
    }]);