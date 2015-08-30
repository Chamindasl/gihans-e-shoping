app.service('dataService', function ($http) {

  this.getAllCategories = function () {
    var promise = $http.get('http://localhost:8080/gihans-e-shoping/rest/category').then(function (response) {
      return response.data;
    });
    return promise;
  };

  this.getAllProvinces = function () {
    var promise = $http.get('http://localhost:8080/gihans-e-shoping/rest/province').then(function (response) {
      return response.data;
    });
    return promise;
  };

  this.getAllRoles = function () {
    var promise = $http.get('http://localhost:8080/gihans-e-shoping/rest/user/roles').then(function (response) {
      return response.data;
    });
    return promise;
  };

  this.getAllBrands = function () {
    var promise = $http.get('http://localhost:8080/gihans-e-shoping/rest/brand').then(function (response) {
      return response.data;
    });
    return promise;
  };


});