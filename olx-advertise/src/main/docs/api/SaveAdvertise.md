###### Advertise Service ######
`1. Endpoint Url :`
```
/api/advertise
```
`2. Request Method`:
```
POST
```
`3. Description`
```
Save advertise 
```
`4. Request Body:`
```
{
    "title":"Macbook",
    "price":"100000",
    "categoryId":3,
    "description":"Apple macbook air intel i5, 500GB Storage, 8GB RAM"
}
```
`5. Success Response:`
```
{
    "createdBy": 1,
    "createdAt": 1626650205,
    "updatedBy": 1,
    "updatedAt": 1626650205,
    "id": 2000000003,
    "title": "Microsoft",
    "price": "100000",
    "categoryId": 3,
    "description": "MS note intel i5, 500GB Storage, 8GB RAM"
}
```

`6. Error Response:`
```
{
    "status": "BAD_REQUEST",
    "errorCode": "error.fieldValidation",
    "errorMessage": [
        {
            "errorCode": "title",
            "errorMessage": "required.title"
        },
        {
            "errorCode": "price",
            "errorMessage": "required.price"
        }
    ],
    "timestamp": "2021-17-18 23:17"
}
```

