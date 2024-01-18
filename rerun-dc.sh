#/bin/bash
docker-compose stop
docker-compose rm -f
docker image rm --force web-api-employees:latest
gradle clean bootJar
docker-compose up -d