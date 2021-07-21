###### Advertise Service ######
`1. Endpoint Url :`
```
/api/advertise/{id}
```
`2. Request Method`:
```
GET
```
`3. Description`
```
Fetch advertise details
```
`4. Success Response:`
```
{
    "createdBy": 1,
    "createdAt": 1626643514,
    "updatedBy": 1,
    "updatedAt": 1626647120,
    "id": 2000000000,
    "title": "Lenovo",
    "price": "51000",
    "categoryId": 3,
    "description": "Lenovo ideapad intel i3, 500GB Storage, 8GB RAM"
}
```

`5. Error Response:`
```
{
    "status": "BAD_REQUEST",
    "errorCode": "error.advertiseNotFound",
    "errorMessage": "Advertise details not found.",
    "timestamp": "2021-12-18 23:12"
}
```

