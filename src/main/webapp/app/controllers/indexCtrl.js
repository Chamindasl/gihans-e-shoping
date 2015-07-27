'use strict';
app.controller("IndexCtrl", ['$scope', '$rootScope', '$http', 'voService', 'categoryService',
  function ($scope, $rootScope, $http, voService, categoryService) {

    $scope.loadCagetories = function () {
      categoryService.getAllCategories().then(function (data) {
        $scope.indexVO.categories = data;
      });
    };

    $scope.init = function () {
      $scope.indexVO = voService.getIndexVO();
      $scope.loadCagetories();
    };

    $scope.init();

    $scope.selectCagetory = function (category) {
      delete $scope.indexVO.selectedCategory.selected;
      category.selected = true;
      $scope.indexVO.selectedCategory = category;
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
    };
  }]);
