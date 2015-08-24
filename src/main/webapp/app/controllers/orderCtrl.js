'use strict';
app.controller("OrderCtrl", ['$scope', '$rootScope', '$http', '$location', 'voService', 'dataService',
  function ($scope, $rootScope, $http, $location, voService, dataService) {


    $scope.loadAllOrders = function () {

      $http.get('http://localhost:8080/gihans-e-shoping/rest/order').then(function (result) {
        $scope.orders = result.data;
      });

    };

    $scope.init = function () {
      $scope.loadAllOrders();
    };

    $scope.init();

  }]);
