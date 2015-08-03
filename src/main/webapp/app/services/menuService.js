app.service('menuService', function ($http, loginService) {

  var adminMenus = [
    {
      name: 'Dashboard',
      url: "",
      active: true,
      subs: [{
          name: 'Admin',
          url: "admin-dashboard",
          active: true
        }, {
          name: 'User',
          url: "admin-dashboard",
          active: false
        }]
    }, {
      name: 'Item',
      url: "",
      active: false,
      subs: [{
          name: 'Add Item',
          url: "add-item",
          active: false
        }, {
          name: 'List Items',
          url: "index",
          active: false
        }]
    }, {
      name: 'Category',
      url: "",
      active: false,
      subs: [{
          name: 'View Categories',
          url: "category",
          active: false
        }]
    }, {
      name: 'Brand',
      url: "",
      active: false,
      subs: [{
          name: 'View Brands',
          url: "brand",
          active: false
        }]
    }, {
      name: 'User',
      url: "",
      active: false,
      subs: [{
          name: 'Add User',
          url: "user",
          active: false
        }, {
          name: 'List Users',
          url: "user-list",
          active: false
        }, {
          name: 'Logout',
          url: "admin",
          active: false
        }]
    }
  ];

  var userMenus = [
    {
      name: 'Dashboard',
      url: "",
      active: true,
      subs: [{
          name: 'User',
          url: "admin-dashboard",
          active: false
        }]
    }, {
      name: 'Item',
      url: "",
      active: false,
      subs: [{
          name: 'Add Item',
          url: "add-item",
          active: false
        }, {
          name: 'List Items',
          url: "index",
          active: false
        }]
    }, {
      name: 'User',
      url: "",
      active: false,
      subs: [{
          name: 'Logout',
          url: "admin",
          active: false
        }]
    }
  ];

  this.getMenus = function () {
    var user = loginService.getLoggedInUser();
    if (!user) {
      loginService.getLoggedInUserFromSession().then(function (data) {
        user = data;
        loginService.setLoggedInUser(user);
        if (user && user.role.name === 'Admin') {
          return adminMenus;
        } else if (user && user.role.name === 'User') {
          return userMenus;
        } else {
          return null;
        }
      });
    } else {
      if (user && user.role.name === 'Admin') {
        return adminMenus;
      } else if (user && user.role.name === 'User') {
        return userMenus;
      } else {
        return null;
      }
    }
  };

  this.setMenus = function (tmenus) {
    var user = loginService.getLoggedInUser();
    if (user && user.role.name === 'Admin') {
      adminMenus = tmenus;
    } else if (user && user.role.name === 'User') {
      userMenus = tmenus;
    } else {
    }
  };

});