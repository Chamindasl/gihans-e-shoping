app.service('voService', function (dataService) {
  var indexVO = {};
  var redirectUrl = undefined;

  this.getIndexVO = function () {
    return indexVO;
  };

  this.setIndexVO = function (ivo) {
    indexVO = ivo;
  };

  this.getRedirectUrl = function () {
    return redirectUrl;
  };

  this.setRedirectUrl = function (ivo) {
    redirectUrl = ivo;
  };

  this.setRedirectUrlUndefined = function () {
    redirectUrl = undefined;
  };

});