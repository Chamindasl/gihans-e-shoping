'use strict';
app.controller("ItemCtrl", ['$scope', '$rootScope', '$http', 'dataService', '$routeParams', '$location',
  function ($scope, $rootScope, $http, dataService, $routeParams, $location) {

    $scope.loadItem = function (item) {
      $http.get('http://localhost:8080/gihans-e-shoping/rest/item/get?id=' + item).
              success(function (data, status, headers, config) {
                $scope.item = data;
                $scope.selectedCategory = $scope.item.categoryVO;
                $scope.selectedCategory = $scope.item.categoryVO;
                $scope.selectedSubCategory = $scope.item.categoryVO;
                $scope.selectedBrand = $scope.item.brandVO;
              }).
              error(function (data, status, headers, config) {
                // log error
              });
    };

    $scope.loadItems = function () {
      $http.get('http://localhost:8080/gihans-e-shoping/rest/item/list').
              success(function (data, status, headers, config) {
                $scope.items = data;
              }).
              error(function (data, status, headers, config) {
                // log error
              });
    };

    $scope.editItem = function (item) {
      $location.path("item/add").search({editItem: item.id});;
    };

    $scope.init = function () {
      $scope.item = {};
      if ($routeParams.item) {
        $scope.loadItem($routeParams.item);
      } else {
        $scope.title = 'Add Item';
        dataService.getAllCategories().then(function (data) {
          $scope.categories = data;
        });
        dataService.getAllBrands().then(function (data) {
          $scope.brands = data;
        });
        $scope.loadItems();
      }
      if ($routeParams.editItem) {
        $scope.title = 'Edit Item';
        $scope.loadItem($routeParams.editItem);
      }
      $location.$$search = {};
    };

    $scope.init();

  }]);
