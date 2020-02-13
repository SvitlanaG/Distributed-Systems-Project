docker stop postgres12
docker container rm postgres12

docker build --tag svitlana:postgres12 .
docker run --name postgres -p 5432:5432 -e POSGRESS_PASSWORD=test -d svitlana:postgres12
docker ps