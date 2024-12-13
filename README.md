## 介绍

- SpringBlade微服务开发平台，技术栈包含 SpringCloud + JWT + MySQL + Redis + MyBatis + Elasticsearch
    - 统一网关鉴权
    - 集成Sentinel从流量控制、熔断降级、系统负载等多个维度保护服务的稳定性
    - 注册中心、配置中心选型Nacos
    - 声明式服务调用Feign
        - Feign是一种声明式、模板化的HTTP客户端。在Spring Cloud中使用Feign, 我们可以做到使用HTTP请求远程服务时能与调用本地方法一样的编码体验,开发者完全感知不到这是远程方法,更感知不到这是个HTTP请求。
    - 熔断机制Hystrix
        - Hystrix提供了熔断、隔离、Fallback、cache、监控等功能，能够在一个、或多个依赖同时出现问题时保证系统依然可用。
        - 接口报错时，会返回一个默认结果
    - 多租户底层，用更少的代码换来拓展性更强的SaaS多租户系统。租户共享同一个Database、同一个Schema，但在表中通过TenantID区分租户的数据。这是共享程度最高、隔离级别最低的模式。
        - 常规场景下，多租户的ID是从token获取的，而token通过request请求的header传递至后端解析
        - 多线程、定时任务、RPC远程调用等场景是获取不到request的，针对这种情况我们提供了TenantUtil，可以在不同的场景自定义租户ID
    - 采用JWT做Token认证，多终端认证系统
        - 采用JWT分布式无状态认证的模式
        - Secure 基于 JWT 封装，每次请求的时候，会拦截到需要鉴权的API请求，并对其请求头携带的Token进行认证。
        - 前端通过api调用时，先对Token进行可解密的Aes加密，将加密后的Token放入header传递给后端
    - SpringBlade封装了一个相对好拓展的日志系统
        - 现在用的较多的技术组合为 ElasticSearch+ logstash(基于java)+kibana(基于JRuby, logstash已自带)，也就是大家常说的`ELK`。但是此系统较为重量级并不是很适合轻量级微服务架构
        - 对接口方法使用自定义注解，调用这个接口，就会保存日志到数据库中
    - Seata 是一款开源的分布式事务解决方案，致力于提供高性能和简单易用的分布式事务服务
        - SpringBlade的blade-ops模块下的模块为例进行对接讲解，其中order为订单服务，storage为库存服务
        - 接口发生报错，数据库自动回滚
    - 第三方登录，采用JustAuth开源系统，接入Gitee登录
    - Skywalking 是一个优秀的APM(application performance monitor)应用性能监控系统，针对微服务场景设计，可以方便的实现Spring cloud等微服务场景下的性能监控、链路追踪等。

参考自 SpringBlade：https://gitee.com/smallc/SpringBlade。

## 工程结构
``` 
SpringBlade
├── blade-auth -- 授权服务提供
├── blade-common -- 常用工具封装包
├── blade-gateway -- Spring Cloud 网关
├── blade-ops -- 运维中心
├    ├── blade-admin -- spring-cloud后台管理
├    ├── blade-develop -- 代码生成
├    ├── blade-resource -- 资源管理
├    ├── blade-seata-order -- seata分布式事务demo
├    ├── blade-seata-storage -- seata分布式事务demo
├── blade-service -- 业务模块
├    ├── blade-desk -- 工作台模块 
├    ├── blade-log -- 日志模块 
├    └── blade-system -- 系统模块 
├── blade-service-api -- 业务模块api封装
├    ├── blade-desk-api -- 工作台api 
├    ├── blade-dict-api -- 字典api 
├    ├── blade-system-api -- 系统api 
└──  └── blade-user-api -- 用户api 
```

## 开源协议
Apache Licence 2.0 （[英文原文](http://www.apache.org/licenses/LICENSE-2.0.html)）
Apache Licence是著名的非盈利开源组织Apache采用的协议。该协议和BSD类似，同样鼓励代码共享和尊重原作者的著作权，同样允许代码修改，再发布（作为开源或商业软件）。
需要满足的条件如下：
* 需要给代码的用户一份Apache Licence
* 如果你修改了代码，需要在被修改的文件中说明。
* 在延伸的代码中（修改和有源代码衍生的代码中）需要带有原来代码中的协议，商标，专利声明和其他原来作者规定需要包含的说明。
* 如果再发布的产品中包含一个Notice文件，则在Notice文件中需要带有Apache Licence。你可以在Notice中增加自己的许可，但不可以表现为对Apache Licence构成更改。
  Apache Licence也是对商业应用友好的许可。使用者也可以在需要的时候修改代码来满足需要并作为开源或商业产品发布/销售。
