###### Category Service ######
`1. Endpoint Url :`
```
/api/advertise/category/{id}
```
`2. Request Method`:
```
GET
```
`3. Description`
```
Fetch the advertise categories details
```
`4. Success Response:`
```
{
    "createdBy": 1,
    "createdAt": 1626604273000,
    "updatedBy": 1,
    "updatedAt": 1626604273000,
    "id": 2,
    "category": "Real Estate",
    "description": "Real Estate advertise category",
    "status": "CLOSE"
}
```

`4. Error Response:`
```
{
    "status": "BAD_REQUEST",
    "errorCode": "error.categoryNotFound",
    "errorMessage": "Advertise category not found.",
    "timestamp": "2021-15-18 18:15"
}
```

