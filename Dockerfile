FROM adoptopenjdk/openjdk11:alpine-jre

ARG APP_NAME="spring-boot-validator"
ARG APP_VERSION="0.0.1"
ARG JAR_FILE="/target/${APP_NAME}-${APP_VERSION}.jar"

COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "app.jar"]