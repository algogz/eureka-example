#!/bin/bash

echo "Pushing eureka-server"
docker tag eureka-server:latest tkgregory/eureka-server:latest
docker push tkgregory/eureka-server:latest

echo "Pushing eureka-client-a"
docker tag eureka-client-a:latest tkgregory/eureka-client-a:latest
docker push tkgregory/eureka-client-a:latest

echo "Pushing eureka-client-b"
docker tag eureka-client-b:latest tkgregory/eureka-client-b:latest
docker push tkgregory/eureka-client-b:latest