###### Eureka Service Registry Server ######
`1. Point to remember:`
```
- Eureka server run on default port 8761.
- No need to fetch registry from other registry.
- No need to register eureka server with other registry.
- So both property for eureka client are disabled (false).
- Enable the server by annotation `EnableEurekaServer`.
- Access registry server use url `localhost:8761` 
  if `localhost:8761/eureka/` not working.
```