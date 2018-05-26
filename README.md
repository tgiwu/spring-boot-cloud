# spring-boot-cloud 
基于Spring Boot, Spring Cloud, Spring Cloud NetFlix等框架的简单微服务项目

#应用到的技术

* Eureka是基于REST（Representational State Transfer，代表性状态传输）的服务，主要用于AWS云中定位服务，以实现中间层服务器的负载平衡和故障转移。我们称这个服务为**Eureka服务器**。Eureka还带有一个基于Java的客户端组件，即**Eureka客户端**，它使与服务的交互更容易。

* Ribbon 一个负载均衡客户端 可以很好的控制htt和tcp的一些行为。

* Zuul - Zuul 是在云平台上提供动态路由，监控，弹性，安全等边缘服务的框架。Zuul 相当于是设备和 Netflix 流应用的 Web 网站后端所有请求的前门。
* Feign 一个声明web service客户端 它使编写web service更容易 使用Feign 创建一个接口并对它进行注解，它具有可插拔的注解支持包括Feign注解与JAX-RS注解，Feign还支持可插拔的编码器与解码器，Spring Cloud 增加了对 Spring MVC的注解，Spring Web 默认使用了HttpMessageConverters, Spring Cloud 集成 Ribbon 和 Eureka 提供的负载均衡的HTTP客户端 Feign。

* Hystrix 是Netflix开源的一款容错框架，包含常用的容错方法：线程隔离、信号量隔离、降级策略、熔断技术。在高并发访问下，系统所依赖的服务的稳定性对系统的影响非常大，依赖有很多不可控的因素，比如网络连接变慢，资源突然繁忙，暂时不可用，服务脱机等。我们要构建稳定、可靠的分布式系统，就必须要有这样一套容错方法。

* Spring Cloud Config - 配置管理工具包，让你可以把配置放到远程服务器，集中化管理集群配置，目前支持本地存储、Git 以及 Subversion。

#架构
* eurekaserver 服务注册中心
* config 配置管理中心
* eurekaclient 业务服务
* zuul 用于验证权限
* feign 作为代理实现负载均衡及熔断
* ribbon 代理 负载均衡 及熔断 
* mysql 访问mysql的服务
#启动项目
* 安装maven 并配置环境变量
* 使用 mvn spring-boot:run 依次启动 server--config--zuul--feign-mysql-client
#注册中心
访问http://localhost:8761
#mysql
mysql数据库连接配置在mysql项目的配置文件中  
数据库名称spring_database  
表名 user  
列 id int(11), name varchar(100), sex varchar(4), brith_date date
