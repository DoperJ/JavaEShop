# 华工软件应用系统课程设计
基于SpringBoot搭建，用到一些SpringCloud的技术实现微服务架构

---
### 技术栈：
##### 当前使用的技术：
- 依赖管理：Maven
- ORM框架：Mybatis
- 数据库：Mysql
- 服务注册中心组件：Eureka
- JS框架：JQuery
- CSS框架：Bootstrap3
- 应用部署：Docker
##### 后续应该会加入
- 数据库缓存：Redis
- 安全框架：SpringSecurity
- API网关组件：Zuul
- 服务调用组件：Feign

---
### 模块
#### Eureka注册中心
[eureka-server](https://github.com/DoperJ/JavaEShop/tree/master/eureka-server)

已部署至www.doperj.top:8761

#### 用户模块
[e-shop-user](https://github.com/DoperJ/JavaEShop/tree/master/e-shop-user)

提供用户注册、登录功能

前端文件目录：[e-shop-user/src/main/resources/static](https://github.com/DoperJ/JavaEShop/tree/master/e-shop-user/src/main/resources/static)
#### 商品模块
[e-shop-product](https://github.com/DoperJ/JavaEShop/tree/master/e-shop-product)

提供商品信息查询服务，包括：商品种类、产品购买选项、产品详细信息

#### 订单模块
尚未开发
