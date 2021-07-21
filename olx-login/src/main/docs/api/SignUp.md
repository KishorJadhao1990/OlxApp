###### Login Service ######
`1. Endpoint Url :`
```
/api/users/sign-up
```
`2. Request Method`:
```
POST
```
`3. Description`
```
User registration request
```
`4. Request Body:`
```
{
    "firstname":"kishor",
    "lastname":"jadhoa",
    "username":"kjadhao",
    "password":"kishor123",
    "mobileNo":9876543207,
    "email":"kjadhao@gamil.com",
    "roleDtos":[
        {
            "roleCode":"USER"
        }
    ]
}
```
`5. Mandetory fields:`
```
firstname, lastname, username, email
```
`6. Success Response:`
```
{
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
```

`7. Error Response:`
```
{
    "status": "BAD_REQUEST",
    "errorCode": "error.fieldValidation",
    "errorMessage": [
        {
            "errorCode": "lastname",
            "errorMessage": "Lastname is required."
        },
        {
            "errorCode": "email",
            "errorMessage": "Invalid emailId."
        },
        {
            "errorCode": "firstname",
            "errorMessage": "Firstname is required."
        },
        {
            "errorCode": "username",
            "errorMessage": "Username is required."
        }
    ],
    "timestamp": "2021-50-18 22:50"
}
```

