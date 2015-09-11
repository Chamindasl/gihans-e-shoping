'use strict';
app.controller("BrandCtrl", ['$scope', '$rootScope', '$http', 'dataService',
  function ($scope, $rootScope, $http, dataService) {

    $scope.loadBrands = function () {

      dataService.getAllBrandsWithInactive().then(function (data) {
        $scope.brands = data;
      });
    };

    $scope.init = function () {
      $scope.brand = {};
      $scope.loadBrands();
    };

    $scope.init();

    $scope.saveBrand = function () {
      if ($scope.brandForm.$valid) {
        $http.post('http://localhost:8080/gihans-e-shoping/rest/brand', $scope.brand)
                .success(function (data, status, header, config) {
                  $scope.loadBrands();
                })
                .error(function (data, status, header, config) {
                  // error handler
                });
      }
    };

    $scope.selectBrand = function (brand) {
      $scope.brand = angular.fromJson(angular.toJson(brand));
    };

    $scope.clearBrand = function () {
      $scope.brand = {};
    };

    $scope.editBrand = function (brand) {
      $http.post('http://localhost:8080/gihans-e-shoping/rest/brand', brand)
              .success(function (data, status, header, config) {
                $scope.loadBrands();
              })
              .error(function (data, status, header, config) {
                // error handler
              });
    };

  }]);
