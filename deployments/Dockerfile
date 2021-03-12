# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
#LABEL maintainer="aashish.choudhary1@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8778

# The application's jar file
ARG JAR_FILE=*.jar

# Add the application's jar to the container
ADD ${JAR_FILE} springboot-kubernetes.jar

# hook test

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springboot-kubernetes.jar"]