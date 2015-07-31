app.service('voService', function (dataService) {
  var indexVO = {};

  this.getIndexVO = function () {
    indexVO.categories = dataService.getAllCategories();
//    console.log("-" + dataService.getAllCategories());
    return indexVO;
  };

  this.setIndexVO = function (ivo) {
    indexVO = ivo;
  };
});