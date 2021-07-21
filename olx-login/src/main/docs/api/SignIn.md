###### Login Service ######
`1. Endpoint Url :`
```
/api/users/sign-in
```
`2. Request Method`:
```
POST
```
`3. Description`
```
User login request
```
`4. Request Body:`
```
{
    "username":"kjadhao",
    "password":"kishor123",
}
```
`5. Mandetory fields:`
```
Both fields are mandetory
```
`6. Success Response:`
```
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJramFkaGFvIiwiZXhwIjoxNjI2ODAyOTU1LCJpYXQiOjE2MjY3NjY5NTV9.jbig43xjwKvEwupEiJuSsTkYU8B318QLly4o3feRBAc",
    "User": {
        "createdBy": 1,
        "createdAt": 1626786571,
        "updatedBy": 1,
        "updatedAt": 1626786571,
        "id": 1000000005,
        "firstname": "kishor",
        "lastname": "jadhoa",
        "username": "kjadhao",
        "email": "kjadhao@gamil.com",
        "mobileNo": 9876543207,
        "roles": [
            {
                "createdBy": 1,
                "createdAt": 1626691183000,
                "updatedBy": 1,
                "updatedAt": 1626691183000,
                "roleName": "user",
                "roleCode": "USER",
                "description": "User Role",
                "id": 1
            }
        ]
    }
}
```

`7. Error Response:`
```
{
    "status": "UNAUTHORIZED",
    "errorCode": "error.invalidCredentials",
    "errorMessage": "Invalid username or password.",
    "timestamp": "2021-10-20 13:10"
}
```

