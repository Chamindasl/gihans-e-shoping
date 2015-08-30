'use strict';
app.controller("CategoryCtrl", ['$scope', '$rootScope', '$http', 'dataService',
  function ($scope, $rootScope, $http, dataService) {

    $scope.loadCagetories = function () {

      dataService.getAllCategories().then(function (data) {
        $scope.categories = data;
        if ($scope.selectedCategory) {
          for (var i = 0; i < $scope.categories.length; i++) {
            if ($scope.selectedCategory.id === $scope.categories[i].id) {
              $scope.selectedCategory = $scope.categories[i];
              
            }
          }
        }
      });
    };

    $scope.init = function () {
      $scope.title = "Add Category";
      $scope.category = {};
      $scope.loadCagetories();

    };

    $scope.init();

    $scope.itemClicked = function (selectedCategory) {
      $scope.selectedCategory = selectedCategory;
      $scope.category.parentCategory = selectedCategory;
    };

    $scope.changeCategory = function () {
      $scope.selectedCategory = $scope.category.parentCategory;
    };

    $scope.saveCategory = function () {
      if ($scope.catForm.$valid) {
        $http.post('http://localhost:8080/gihans-e-shoping/rest/category', $scope.category)
                .success(function (data, status, header, config) {
                  $scope.loadCagetories();
                  $scope.category.parentCategory = $scope.selectedCategory;
                  $scope.category.name = "";
                })
                .error(function (data, status, header, config) {
                  // error handler
                });
      }
    };

  }]);
