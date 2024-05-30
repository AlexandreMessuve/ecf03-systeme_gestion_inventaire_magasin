# ecf03-systeme_gestion_inventaire_magasin


## Bienvenue

**Vous trouverez dans ce repository**
- Le code source
- La base de donnée
- Le README

## Prérequis
- [JAVA-JDK en sa version 21](https://www.oracle.com/fr/java/technologies/downloads/#java21)
- [MySQL version 8.4.0 Community Server](https://dev.mysql.com/downloads/mysql/)


## Etape 1

Je vous invite a executer le script SQL pour avoir la base de donnée afin de ne pas perdre de temps et de tester l'application en version console.

## Etape 2
Renommer le fichier hibernate.properties.example en hibernate.properties et changer les champs ou il y a change me

## Etape 3
Pour acceder a l'application utiliser le MainController 
Une fois lancé vous aurez un menu et vous devrez choisir entre les differente catégories

Les articles(items) sera le premier dans le menu dedans vous aurez la création, la visualisation, la modification et la suppression des articles.

Les Client sera le second dans le menu dedans vous aurez la création, la visualisation, la modification et la suppression des clients.

Les ventes(sales & orders) sera le troisième et dernier du menu dedans vous aurez la possibilité d'enregistrer une vente, de modifier son status, de voir les ventes et de voir une vente en particulier grace a son id, la suppression de la vente et le nombre de vente realisé.


Actuellement il manque les stats & rapports des ventes.