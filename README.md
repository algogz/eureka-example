[![CI](https://github.com/tkgregory/eureka-example/actions/workflows/gradle.yml/badge.svg)](https://github.com/tkgregory/eureka-example/actions/workflows/gradle.yml)

An example Eureka setup with a Eureka server and 2 client microservices.

# Running

Build the Docker images:

`./gradlew bootBuildImage`

Start the Docker Compose environment:

`docker-compose up`

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

* all containers run in the same network, so they can address each other by hostname (e.g. *eureka*, *eureka-client-a*, *eureka-client-b*)
* each service registers itself with Eureka, located via property `eureka.client.serviceUrl.defaultZone`
* a service calls the other service using Eureka service discovery using *feign client* (e.g. see [ServiceBClient](eureka-client-a\src\main\java\com\tomgregory\eurekaexample\ServiceBClient.javajava/com/tomgregory/eurekaexample/ServiceBClient.java))

