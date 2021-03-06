'use strict';
app.controller("UserCtrl", ['$scope', '$rootScope', '$http', '$location', 'voService', 'dataService',
  function ($scope, $rootScope, $http, $location, voService, dataService) {

    $scope.sameAsBilling = function () {
      if ($scope.user.shipingSameAsBilling) {
        $scope.user.shippingAddress = angular.fromJson(angular.toJson($scope.user.billingAddress));
      }
    };

    $scope.loadRefData = function () {

      dataService.getAllProvinces().then(function (data) {
        $scope.provinces = data;
      });

      dataService.getAllRoles().then(function (data) {
        $scope.roles = data;
      });

    };

    $scope.loadAllUsers = function () {

      $http.get('http://localhost:8080/gihans-e-shoping/rest/user/users').then(function (result) {
        $scope.users = result.data;
      });

    };

    $scope.init = function () {
      $scope.title = "Add User";
      $scope.step = 1;
      $scope.provinces = [];
      $scope.loadRefData();
      $scope.loadAllUsers();
      if (voService.getSignupUser()) {
        $scope.user = voService.getSignupUser();
        voService.setSignupUserUndefined();
        $scope.requestFromUser = true;
      } else {
        $scope.user = {};
      };

//      $scope.user = {
//      added extra comments in here 
//      
//      just for testing 
//      
//        email: "chaminda.sl@gmail.com",
//        displayName: "Chaminda",
//        password: "King1!",
//        confirmPassword: "King1!",
//        firstName: "Chaminda",
//        lastName: "Amarasinghe",
//        phone: "+94718602815",
//        billingAddress: {
//          email: "chaminda.sl@gmail.com",
//          contactPerson: "Mahinda Amarasinghe",
//          address1: "34, Karangamuwa",
//          address2: "Katupotha",
////          province: {},
////          district: {},
////          city: {},
//          phone: "+372247051",
//          business: true
//        }
////        shipingSameAsBilling: true
////        shippingAddress: {
////          email: "chaminda.sl@gmail.com",
////          contactPerson: "Mahinda Amarasinghe",
////          address1: "34, Karangamuwa",
////          address2: "Katupotha",
//////          province: {},
//////          district: {},
//////          city: {},
////          phone: "+372247051",
////          business: true
////        }
//      };

    };

    $scope.init();

    $scope.step1 = function () {
      if ($scope.userFormS1.$valid) {
        if (!$scope.user.role) {
          var i = 0;
          for (; i < $scope.roles.length; i++) {
            if ($scope.roles[i].name === 'Customer') {
              $scope.user.role = $scope.roles[i];
              break;
            }
          }
        }
        $scope.step = 2;
      }
    };

    $scope.step2 = function () {
      if ($scope.userFormS2.$valid) {
        $scope.step = 3;
      }
    };

    $scope.back = function () {
      $scope.step = $scope.step - 1;
    };

    $scope.finish = function () {
      $scope.saveUser();
    };

    $scope.editUser = function (user) {
      $scope.user = user;
      $scope.step = 1;
      $location.path("user/add");
    };

    $scope.saveUser = function () {
      delete $scope.user.confirmPassword;
      if ($scope.userFormS1.$valid && $scope.userFormS3.$valid && $scope.userFormS3.$valid) {
        $http.post('http://localhost:8080/gihans-e-shoping/rest/user', $scope.user)
                .success(function (data, status, header, config) {
                  if ($scope.requestFromUser) {
                    $location.path("customer/login/after-sign");
                  } else {
                    $location.path("user/list");
                  }
                })
                .error(function (data, status, header, config) {
                  // error handler
                });
      }
    };

  }]);
