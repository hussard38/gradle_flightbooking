# flight booking
Cette application doit permettre de réaliser des réservations de vol 

# Structure du projet
La structure du projet respecte le principe hexagonal

Pour cela, elle contient trois modules
* [application](application/application.md): qui peut être un batch, une application du type spring boot et bien d'autres
* [business](business/business.md) : tout ce qui est métier, pour simplifier les règles métier
* [infrastructure](infrastructure/infrastructure.md): Tout ce qui est externe à l'application
  * une base de données
  * un service REST
  * un fichier
  * ....etc

# Les Règles
Le respecte des règles seront réalisées par l'outil '[ArchUnit](https://www.archunit.org/)'  
## Application
* Accès aux adapter, services et model du module business
* Accès uniquement service qui implémente une interface de l'adapter.out
## business

# Les avantages

* préserver la logique métier.
* la testabilité
* une grande flexibilité.

# Les inconvenients

* la séparation reste floue
* le développeur d’être vigilant et de savoir où il doit implémenter ses ports ou ses adaptateurs ce qui sous-entend une bonne compréhension de l’architecture
* beaucoup d’objets, la quantité d’objets et les liens entre ces objets, peuvent s’avérer compliqués à appréhender
