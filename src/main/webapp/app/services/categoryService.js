app.service('categoryService', function ($http) {
  var allCategories = [];
  this.getAllCategories = function () {
    $http.get('http://localhost:8080/gihans-e-shoping/rest/categoryVo').
            success(function (data, status, headers, config) {
              allCategories = data;
            }).
            error(function (data, status, headers, config) {
              // log error
            });
    return allCategories;
  };

});