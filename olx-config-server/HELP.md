###### Service Utility Endpoints: ######
1. `Check Config Server Configs:`
```
- Default Config:
  {protocal}://{server-ip}:{server-port}/{service-name}/default
- Prod Config:
  {protocal}://{server-ip}:{server-port}/{service-name}/prod
- Dev Config:
  {protocal}://{server-ip}:{server-port}/{service-name}/dev
- Uat Config:
  {protocal}://{server-ip}:{server-port}/{service-name}/uat
```

2. `Git directory for config files`
```
OlxAppConfigs/{config-files}
OlxAppConfigs/dev/{config-files}
OlxAppConfigs/uat/{config-files}
OlxAppConfigs/prod/{config-files}
```