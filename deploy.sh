#!/usr/bin/env bash
mvn clean package -DskipTests
cp target/gs-spring-boot-0.1.0.jar .
git add -A
git commit -m "new deploy"
# Deploy to Inno Lab Aure
git push origin
# Deploy to Pavan Azure
curl -X POST -u deploy89 --data-binary @"target/gs-spring-boot-0.1.0.war" https://dev-ifttt.scm.azurewebsites.net/api/wardeploy
curl -H "IFTTT-Channel-Key: VALID" https://7d77d4069bab1b5b.azurewebsites.net/ifttt/v1/status
curl -H "IFTTT-Channel-Key: VALID" https://dev-ifttt.azurewebsites.net/ifttt/v1/status