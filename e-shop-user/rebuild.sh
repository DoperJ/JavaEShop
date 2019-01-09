#!/bin/bash
docker stop user
docker rm user
docker rmi doperj/e-shop-user
mvn clean package -Dmaven.test.skip=true docker:build
docker run -d --name user -p 8081:8081 doperj/e-shop-user
