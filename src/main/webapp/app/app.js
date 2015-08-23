'use strict';
var app = angular.module('app', [
    'ngRoute', 'angularUtils.directives.dirPagination'
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
                when('/item/add', {
                    templateUrl: 'views/item-add.html',
                    controller: 'ItemCtrl'
                }).
                when('/item/list', {
                    templateUrl: 'views/item-list.html',
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
                when('/brand', {
                    templateUrl: 'views/brand.html',
                    controller: 'BrandCtrl'
                }).
                when('/user/add', {
                    templateUrl: 'views/user.html',
                    controller: 'UserCtrl'
                }).
                when('/user/list', {
                    templateUrl: 'views/user-list.html',
                    controller: 'UserCtrl'
                }).
                when('/admin', {
                    templateUrl: 'views/admin-login.html',
                    controller: 'LoginCtrl'
                }).
                when('/customer/login', {
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