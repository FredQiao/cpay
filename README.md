### cpay
## 项目简介：
使用SpringBoot+Motan+Zookeeper搭建的Restful服务，对外提供HTTP接口

## 项目结构：
` service：RPC接口`</br>
` web：管理后台，前端使用thymeleaf模板`</br>
` api：对外接口`

web和api通过调用service层的RPC接口获得数据
