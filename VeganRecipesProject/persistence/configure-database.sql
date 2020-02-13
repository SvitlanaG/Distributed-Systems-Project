
CREATE USER rating_db_user;
CREATE DATABASE rating;

GRANT ALL PRIVILEGES ON DATABASE rating TO rating_db_user;
ALTER USER rating_db_user WITH LOGIN PASSWORD 'password';

\c rating

CREATE TABLE Rating (
    _id SERIAL PRIMARY KEY,
    recipe_id VARCHAR(20),
    rating integer
);

ALTER TABLE Rating OWNER TO rating_db_user;



insert into rating(recipe_Id, rating) values ('716426', '5');
insert into rating(recipe_Id, rating) values ('640062', '5');
insert into rating(recipe_Id, rating) values ('649931', '3');
insert into rating(recipe_Id, rating) values ('715543', '4');
insert into rating(recipe_Id, rating) values ('716406', '5');