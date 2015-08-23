app.service('voService', function (dataService) {
  var indexVO = {};

  this.getIndexVO = function () {
    return indexVO;
  };

  this.setIndexVO = function (ivo) {
    indexVO = ivo;
  };
});