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

    $scope.init = function () {
      if ($routeParams.item) {
        $scope.loadItem($routeParams.item);
      } else {
        dataService.getAllCategories().then(function (data) {
          $scope.categories = data;
        });
      }
    };

    $scope.init();

  }]);
