#!/bin/bash
docker stop order
docker rm order
docker rmi doperj/e-shop-order
mvn clean package -Dmaven.test.skip=true docker:build
docker run -d --name order -p 8083:8083 doperj/e-shop-order
