'use strict';
app.controller("CartCtrl", ['$scope', '$rootScope', '$http', 'voService',
  function ($scope, $rootScope, $http, voService) {

    $scope.init = function () {
      $scope.indexVO = voService.getIndexVO();
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

    $scope.mymodel = function () {
      $(function () {
        $("#dialog").dialog({
          autoOpen: false,
          show: {
            effect: "blind",
            duration: 1000
          },
          hide: {
            effect: "explode",
            duration: 1000
          }
        });

        $("#opener").click(function () {
          $("#dialog").dialog("open");
        });
      });
    };
    
    $scope.mymodel();

  }]);
