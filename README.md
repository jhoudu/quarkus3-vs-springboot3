# quarkus3-vs-springboot3

Projet de comparaison entre Quarkus 3 et Spring Boot 3

## Mesurer le startup time

Lancer le shell pour la boucle de requête

```shell script
/loop-curl.sh
```

Lancer le container

```shell script
date +"%T.%3N" &&  ./quarkus3/service/run-quarkus-jvm.sh
```

Calculer la différence entre la première et la dernière date.

## Lancer docker compose

```shell script
docker compose up
```