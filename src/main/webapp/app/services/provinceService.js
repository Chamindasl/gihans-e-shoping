app.service('provinceService', function ($http) {
  this.getAllProvinces = function () {
  
    var promise = $http.get('http://localhost:8080/gihans-e-shoping/rest/provinceVO').then(function (response) {
        return response.data;
      });
      // Return the promise to the controller
      return promise;
  };

});