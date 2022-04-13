[![CI](https://github.com/tkgregory/eureka-example/actions/workflows/gradle.yml/badge.svg)](https://github.com/tkgregory/eureka-example/actions/workflows/gradle.yml)

An example Eureka setup with a Eureka server and 2 client microservices. 

This repository accompanies the article [How to Deploy Eureka into AWS ECS](https://tomgregory.com/how-to-deploy-eureka-into-aws-ecs/).

# Running

Build the Docker images:

`./gradlew bootBuildImage`

Start the Docker Compose environment:

`docker-compose up`

**Note: you may need to wait some time before the following steps work.**

# Testing

View the Eureka dashboard at [http://localhost:8761](http://localhost:8761).
You should see 2 instances listed, *EUREKA-CLIENT-A* and *EUREKA-CLIENT-B*.

## eureka-client-a
* view status at [http://localhost:8081/actuator/health](http://localhost:8081/actuator/health)
* make call from *eureka-client-a* > *eureka-client-b* at [http://localhost:8081/call](http://localhost:8081/call)

## eureka-client-b
* view status at [http://localhost:8082/actuator/health](http://localhost:8082/actuator/health)
* make call from *eureka-client-b* > *eureka-client-a* at [http://localhost:8082/call](http://localhost:8082/call)

## Implementation details

* all containers run in the same network, so they can address each other by hostname (e.g. *eureka-client*, *eureka-client-a*, *eureka-client-b*)
* each Eureka client registers itself with the Eureka server, located via property `eureka.client.serviceUrl.defaultZone`
* a Eureka client calls the other Eureka client through Eureka service discovery using a *feign client* (e.g. see *[EurekaClientBClient](eureka-client-a\src\main\java\com\tomgregory\eurekaexample\EurekaClientBClient.java)*)

