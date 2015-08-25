'use strict';
app.controller("OrderCtrl", ['$scope', 'loginService', '$http', '$location', 'voService', 'dataService',
  function ($scope, loginService, $http, $location, voService, dataService) {

    $scope.loadAllOrders = function () {

      $http.get('http://localhost:8080/gihans-e-shoping/rest/order').then(function (result) {
        $scope.orders = result.data;
      });

    };

    $scope.init = function () {
      $scope.loadAllOrders();
      $scope.loggedInUser = loginService.getLoggedInUser();
    };

    $scope.viewOrder = function (order) {
      $scope.order = order;
    };

    $scope.init();

  }]);
