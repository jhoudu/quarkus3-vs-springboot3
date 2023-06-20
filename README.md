# quarkus3-vs-springboot3

Comparaison entre Quarkus 3 et Spring Boot 3 sur une service REST de liste de clients (noms).
Test de GraalVM et des exécutions JVM et natives.
Test du monitioring :
* cAvisor
* Prometheus
* Grafana

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

Dans un shell lancer :

```shell script
bash -c 'while [[ "$(curl -s -o /dev/null -w ''%{http_code}'' localhost:8080/customers/Josh)" != "200" ]]; do sleep .00001; done'
```

Dans un autre shell, lancer un des containers à tester :

```shell script
date +"%T.%3N" && docker run -ti --rm -p 8080:8080 quarkus/service-jvm
```

Calculer la différence entre la première et la dernière date.

## Lancer docker compose

Dans le répertoire <répertoire projet>/docker-compose :

```shell script
docker compose up
```

## Corriger les problèmes sur cAdvisor

Il semble que cAdvisor soit instable avec WSL2.

Si cAdvisor ne récupère les metrics des containers alors il faut appliquer la solution ci-dessous.

Le bon chemin pour le dossier à monter se vérifie dans le navigateur (icône Linux).

https://github.com/logos-co/wakurtosis/issues/58

Au premier lancement, tester sans les lignes suivantes dans docker-compose.yml :

```shell script
      - /etc/machine-id:/etc/machine-id:ro # <--- new volume
      - /mnt/windows_docker/:/rootfs/var/lib/docker:ro # <--- new volume
```
