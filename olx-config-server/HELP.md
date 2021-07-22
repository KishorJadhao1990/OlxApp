###### Service Utility Endpoints: ######
1. `Check Config Server Configs`
- `Default Config:`
  [http://{server-ip}:{server-port}/{service-name}/default](http://{server-ip}:{server-port}/{service-name}/default)
- `Prod Config:`
  [http://{server-ip}:{server-port}/{service-name}/prod](http://{server-ip}:{server-port}/{service-name}/prod)
- `Dev Config:`
  [http://{server-ip}:{server-port}/{service-name}/dev](http://{server-ip}:{server-port}/{service-name}/dev)
- `Uat Config:`
  [http://{server-ip}:{server-port}/{service-name}/uat](http://{server-ip}:{server-port}/{service-name}/uat)
  
2. `Git directory for config files`
```
OlxAppConfigs/{config-files}
OlxAppConfigs/dev/{config-files}
OlxAppConfigs/uat/{config-files}
OlxAppConfigs/prod/{config-files}
```