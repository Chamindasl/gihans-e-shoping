'use strict';
app.controller("CategoryCtrl", ['$scope', '$rootScope', '$http', 'dataService',
  function ($scope, $rootScope, $http, dataService) {

    $scope.loadCagetories = function () {

      dataService.getAllCategoriesWithInactive().then(function (data) {
        $scope.categories = data;
        $scope.setSelectedCategory();
      });
    };

    $scope.setSelectedCategory = function () {
      if ($scope.selectedCategory) {
        for (var i = 0; i < $scope.categories.length; i++) {
          if ($scope.selectedCategory.id === $scope.categories[i].id) {
            $scope.selectedCategory = $scope.categories[i];
          }
        }
      }

    };

    $scope.init = function () {
      $scope.title = "Add Category";
      $scope.category = {};
      $scope.loadCagetories();
    };

    $scope.init();

    $scope.itemClicked = function (selectedCategory) {
      $scope.category = angular.fromJson(angular.toJson(selectedCategory));
      if (selectedCategory.parentCategory) {
        $scope.selectedCategory = selectedCategory.parentCategory;
      } else {
        $scope.selectedCategory = selectedCategory;
      }
      $scope.setSelectedCategory();
    };

    $scope.changeCategory = function () {
      $scope.selectedCategory = $scope.category.parentCategory;
    };

    $scope.clearCategory = function () {
      $scope.category = {};
      $scope.selectedCategory = {};
    };

    $scope.saveCategory = function () {
      if ($scope.catForm.$valid) {
        $http.post('http://localhost:8080/gihans-e-shoping/rest/category', $scope.category)
                .success(function (data, status, header, config) {
                  $scope.loadCagetories();
                  $scope.category.parentCategory = $scope.selectedCategory;
                  $scope.category.name = "";
                  $scope.category.id = -1;
                })
                .error(function (data, status, header, config) {
                  // error handler
                });
      }
    };

    $scope.editCategory = function (category) {
      $http.post('http://localhost:8080/gihans-e-shoping/rest/category/edit', category)
              .success(function (data, status, header, config) {
              })
              .error(function (data, status, header, config) {
                // error handler
              });
    };

  }]);
