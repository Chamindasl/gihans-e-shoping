'use strict';
app.controller("LoginCtrl", ['$scope', '$http', '$location', 'loginService', 'voService', 'userType', 'afterSignUp',
  function ($scope, $http, $location, loginService, voService, userType, afterSignUp) {

    $scope.userSignup = function (user) {
      voService.setSignupUser(user);
      $location.path('user/signup');
      //change here
    };

    $scope.adminLogin = function (user) {
      $http.post('http://localhost:8080/gihans-e-shoping/rest/user/login', $scope.user).
              success(function (data, status, headers, config) {
                $scope.user = data;
                loginService.setLoggedInUser(data);
                if (voService.getRedirectUrl()) {
                  var rdu = voService.getRedirectUrl();
                  voService.setRedirectUrlUndefined();
                  $location.path(rdu);
                } else if ($scope.user.role.name === 'Admin' || $scope.user.role.name === 'User') {
                  $location.path('admin-dashboard');
                } else {
                  $location.path('index');
                }
              }).
              error(function (data, status, headers, config) {
                $scope.showError = true;
              });

    };

    $scope.init = function () {
      $scope.userType = userType;
      if (afterSignUp) {
        $scope.showMessage = true;
      }
    };

    $scope.init();

  }]);
