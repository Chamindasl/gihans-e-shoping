'use strict';
app.controller("LeftSideBarCtrl", function ($scope, $rootScope, $http) {

    $scope.init = function () {
        $scope.categories = [];
    };

    $scope.categories = [
        {
            name: "Sportswear",
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
            subCategories: []
        }

    ];

//    $scope.loadCategories = function () {
//        $http.get('http://localhost:8080/gs-1.0-SNAPSHOT/rest/category').
//                success(function (data, status, headers, config) {
//                    $scope.categories = data;
//                }).
//                error(function (data, status, headers, config) {
//                    // log error
//                });
//    };

//    $scope.loadCategories();
});