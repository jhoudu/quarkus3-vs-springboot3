# quarkus3-vs-springboot3

Projet de comparaison entre Quarkus 3 et Spring Boot 3

## Configurer le projet sous windows

Insaller WSL2

Utiliser la console Ubuntu

Installer la jvm Graalvm

```shell script
cd /usr/lib
sudo mkdir jvm 
sudo tar -xzf /mnt/c/Users/Jean-Emmanuel\ Houdu/Downloads/graalvm-ce-java17-linux-amd64-22.3.2.tar.gz 
```
Configuer l'environnement, en éditant ~/.profile

```shell script
# Configuration environnement Java
export GRAALVM_HOME=/usr/lib/jvm/graalvm-ce-java17-22.3.2
export JAVA_HOME=$GRAALVM_HOME
export PATH=$JAVA_HOME/bin:$PATH
```

Installer les fonction de compilation native.

```shell script
sudo gu install native-image
```

https://www.graalvm.org/22.1/docs/getting-started/linux/

https://quarkus.io/guides/building-native-image





## Mesurer le startup time

Lancer le shell pour la boucle de requête

```shell script
/loop-curl.sh
```

Lancer un des containers. Exemple :

```shell script
date +"%T.%3N" &&  ./quarkus3/service/run-quarkus-jvm.sh
```

Calculer la différence entre la première et la dernière date.

## Lancer docker compose

```shell script
docker compose up
```
