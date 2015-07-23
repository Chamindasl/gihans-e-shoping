'use strict';
app.controller("ItemCtrl", ['$scope', '$rootScope', '$http', 'categoryService',
  function ($scope, $rootScope, $http, categoryService) {

    $scope.init = function () {
      $scope.categories = categoryService.getAllCategories();
    };

    $scope.init();

  }]);
