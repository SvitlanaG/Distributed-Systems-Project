# base image
FROM postgres:12.1

RUN  apt-get update
RUN DEBIAN_FRONTEND=noninteractive apt-get install -y net-tools
RUN DEBIAN_FRONTEND=noninteractive apt-get install -y emacs-nox

#        && rm -rf /var/lib/apt/lists/*

#COPY configure-database.sh /docker-entrypoint-initdb.d/
#RUN chmod 755 /docker-entrypoint-initdb.d/*.sh

COPY configure-database.sql /docker-entrypoint-initdb.d/configure-database.sql

EXPOSE 5433:5432
