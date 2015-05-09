app.constant('CONSTS',{
       CTX: "http://localhost"
})
.run(function ($rootScope, CONSTS) {
      $rootScope.CONSTS = CONSTS
});