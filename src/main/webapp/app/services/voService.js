app.service('voService', function (dataService) {
  var indexVO = {};
  var redirectUrl = undefined;
  var signupUser = undefined;

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

  this.getSignupUser = function () {
    return signupUser;
  };

  this.setSignupUser = function (ivo) {
    signupUser = ivo;
  };

  this.setSignupUserUndefined = function () {
    signupUser = undefined;
  };

});