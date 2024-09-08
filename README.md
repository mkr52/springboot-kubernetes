# Springboot with kubernetes

### Base project setup
[Spring Boot Project Setup](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.2.9&packaging=jar&jvmVersion=21&groupId=com.mohit&artifactId=bookmarker-api&name=bookmarker-api&description=Demo%20project%20for%20Spring%20Boot&packageName=com.mohit.bookmarker&dependencies=devtools,lombok,configuration-processor,web,actuator,testcontainers,data-jpa,flyway,h2,postgresql,validation)

## How to run?

```shell
$ git clone https://github.com/mkr52/springboot-kubernetes.git
$ cd springboot-kubernetes
$ ./run.sh start
$ ./run.sh stop

$ ./run.sh start_infra
$ ./run.sh stop_infra
```

* To start only dependent services

```shell
$ ./run.sh start_infra
$ ./run.sh stop_infra
```

### Resources
[Spring Boot with Kubernetes](https://www.baeldung.com/spring-boot-kubernetes)

[Spring JPA Query Methods](https://docs.spring.io/spring-data/jpa/reference/repositories/query-keywords-reference.html)
