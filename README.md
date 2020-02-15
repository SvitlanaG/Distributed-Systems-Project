# Distributed-Systems-Project - Vegan recipes application 

3 microservices created with Spring Boot


## Idee


Viele Menschen wollen sich gesund ernähren. Gewohnheiten zu ändern fällt es jedoch oft schwer.
Wäre es leichter, wenn man einen Katalog erstellen könnte und dort verschiedene Rezepte, die er im Internet gefunden hat, bewerten könnte?
Einen solchen Service für vegane Ernährung habe ich im Rahmen des VS-Modules entwickelt.

<img align="center" width="800" height="500" src="https://github.com/SvitlanaG/Distributed-Systems-Project/blob/master/VeganRecipesApp.png">


## Verwendete Software-Technologien

* Java Spring - Back-End
* Angular - Front-End
* PostgreSQL - Datenbank
* Postman - API Testing
* Docker - Containervirtualisierung


## Projektanforderungen

### 3 Microservices

#### Info-Service
  * ist verantwortlich für die Rezepteinformation
  * nimmt eine Rezept-ID und liefert die Rezept-Information ("titel", "image", "sourceUrl") aus einer externen API zurück
  * Port 8082
  * API-Endpoint: http://localhost:8082/vegan-recipes/634792

#### Rating-Data-Service
  * REST API, die CRUD Abfragen ermöglicht
  * speichert die Benutzerbewertung in einer PostgreSQL Datenbank
  * liefert die Benutzerbewertung mit den Feldern: "recipe_id" und "userRating"
  * Port 8083
  * API-Endpoints: http://localhost:8083/rating/list , http://localhost:8083/rating/show/1


#### Catalog-Service
  * liefert Rezeptliste mit den Feldern: "recipe_id", "titel", "image", "sourceUrl" und "userRating"
  * kommuniziert synchron mit zwei anderen Microservices über einen HTTP-Client, bekommt die Daten und stellt sie zusammen
  * Port 8081
  * API-Endpoint: http://localhost:8081/catalog/userid
  
### User-Interface
  * dem Benutzer wird eine Liste mit den Rezepten angezeigt, die er bewertet hat
  * der Benutzer hat die Möglichkeit einen Rezept sich anzushauen, indem er auf den Button "Get the recipe" drückt
  * http://localhost:4200
  
  
### Infrastrukturkomponenten

#### Configuration Server
 * haltet die Konfiguration der Microservices in einem zentralen Github-Repository https://github.com/SvitlanaG/Distributed-Systems-Project-Configs
 * Port 8888
 
#### Discovery Server - Eureka
 * fasst die Services, ihre Instanzen und Lokationen in einer Datenstruktur zusammen
 * Port 8761
 <img align="center" width="1600" height="500" src="https://github.com/SvitlanaG/Distributed-Systems-Project/blob/master/Eureka.png">
 
### 2 Resilience patterns

#### Circuit Breaker - Hystrix
Da es eine externe API in dem Info-Service benutzt wird, kann dies mittels kaskadierenden Fehlern auch weitere Anwendungen zum Ausfall bringen. Um das zu vermeiden, ist ein Circuit Breaker eingesetzt. Dieses Verfahren lässt sich sehr leicht testen. Wenn WLAN deaktiviert ist, wird statt Rezepteinfo "n/a" ausgegeben.
<img align="center" width="1000" height="500" src="https://github.com/SvitlanaG/Distributed-Systems-Project/blob/master/Hystrix.png">
 
 
#### REST Client - FeignClient
Der Feign-Service erlaubt es, die Kommunikation zwischen Microservices abzubilden, ohne selbst den notwendigen Code für den Aufruf von RESTful Services schreiben zu müssen. In jedem der drei Services wurde ein Interface MyFeignClient und eine Klasse MyFeignController angelegt. Wenn man mehrere Instanzen von den Microservices erstellt, fragt FeignClient sie dann nach dem Round-Robin-Prinzip ab.
  
  
### Scaling capabilities - Docker
Alle Microservices wurden dockeriziert. Das ermöglicht Skalieren und ausführen der Services in einer Cloud-Infrastruktur.

## Projekt starten
 * Docker installieren und starten, falls dies noch nicht erfolgt ist
 * Terminal aufmachen
 * Projekt clonen: `git clone git@github.com:SvitlanaG/Distributed-Systems-Project.git` oder `git clone https://github.com/SvitlanaG/Distributed-Systems-Project.git`
#### Um eine Datenbank als separate service anzulegen, sind folgende Schritte notwendig:
 * zu dem Verzeichnis `persistence` navigieren: `cd <checkout>/persistence/`
 * den Befehl `docker build --tag svitlana:postgres12 .` ausführen
 * den Befehl `docker run --name postgres -p 5433:5432 -e POSGRESS_PASSWORD=test -d svitlana:postgres12` ausführen
 * Ausführung überprüfen `docker ps`
 
 
 ### config-server starten:

1. `cd <checkout>/config-server/`
2. `./mvnw clean install`
3. `docker build -t config-server .`
4. `docker run -p 8888:8888 config-server`

 ### discovery-server starten:

1. `cd <checkout>/discovery-server/`
2. `./mvnw clean install`
3. `docker build -t discovery-server .`
4. `docker run -p 8761:8761 discovery-server`

 ### vegan-recipes-rating-data-service starten:

1. `cd <checkout>/vegan-recipes-rating-data-service/`
2. `./mvnw clean install`
3. `docker build -t vegan-recipes-rating-data-service .`
4. `docker run -p 8083:8083 vegan-recipes-rating-data-service`

 ### vegan-recipes-info-service starten:

1. `cd <checkout>/vegan-recipes-info-service/`
2. `./mvnw clean install`
3. `docker build -t vegan-recipes-info-service .`
4. `docker run -p 8082:8082 vegan-recipes-info-service`

 ### vegan-recipes-catalog-service starten:

1. `cd <checkout>/vegan-recipes-catalog-service /`
2. `./mvnw clean install`
3. `docker build -t vegan-recipes-catalog-service  .`
4. `docker run -p 8081:8081 vegan-recipes-catalog-service `
