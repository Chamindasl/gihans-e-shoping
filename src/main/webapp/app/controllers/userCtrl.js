'use strict';
app.controller("UserCtrl", ['$scope', '$rootScope', '$http', 'voService', 'provinceService',
  function ($scope, $rootScope, $http, voService, provinceService) {

    $scope.sameAsBilling = function () {
      if ($scope.user.shipingSameAsBilling) {
        $scope.user.shippingAddress = angular.fromJson(angular.toJson($scope.user.billingAddress));
      }
    };

    $scope.loadProvinces = function () {

      provinceService.getAllProvinces().then(function (data) {
        $scope.provinces = data;
      });
    };


    $scope.init = function () {
      $scope.title = "Add User";
      $scope.step = 1;
      $scope.provinces = [];
      $scope.loadProvinces();

      $scope.user = {
        email: "chaminda.sl@gmail.com",
        displayName: "Chaminda",
        password: "King1!",
        confirmPassword: "King1!",
        firstName: "Chaminda",
        lastName: "Amarasinghe",
        phone: "+94718602815",
        billingAddress: {
          email: "chaminda.sl@gmail.com",
          contactPerson: "Mahinda Amarasinghe",
          address1: "34, Karangamuwa",
          address2: "Katupotha",
//          province: {},
//          district: {},
//          city: {},
          phone: "+372247051",
          business: true
        }
//        shipingSameAsBilling: true
//        shippingAddress: {
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
      };

    };

    $scope.init();

    $scope.step1 = function () {
      if ($scope.userFormS1.$valid) {
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

    $scope.saveUser = function () {
      delete $scope.user.confirmPassword;
      if ($scope.userFormS1.$valid && $scope.userFormS3.$valid && $scope.userFormS3.$valid) {
        $http.post('http://localhost:8080/gihans-e-shoping/rest/user', $scope.user)
                .success(function (data, status, header, config) {
                })
                .error(function (data, status, header, config) {
                  // error handler
                });
      }
    };

  }]);
