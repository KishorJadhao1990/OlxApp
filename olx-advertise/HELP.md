###### Service Utility Endpoints: ######
1. Actuators:
- `All included actuators:`
  [http://{server-ip}:{server-port}/actuator](http://{server-ip}:{server-port}/actuator)
- `Refresh Config:`
  [http://{server-ip}:{server-port}/actuator/refresh](http://{server-ip}:{server-port}/actuator/refresh)
- `Check Config:`
  [http://{server-ip}:{server-port}/actuator/configprops](http://{server-ip}:{server-port}/actuator/configprops)

###### Logging and Tracing ######
- `Zipkin and Sleuth are used for tracing`
- `Add 2 dependancy to enable tracing.`