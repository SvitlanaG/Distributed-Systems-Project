# Distributed-Systems-Project - Vegan recipes application 

3 microservices created with Spring Boot


### Idee


Viele Menschen wollen sich gesund ernähren. Gewohnheiten zu ändern fällt es jedoch oft schwer.
Wäre es leichter, wenn man einen Katalog erstellen könnte und dort verschiedene Rezepte, die er im Internet gefunden hat, bewerten könnte?
Einen solchen Service für vegane Ernährung habe ich im Rahmen des VS-Modules entwickelt.

<img align="center" width="800" height="500" src="https://github.com/SvitlanaG/Distributed-Systems-Project/blob/master/VeganRecipesApp.png">


### Verwendete Software-Technologien

* Java Spring - Back-End
* Angular - Front-End
* PostgreSQL - Datenbank
* Postman - API Testing
* Docker - Containervirtualisierung


### Projektanforderungen

#### 3 Microservices

##### Info-Service
  * ist verantwortlich für die Rezepteinformation
  * nimmt eine Rezept-ID und liefert die Rezept-Information ("titel", "image", "sourceUrl") aus einer externen API zurück
  * Port 8082
  * API-Endpoint: http://localhost:8082/vegan-recipes/634792

##### Rating-Data-Service
  * REST API, die CRUD Abfragen ermöglicht
  * speichert die Benutzerbewertung in einer PostgreSQL Datenbank
  * liefert die Benutzerbewertung mit den Feldern: "recipe_id" und "userRating"
  * Port 8083
  * API-Endpoints: http://localhost:8083/rating/list , http://localhost:8083/rating/show/1


##### Catalog-Service
  * liefert Rezeptliste mit den Feldern: "recipe_id", "titel", "image", "sourceUrl" und "userRating"
  * kommuniziert synchron mit zwei anderen Microservices über einen HTTP-Client, bekommt die Daten und stellt sie zusammen
  * Port 8081
  * API-Endpoint: http://localhost:8081/catalog/userid
