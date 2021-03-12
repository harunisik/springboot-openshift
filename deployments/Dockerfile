FROM fabric8/java-centos-openjdk8-jdk:1.8.0
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} /deployments/app.jar
ENV JAVA_APP_JAR app.jar
CMD /deployments/run-java.sh