'use strict';
app.controller("MenuCtrl", ['$scope', '$rootScope', '$http', '$location', 'menuService', 'loginService',
  function ($scope, $rootScope, $http, $location, menuService, loginService) {

    $scope.init = function () {
      var menus = menuService.getMenus();
      var user;
      if (!menus) {
        loginService.getLoggedInUserFromSession().then(function (data) {
          user = data;
          loginService.setLoggedInUser(user);
          if (user && user.role.name === 'Admin') {
            $scope.menus = menuService.getAdminMenus();
          } else if (user && user.role.name === 'User') {
            $scope.menus = menuService.getUserMenus();
          } else {
            if ($location.path() !== '/user/signup') {
              $location.path('admin');
            }
          }
        });
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
