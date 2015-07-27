'use strict';
app.controller("UserCtrl", ['$scope', '$rootScope', '$http', 'voService',
  function ($scope, $rootScope, $http, voService) {

    $scope.init = function () {
      $scope.title = "Add User";
    };

    $scope.init();

  }]);
