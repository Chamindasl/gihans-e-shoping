app.service('loginService', function ($http) {

  var loggedInUser;

  this.getLoggedInUser = function () {
    return loggedInUser;
  };

  this.getLoggedInUserFromSession = function () {
    var promise = $http.get('http://localhost:8080/gihans-e-shoping/rest/user/sessionUser').then(function (response) {
      return response.data;
    });
    return promise;

  };

  this.setLoggedInUser = function (user) {
    loggedInUser = user;
  };


});