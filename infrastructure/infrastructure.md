# Infrastructure
Ce module permet de faire la communication avec des services externes au projet
Par exemple: Les base de données, un service rest ou SOAP ...etc
## Les interdits
>* Ce module ne peut avoir accès au module 'application'

## Les Autorisations
> * Les interfaces contenues dans 'org.hussard.flight.booking.business.adapter.out'
> * Par conséquence aux modèles de données `org.hussard.flight.booking.business.model`

## Comment définir un service

Il doit obligatoirement implémenter une interface du module 'application' 
contenu dans le package 'org.hussard.flight.booking.business.adapter.out'
Exemple: [ListOfAdultsRepositoryJson](org/hussard/flight/booking/infrastructure/repository/ListOfAdultsRepositoryJson.java)
## 
