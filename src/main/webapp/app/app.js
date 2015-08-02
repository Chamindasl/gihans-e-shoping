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
                when('/item/set-recommended', {
                    templateUrl: 'views/set-recommended.html',
                    controller: 'ItemCtrl'
                }).
                when('/category', {
                    templateUrl: 'views/category.html',
                    controller: 'CategoryCtrl'
                }).
                when('/user', {
                    templateUrl: 'views/user.html',
                    controller: 'UserCtrl'
                }).
                when('/user-list', {
                    templateUrl: 'views/user-list.html',
                    controller: 'UserCtrl'
                }).
                when('/admin', {
                    templateUrl: 'views/admin-login.html',
                    controller: 'LoginCtrl'
                }).
                when('/admin-dashboard', {
                    templateUrl: 'views/admin-dashboard.html',
                    controller: 'DashboardCtrl'
                }).
                otherwise({
                    redirectTo: '/index'
                });
    }]);