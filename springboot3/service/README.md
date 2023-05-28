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

## Consruire l'image native

```shell script
./gradlew bootBuildImage
``` 

## Lancer le test

Dans un shell lancer :

```shell script
../../loop-curl.sh
```

Dans un autre shell, lancer :

```shell script
date +"%T.%3N" &&  ./run-springboot-jvm.sh
```