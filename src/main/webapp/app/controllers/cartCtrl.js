'use strict';
app.controller("CartCtrl", ['$scope', '$rootScope', '$http', 'voService', 'loginService', '$location',
  function ($scope, $rootScope, $http, voService, loginService, $location) {

    $scope.init = function () {
      $scope.indexVO = voService.getIndexVO();
      $scope.loggedInUser = loginService.getLoggedInUser();
    };

    $scope.init();

    $scope.addOne = function (item) {
      item.noOfItems++;
    };

    $scope.reduceOne = function (item) {
      if (item.noOfItems !== 0) {
        item.noOfItems--;
      }
    };

    $scope.remveFromCart = function (item) {
      for (var i = 0; i < $scope.indexVO.cartItems.length; i++) {
        if ($scope.indexVO.cartItems[i].id === item.id) {
          $scope.indexVO.cartItems.splice(i, 1);
          break;
        }
      }
    };

    $scope.getCartTotal = function () {
      var total = 0;
      for (var i = 0; i < $scope.indexVO.cartItems.length; i++) {
        total += ($scope.indexVO.cartItems[i].noOfItems * $scope.indexVO.cartItems[i].price);
      }
      return total;
    };

    $scope.saveOrder = function () {
      if ($scope.loggedInUser) {
        $http.post('http://localhost:8080/gihans-e-shoping/rest/order/place', $scope.indexVO)
                .success(function (data, status, header, config) {
                  $location.path('order')
                  window.open("http://www.payeasy.lk/billpayWeb/Controller", "_blank");
                })
                .error(function (data, status, header, config) {
                  // error handler
                });
      } else {
        $location.path('customer/login');
      }
    };
  }]);
