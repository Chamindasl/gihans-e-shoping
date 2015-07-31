'use strict';
app.controller("IndexCtrl", ['$scope', '$rootScope', '$http', 'voService', 'dataService',
  function ($scope, $rootScope, $http, voService, dataService) {

    function chunk (arr, size) {
      var newArr = [];
      for (var i = 0; i < arr.length; i += size) {
        newArr.push(arr.slice(i, i + size));
      }
      return newArr;
    };

    $scope.loadIndexVO = function () {
      $http.post('http://localhost:8080/gihans-e-shoping/rest/index/loadIndexVO', $scope.indexVO)
              .success(function (data, status, header, config) {
                $scope.indexVO = data;
                $scope.chunked = chunk($scope.indexVO.recommendedItems, 3)
                console.info($scope.indexVO);
              })
              .error(function (data, status, header, config) {
                // error handler
              });
    };

    $scope.recommendedItems = function () {
      $http.post('http://localhost:8080/gihans-e-shoping/rest/index/loadRelatedItems', $scope.indexVO)
              .success(function (data, status, header, config) {
                $scope.indexVO.recommendedItems = data.recommendedItems;
                $scope.chunked = chunk($scope.indexVO.recommendedItems, 3)
              })
              .error(function (data, status, header, config) {
                // error handler
              });
    };

    $scope.loadCagetories = function () {
      dataService.getAllCategories().then(function (data) {
        $scope.indexVO.categories = data;
      });
    };

    $scope.init = function () {
      $scope.indexVO = {};
      $scope.loadIndexVO();
    };

    $scope.init();

    $scope.slide = function (dir) {
      $('#recommended-item-carousel').carousel(dir);
    };

    $scope.selectCagetory = function (category, parent) {
      for (var i = 0; i < $scope.indexVO.categories.length; i++) {
        delete $scope.indexVO.categories[i].selected;
      }
      category.selected = true;
      $scope.indexVO.selectedCategory = category;
      if (parent) {
        parent.selected = true;
      }
      $scope.recommendedItems();
    };

    $scope.addToCart = function (item) {
      item.inCart = true;
      var found = false;
      for (var i = 0; i < $scope.indexVO.cartItems.length; i++) {
        if ($scope.indexVO.cartItems[i].id === item.id) {
          $scope.indexVO.cartItems[i].noOfItems++;
          found = true;
          break;
        }
      }
      if (!found) {
        item.noOfItems = 1;
        $scope.indexVO.cartItems.push(item);
      }
      $scope.recommendedItems();
      voService.setIndexVO($scope.indexVO);
    };
  }]);
