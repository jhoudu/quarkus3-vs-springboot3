# service

Service REST

Avec la même API que le service SpringBoot.

## Créer l'image jvm

```shell script
./gradlew assemble

docker build -f src/main/docker/Dockerfile.jvm -t quarkus/service-jvm .
docker run -i --rm -p 8080:8080 quarkus/service-jvm
```

## Créer une app native windows
Installer les prérequis, voir :

https://medium.com/graalvm/using-graalvm-and-native-image-on-windows-10-9954dc071311

Lancer la commande suivante (tester avec cmd ou adapter Linux / Powershell)

```shell script
& "C:\Program Files (x86)\Microsoft Visual Studio\2017\BuildTools\VC\Auxiliary\Build\vcvars64.bat" 

gradlew build -Dquarkus.package.type=native
```

SI KO, essayer :
Lancer l'invite de commande Visual Studio via le menu windows :

Start -> Visual Studio 2019 -> Tools -> x64 Native Tools Command Prompt

puis :

```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

## Créer une app native Linux

Lancer la commande suivante sur cmd (ou adapter à linux / powershell) :

```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

## Créer l'image native docker

```shell script
docker build -f src/main/docker/Dockerfile.native -t quarkus/service-micro .
```

Puis

## Lancer le test

Dans un shell lancer :

```shell script
../../loop-curl.sh
```

Dans un autre shell, lancer :

```shell script
date +"%T.%3N" &&  ./run-quarkus-jvm.sh
```

# Documentation générée

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./gradlew build
```
It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/service-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling.

## Related Guides

- JDBC Driver - H2 ([guide](https://quarkus.io/guides/datasource)): Connect to the H2 database via JDBC
- Quarkus Extension for Spring Web API ([guide](https://quarkus.io/guides/spring-web)): Use Spring Web annotations to create your REST services
- Quarkus Extension for Spring Boot properties ([guide](https://quarkus.io/guides/spring-boot-properties)): Use Spring Boot properties annotations to configure your application

## Provided Code

### Spring Web

Spring, the Quarkus way! Start your RESTful Web Services with a Spring Controller.

[Related guide section...](https://quarkus.io/guides/spring-web#greetingcontroller)
