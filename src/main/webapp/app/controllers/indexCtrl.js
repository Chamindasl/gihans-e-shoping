'use strict';
app.controller("IndexCtrl", function ($scope, $rootScope) {

    $scope.categories = [
		{
			name: "Sportswear",
			subCategories : [
				{
					name : "Nike",
					name : "Under Armour",
					name : "Adidas",
					name : "Puma",
					name : "ASICS",
				}
			]
		},
		{
			name: "Sportswear",
			subCategories : [
				{
					name : "",
					name : "",
					name : "",
					name : "",
					name : "",
				}
			]
		},
		{
			name: "Sportswear",
			subCategories : [
				{
					name : "",
					name : "",
					name : "",
					name : "",
					name : "",
				}
			]
		}
	];
});
