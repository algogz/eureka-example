An example Eureka setup with a Eureka server and 2 microservices.

# Running

Build the Docker images:

`./gradlew bootBuildImage`

Start the Docker Compose environment:

`docker-compose up`

# Testing

View the Eureka dashboard at [http://localhost:8761](http://localhost:8761).
You should see 2 instances listed, *SERVICE-A* and *SERVICE-B*.

## service-a
* view status at [http://localhost:8081/actuator/health](http://localhost:8081/actuator/health)
* make call from *service-a* > *service-b* at [http://localhost:8081/call](http://localhost:8081/call)

## service-b
* view status at [http://localhost:8082/actuator/health](http://localhost:8082/actuator/health)
* make call from *service-b* > *service-a* at [http://localhost:8082/call](http://localhost:8082/call)

## Implementation details

* all containers run in the same network, so they can address each other by hostname (e.g. *eureka*, *service-a*, *service-b*)
* each service registers itself with Eureka, located via property `eureka.client.serviceUrl.defaultZone`
* a service calls the other service using Eureka service discovery using *feign client* (e.g. see [ServiceBClient](service-a\src\main\java\com\tomgregory\eurekaexample\ServiceBClient.javajava/com/tomgregory/eurekaexample/ServiceBClient.java))

