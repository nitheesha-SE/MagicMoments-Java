#!/usr/bin/env bash
#copy over shopping poc
cp -R ../webpack-react-boilerplate/build src/main/resources/static
mvn clean package -DskipTests
# Deploy to Pavan Azure
curl -X POST -u deploy89 --data-binary @"target/gs-spring-boot-0.1.0.war" https://dev-ifttt.scm.azurewebsites.net/api/wardeploy
curl -H "IFTTT-Channel-Key: VALID" https://dev-ifttt.azurewebsites.net/ifttt/v1/status
