# Business
Ce module cintiendra juste la partie métier

## les interdits
>Le métier ne communiquera **jamais** directement avec un composant des modules 
> * application
> * infrastructure

## J'ai besoin de l'infra
>Si le métier doit communiquer avec le module infrastructure(DB,Rest,Json...etc), il doit utiliser des interfaces définies
> dans le package **org.hussard.flight.booking.business.adapter.out**
>> Exemple: [ListOfAdultsRepository](org/hussard/flight/booking/business/adapter/out/ListOfAdultsRepository.java)

## Comment fournir un service à une application
>Le metier fournit des cases d'usages à l'application via des interfaces définies 
> dans le package **org.hussard.flight.booking.business.adapter.in**
> exemple : [ListOfAdults](org/hussard/flight/booking/business/adapter/in/ListOfAdults.java).
> l'implementation du service sera dans le package **org.hussard.flight.booking.business.services**
>> Exemple :[ListOfAdultsService](org/hussard/flight/booking/business/services/ListOfAdultsService.java)


