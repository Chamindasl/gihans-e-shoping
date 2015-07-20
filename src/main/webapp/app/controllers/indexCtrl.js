'use strict';
app.controller("IndexCtrl", ['$scope', '$rootScope', '$http', 'voService',
  function ($scope, $rootScope, $http, voService) {

    $scope.init = function () {
      $scope.indexVO = voService.getIndexVO();
    };

    $scope.init();

    $scope.loadCategories = function () {
      $http.get('http://localhost:8080/gihans-e-shoping/rest/category').
              success(function (data, status, headers, config) {
                $scope.categories = data;
              }).
              error(function (data, status, headers, config) {
                // log error
              });
    };

    // $scope.loadCategories();

    $scope.selectCagetory = function (category) {
      delete $scope.indexVO.selectedCategory.selected;
      category.selected = true;
      $scope.indexVO.selectedCategory = category;
      console.log($scope.indexVO);
    };

    $scope.addToCart = function (item) {
      var found = false;
      for (var i=0; i < $scope.indexVO.cartItems.length; i++) {
        if ($scope.indexVO.cartItems[i].id === item.id) {
          $scope.indexVO.cartItems[i].noOfItems++;
          found = true;
          break;
        }
      };
      if (!found) {
        item.noOfItems = 1;
        $scope.indexVO.cartItems.push(item);
      }
      console.log($scope.indexVO);
      console.log(angular.toJson($scope.indexVO));
    };
  }]);
