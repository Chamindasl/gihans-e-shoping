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

    $scope.callChangeStatus = function (order) {
      $http.post('http://localhost:8080/gihans-e-shoping/rest/order/changeStatus', order)
              .success(function (data, status, header, config) {
                $scope.loadAllOrders();
              })
              .error(function (data, status, header, config) {
              });
    };

    $scope.editOrder = function (order) {
      $scope.eOrder = order;
      $scope.eOrderStatus = true;
    };

    $scope.changeStatus = function () {
      $scope.eOrderStatus = false;
      $scope.callChangeStatus($scope.eOrder);
    };

    $scope.init();

  }]);
