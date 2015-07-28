app.service('voService', function (categoryService) {
  var indexVO = {};

  this.getIndexVO = function () {
    indexVO.categories = categoryService.getAllCategories();
//    console.log("-" + categoryService.getAllCategories());
    return indexVO;
  };

  this.setIndexVO = function (ivo) {
    indexVO = ivo;
  };
});