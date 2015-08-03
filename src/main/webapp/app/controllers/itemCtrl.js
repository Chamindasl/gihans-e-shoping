'use strict';
app.controller("ItemCtrl", ['$scope', '$rootScope', '$http', 'dataService', '$routeParams',
  function ($scope, $rootScope, $http, dataService, $routeParams) {

    $scope.loadItem = function (item) {
      $http.get('http://localhost:8080/gihans-e-shoping/rest/item/get?id=' + item).
              success(function (data, status, headers, config) {
                $scope.item = data;
              }).
              error(function (data, status, headers, config) {
                // log error
              });
    };

    $scope.loadItems = function (item) {
      $http.get('http://localhost:8080/gihans-e-shoping/rest/item/list').
              success(function (data, status, headers, config) {
                $scope.items = data;
              }).
              error(function (data, status, headers, config) {
                // log error
              });
    };

    $scope.init = function () {
      if ($routeParams.item) {
        $scope.loadItem($routeParams.item);
      } else {
        dataService.getAllCategories().then(function (data) {
          $scope.categories = data;
        });
        dataService.getAllBrands().then(function (data) {
          $scope.brands = data;
        });
        $scope.loadItems();
      }
    };

    $scope.init();

  }]);
