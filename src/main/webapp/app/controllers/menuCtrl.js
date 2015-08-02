'use strict';
app.controller("MenuCtrl", ['$scope', '$rootScope', '$http', '$location', 'menuService',
  function ($scope, $rootScope, $http, $location, menuService) {

    $scope.init = function () {
      var menus = menuService.getMenus();
      if (!menus) {
        $location.path('admin');
      } else {
        $scope.menus = menus;
      }
    };

    $scope.init();

    $scope.go = function (subMenu, menu) {
      for (var i = 0; i < $scope.menus.length; i++) {
        $scope.menus[i].active = false;
        for (var j = 0; j < $scope.menus[i].subs.length; j++) {
          $scope.menus[i].subs[j].active = false;
        }
      }
      subMenu.active = true;
      menu.active = true;
      menuService.setMenus($scope.menus);
      $location.path(subMenu.url);
    };

  }]);
