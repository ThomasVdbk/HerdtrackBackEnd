# Herdtrack Backend

Herdtrack est une application qui permet d'enregistrer, retrouver et suivre un animal.
Projet POC réalisé dans le cadre de la POEC, parcours développeur d'application Java, de l'école Aston.

Le projet est composé de 2 applications :
Herdtrack Backend : Logique métier accécible à partir d'une Api Rest.
Herdtrack Frontend : Application web pour les usagers. Client de Herdtrack Backend.

Le présent dépôt représente le code source du composant backend développé du projet.

Herdtrack Backend a été développé avec Spring Boot version 2.7.1

## Prérequis

- Java 17
- MySql 8.0.20
- Maven 3.3.9

## Déploiment

- Clonez le projet :

```shell
git clone https://github.com/ThomasVdbk/HerdtrackBackEnd.git
```

### Déployer:

- Créer une base de donnée dans MySql avec les paramétres suivants :

Nom de la base  : herdtrack

Identifiant : root
Mot de passe : root

Pour une installation personnalisée, vous pouvez modifier les valeurs des clès du fichier ressources/application.properties du projet :

```shell
spring.datasource.url=jdbc:mysql://localhost:3306/NOM_DATABASE?serverTimezone=Europe/Paris
spring.datasource.username=VOTRE_USERNAME
spring.datasource.password=VOTRE_PASSWORD
```
- Exécutez la commande maven dans votre terminal à la racine du projet Herdtrack Backend :

```shell
mvn spring-boot:run
```
SpringBoot va s'executer et se connecter à la base de donnée.

## Pour installer le client de l'application
 
```shell
https://github.com/ThomasVdbk/Herdtrack-Front-End.git
```