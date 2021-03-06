FROM openjdk:11.0-jre-slim

ARG JAR_FILE=fake-runner-app/target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
