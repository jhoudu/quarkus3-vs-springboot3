# service

Service json/http

Repris de https://github.com/joshlong/bootiful-spring-boot-3/

## Lancer le projet en mode dev

```shell script
./gradlew bootRun 
```

## Construire l'application jvm

```shell script
./gradlew assemble

docker build -f src/main/docker/Dockerfile.jvm -t springboot/service-jvm .
``` 

Pour la lancer

```shell script
docker run -i --rm -p 8080:8080 springboot/service-jvm
```

## Consruire l'image native

```shell script
./gradlew bootBuildImage
``` 

Pour la lancer

```shell script
docker run -ti --rm -p 8080:8080 service:0.0.1-SNAPSHOT
```
