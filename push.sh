#!/bin/bash

aws ecr get-login-password --region eu-west-1 | docker login --username AWS --password-stdin 299404798587.dkr.ecr.eu-west-1.amazonaws.com

echo "Pushing eureka"
docker tag eureka:latest 299404798587.dkr.ecr.eu-west-1.amazonaws.com/eureka:latest
docker push 299404798587.dkr.ecr.eu-west-1.amazonaws.com/eureka:latest

echo "Pushing service-a"
docker tag service-a:latest 299404798587.dkr.ecr.eu-west-1.amazonaws.com/service-a:latest
docker push 299404798587.dkr.ecr.eu-west-1.amazonaws.com/service-a:latest

echo "Pushing service-b"
docker tag service-b:latest 299404798587.dkr.ecr.eu-west-1.amazonaws.com/service-b:latest
docker push 299404798587.dkr.ecr.eu-west-1.amazonaws.com/service-b:latest