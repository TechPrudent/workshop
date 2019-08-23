# workshop
1 Search restaurant or restaurants 
- Guest user view
- Get all restaurants
- search restaurant by name

2 Review anonymously
- Rate restaurant 1 to 5
- Display rating of restaurants in search

3 Order Food
- addToCart the dishes
- order food with address
- Different mode of payments should be adapted
- Extra charge for total amount lesser than 200 (E.G.)

Concepts
- OOPS
- YAGNI
- DRY
- Design patterns - strategy, proxy
- Domain driven design

Endpoints

POST : localhost:8080/user/login
req:
{
	"name" : "guest",
	"type" : "guest"
}
resp:
{
    "message": "success",
    "code": 200
}

GET : localhost:8080/restaurants
resp:
[
    {
        "id": 1,
        "name": "res1",
        "dishes": [
            {
                "id": 1,
                "name": "dish1",
                "price": 20,
                "category": "veg"
            }
        ],
        "overallRating": "NaN",
        "ratings": []
    },
    {
        "id": 2,
        "name": "res2",
        "dishes": [
            {
                "id": 2,
                "name": "dish2",
                "price": 80,
                "category": "veg"
            },
            {
                "id": 10,
                "name": "dish10",
                "price": 45,
                "category": "veg"
            },
            {
                "id": 9,
                "name": "dish9",
                "price": 100,
                "category": "veg"
            }
        ],
        "overallRating": "NaN",
        "ratings": []
    },
    {
        "id": 3,
        "name": "res3",
        "dishes": [
            {
                "id": 3,
                "name": "dish3",
                "price": 45,
                "category": "non veg"
            },
            {
                "id": 5,
                "name": "dish5",
                "price": 85,
                "category": "non veg"
            },
            {
                "id": 6,
                "name": "dish6",
                "price": 25,
                "category": "non veg"
            }
        ],
        "overallRating": "NaN",
        "ratings": []
    }
]

GET : localhost:8080/restaurant?id=1
{
    "id": 1,
    "name": "res1",
    "dishes": [
        {
            "id": 1,
            "name": "dish1",
            "price": 20,
            "category": "veg"
        }
    ],
    "overallRating": "NaN",
    "ratings": []
}

POST : localhost:8080/restaurant/rate
req:
{
	"id" : "1",
	"rating" : "4",
	"userType" : "guest"
}
resp:
{
    "id": 1,
    "name": "res1",
    "dishes": [
        {
            "id": 1,
            "name": "dish1",
            "price": 20,
            "category": "veg"
        }
    ],
    "overallRating": 4,
    "ratings": [
        {
            "reviewRating": 4,
            "userType": "guest"
        },
        {
            "reviewRating": 4,
            "userType": "guest"
        }
    ]
}

POST : localhost:8080/cart/
req:
{
	 "dishes": [
        {
            "id": 1
        }
    ],
    "paymentType" : "pp",
    "restaurantId": 1
}
resp:
{
    "dishes": [
        {
            "id": 1
		}
    ],
    "paymentType": "pp",
    "restaurantId": 1
}

POST : localhost:8080/order
req:
{
	"cart" : {
		"dishes": [
			{
				"id": 1
			}
		],
		"paymentType": "pp",
		"restaurantId": 1
	},
	"paymentType" : "pp",
    "address" : "user address"
}
resp:
{
    "orderId": 1429511261,
    "cart": {
        "dishes": [
            {
                "id": 1
            }
        ],
        "paymentType": "pp",
        "restaurantId": 1
    },
    "paymentType": "pp",
    "address": "user address",
    "amount": 40
}
