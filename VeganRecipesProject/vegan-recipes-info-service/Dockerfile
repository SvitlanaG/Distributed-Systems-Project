# base image
FROM hirokimatsumoto/alpine-openjdk-11

# Adding a VOLUME at /tmp, because it's the Tomcat default working dir, created by Spring-Boot,
# change if you're going to use Netty or not needed at all!
VOLUME /tmp

# make port 8082 available to the world outside this container
EXPOSE 8082


# add application artifact, strip group (if present) and version, and rename it
## because we are not in 'root' but in 'docker' folder,
## we have to navigate up (../) and navigate into target, to find the created *.jar file
COPY target/*.jar vegan-recipes-info-service.jar

# Execute the application [with parameters (if needed)]
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/vegan-recipes-info-service.jar"]