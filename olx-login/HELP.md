###### Spring boot security: ######
```
1. Basic Authentication:
- Username and password based on auth.
- Credentials mentioned appropeties file.
- Spring recurity take cares of validation process.
```
```
2. In Memory Authentication:
- User credentials in properties has limitations.
- We can add many user in custom security confiration.
- WebSecurityConfigurerAdaptor class provide some custom configuration.
- By provider username, password and role for as many users.
- AuthManager will handle all job of user entered credentials with stored one
- Credentials stored in memory.
```
```
3. JWT Based Authentication
- User will provide credentials for authentication.
- Authentication server will validate the credentials.
- On valid credentials server provide auth token.
- For any request authToken is must.
- Token validated with auth server. 
- Once validated request get processed by Resource Server.
```
###### Service Actuators Urls: ######
```
- All included actuators:
  {protocal}://{server-ip}:{server-port}/actuator
- {protocal} Config:
  {protocal}://{server-ip}:{server-port}/actuator/refresh
- Check Config:
  {protocal}://{server-ip}:{server-port}/actuator/configprops
```

###### Logging and Tracing ######
```
- Zipkin and Sleuth are used for tracing
- Add 2 dependancy to enable tracing.
```