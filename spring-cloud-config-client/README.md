### 分布式配置架构



### Spring Cloud Config



###一. spring cloud 服务端



#### 1.1 基于文件系统

1.添加`spring cloud config`依赖（server）

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

2.在入口类上加上`@EnableConfigServer`,如下：

```java
@SpringBootApplication
@EnableConfigServer
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
```

3.在工程下创建`config`目录，添加配置文件如下：

![1547294260329](D:\workspace\spring-boot-summary\spring-boot-image\spring-cloud\config\1547294260329.png)



4.添加`spring cloud config`配置

```yaml
server:
  port: 8081
# 基于文件系统实现config
spring:
  application:
    name: config-server
  profiles:
    active: native #设置为本地模式 而不是使用git
  cloud:
    config:
      server:
        native:
          search-locations: classpath:/config
# security config
security:
  user:
    name: admin
    password: admin
```

5.测试

- 使用浏览器访问`http://localhost:8081/config/prod/`

```json
"propertySources": [
    {
        "name": "classpath:/config/config-prod.properties",
        "source": {
            "application.name": "prod"
        }
    }
]
```

- 使用浏览器访问`http://localhost:8081/config/dev/`

```json
"propertySources": [
    {
        "name": "classpath:/config/config-dev.properties",
        "source": {
            "application.name": "dev"
        }
    }
]
```

#### 1.2 基于Git版本控制



1.在github上创建一个远程仓库，添加配置文件如下：

- config-dev.properties(内容：config.name=dev)

- config-prod.properties(内容：config.name=prod)

  

2.由文件系统切换到使用git作为配置中心，只需要修改配置文件即可，如下配置：

```yaml
# 基于文件系统实现config
spring:
  application:
    name: config-server
  #profiles:
    #active: native #设置为本地模式 而不是使用git
  cloud:
    config:
      server:
        git:
          uri: https://github.com/qianjiangtao/spring-cloud-config.git
          search-paths: config-test
        #native:
          #search-locations: classpath:/config
```

3.测试`http://localhost:8081/config/prod/`

```json
{
    "name": "config",
    "profiles": [
        "prod"
    ],
    "label": null,
    "version": "1156e7d636173b257ca62b0ebe0c6a09e0117cb0",
    "state": null,
    "propertySources": [
        {
            "name": "https://github.com/qianjiangtao/spring-cloud-config.git/config-test/config-prod.properties",
            "source": {
                "application.name": "prod"
            }
        }
    ]
}
```

注意控制台日志会自动将配置文件下载到本地的临时目录下：

```shell
Adding property source: file:/C:/Users/ADMINI~1/AppData/Local/Temp/config-repo-2324014707567810921/config-test/config-prod.properties
```



### 二.Spring Cloud配置客户端



1，添加`spring cloud config client`依赖jar(与服务端不一样)

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

2，添加bootstrap配置文件，配置文件内容如下：

```yaml
spring:
  cloud:
    config:
      profile: prod
      label: master
      uri: http://127.0.0.1:8081/
      name: config
```



3.测试，启动客户端应用，发现启动日志有报错信息（当然不是error）

```java
c.c.c.ConfigServicePropertySourceLocator : Fetching config from server at: http://127.0.0.1:8081/
c.c.c.ConfigServicePropertySourceLocator : Could not locate PropertySource: 401 null
com.lvmama.toter.client.Main             : No active profile set, falling back to default profiles: default
```

​	感觉就是无法连接到服务端，经过分析怀疑是因为我本地使用了security，需要认证，于是我把security删除了，果然可以了，那如果使用了security认证怎么处理？于是我就在官网上找了下security的配置原来是需要配置username 和 password,于是就重新修改配置：

```yaml
spring:
  cloud:
    config:
      profile: prod
      label: master
      uri: http://127.0.0.1:8081/
      name: config
      # 服务端配置使用了security认证
      username: admin
      password: admin
```



* 问题二：即使调用了客户端refresh也不能使客户端获取最新配置，层次关系，不能更新

  了解refresh原理，看日志

 使用定时任务`contextRefresher`刷新

- 问题三课外：spring 如何解决循环依赖（三级缓存）

  

  分析怀疑是因为我本地使用了security，需要认证，于是我把security删除了，果然可以了，那如果使用了security认证怎么处理？于是我就在官网上找了下security的配置原来是需要配置username 和 password,于是就添加了如下配置：

  ```yaml
  spring:
    cloud:
      config:
        username: admin
        password: admin
  ```

- 快速失败模式

- 自动重试

- 动态刷新功能

### Git 分布式配置存在的缺陷



