docker stop postgres
docker container rm postgres

docker build --tag svitlana:postgres12 .
docker run --name postgres -p 5433:5432 -e POSGRESS_PASSWORD=test -d svitlana:postgres12
docker ps