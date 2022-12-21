## LOCALIB (Back-End)

Auteur : Maxime HAVEZ

# Description

Cette application a pour but de gérer la location de véhicule de la société Localib

# Pré-requis

- Java 12+
- [Docker](https://docs.docker.com/get-docker/)
- [docker-compose](https://docs.docker.com/compose/install/)
- Un IDE Java ([Eclipse](https://www.eclipse.org/downloads/), [IntelliJ](https://www.jetbrains.com/fr-fr/idea/))
- [Postman](https://www.postman.com/)

## Installation

### Installation de la base de données

Dans un terminal, exécutez la commande suivante avec Docker de lancé:
```bash
docker-compose up -d
```

### Installation du projet

Dans votre IDE, chargez le projet Maven `pom.xml`.

## Utilisation

### Lancement de l'application

Dans votre IDE, lancez la classe `fr.maxime.ecfback`.

### Utilisation de l'application

L'application est accessible à l'adresse suivante: [http://localhost:8080](http://localhost:8080)<br>
Les requêtes Postman sont disponible dans la documentation des fonctions