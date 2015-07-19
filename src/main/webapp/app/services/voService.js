app.service('voService', function () {
    var indexVO = {

        selectedCategory: {
            id: 1,
            name: "Cat 2"
        },

        featuredItems: [{
                id: 1,
                name: "Item 1",
                price: 1.50,
                image: "app/assets/img/home/product1.jpg",
                fresh: true,
                sale: false
            },
            {
                id: 1,
                name: "Item 1",
                price: 1.50,
                image: "app/assets/img/home/product1.jpg",
                fresh: false,
                sale: true
            },
            {
                id: 1,
                name: "Item 1",
                price: 1.50,
                image: "app/assets/img/home/product1.jpg",
                fresh: false,
                sale: false
            },
            {
                id: 1,
                name: "Item 1",
                price: 1.50,
                image: "app/assets/img/home/product1.jpg",
                fresh: false,
                sale: false
            }
        ],
        
        recommendedItems: [{
                id: 3,
                name: "Item 3"
            },
            {
                id: 4,
                name: "Item 4"
            }
        ],

        cartItems : [],
        
        categories : [
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
            selected : true,
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
    ]

    };

    this.getIndexVO = function () {
        return indexVO;
    };

    this.setIndexVO = function (ivo) {
        indexVO = ivo;
    };
});