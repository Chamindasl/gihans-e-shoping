'use strict';
app.controller("LeftSideBarCtrl", function ($scope, $rootScope, $http) {

  $scope.init = function () {
    $scope.categories = [];
    $scope.brands = [];
  };
  $scope.init();
  $scope.brands = [
    {
      name: "Tommy Hill",
      noOfItems: 50
    },
    {
      name: "Hugo Boss",
      noOfItems: 30
    }
  ];
  $scope.categories = [
    {
      name: "Sportswear",
      id: 15,
      subCategories: [
        {
          name: "Nike"
        },
        {
          name: "Under Armour"
        },
        {
          name: "Adidas"
        },
        {
          name: "Puma"
        },
        {
          name: "ASICS"
        }
      ]
    },
    {
      name: "Women",
      subCategories: [
        {
          name: "FENDI"
        },
        {
          name: "GUESS"
        },
        {
          name: "VALENTINO"
        },
        {
          name: "DIOR"
        },
        {
          name: "VERSACE"
        }
      ]
    },
    {
      name: "Men",
      subCategories: [
        {
          name: "FENDI"
        },
        {
          name: "GUESS"
        },
        {
          name: "VALENTINO"
        },
        {
          name: "DIOR"
        },
        {
          name: "VERSACE"
        },
        {
          name: "ARMANI"
        },
        {
          name: "PRADA"
        },
        {
          name: "DOLCE AND GABBANA"
        },
        {
          name: "CHANEL"
        },
        {
          name: "GUCCI"
        }
      ]
    },
    {
      name: "KIDS",
      subCategories: []
    },
    {
      name: "FASHION",
      subCategories: []
    },
    {
      name: "HOUSEHOLDS",
      subCategories: []
    },
    {
      name: "INTERIORS",
      subCategories: []
    },
    {
      name: "CLOTHING",
      subCategories: []
    },
    {
      name: "BAGS",
      subCategories: []
    },
    {
      name: "SHOES",
      id: 12,
      subCategories: []
    }

  ];

  $scope.loadCategories = function () {
    $http.get('http://localhost:8080/gihans-e-shoping/rest/category').
            success(function (data, status, headers, config) {
              $scope.categories = data;
            }).
            error(function (data, status, headers, config) {
              // log error
            });
  };

  $scope.loadCategories();
});