#!/usr/bin/env bash
mvn clean package -DskipTests
cp target/gs-spring-boot-0.1.0.jar .
git add -A
git commit -m "new deploy"
git push
curl -H "IFTTT-Channel-Key: VALID" https://7d77d4069bab1b5b.azurewebsites.net/ifttt/v1/status