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
                when('/cart', {
                    templateUrl: 'views/cart.html',
                    controller: 'CartCtrl'
                }).
                when('/add-item', {
                    templateUrl: 'views/add-item.html',
                    controller: 'ItemCtrl'
                }).
                otherwise({
                    redirectTo: '/index'
                });
    }]);