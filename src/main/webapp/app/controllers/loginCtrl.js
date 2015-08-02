'use strict';
app.controller("LoginCtrl", ['$scope', '$http', '$location', '$routeParams', 'loginService',
  function ($scope, $http, $location, $routeParams, loginService) {

    $scope.adminLogin = function (user) {
      $http.post('http://localhost:8080/gihans-e-shoping/rest/user/login', $scope.user).
              success(function (data, status, headers, config) {
                loginService.setLoggedInUser(data);
                $location.path('admin-dashboard');
              }).
              error(function (data, status, headers, config) {
                $scope.showError = true;
              });

    };

    $scope.init = function () {
    };

    $scope.init();

  }]);
