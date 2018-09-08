#!/usr/bin/env bash
mvn clean package
cp target/gs-spring-boot-0.1.0.jar .
git add -A
git commit -m "new version"
git push
