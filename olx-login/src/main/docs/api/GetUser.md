###### Login Service ######
`1. Endpoint Url :`
```
/api/users/{userId}
```
`2. Request Method`:
```
GET
```
`3. Description`
```
Fetch user details
```
`4. Success Response:`
```
{
    "createdBy": 1,
    "createdAt": 1626577871,
    "updatedBy": 1,
    "updatedAt": 1626577871,
    "id": 1000000000,
    "firstname": "kishor",
    "lastname": "jadhao",
    "username": "kjadhao",
    "password": "kishor123",
    "email": "kjadhao@gmail.com",
    "mobileNo": 9876543201
}
```

`5. Error Response:`
```
{
    "status": "BAD_REQUEST",
    "errorCode": "error.userNotFound",
    "errorMessage": "User details not found.",
    "timestamp": "2021-44-18 22:44"
}
```

