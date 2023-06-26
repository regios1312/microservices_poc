FROM openjdk:17
LABEL maintainer="burli.pranav3@gmail.com"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} alternate-config-server.jar
ENTRYPOINT [ "java", "-jar", "/alternate-config-server.jar" ]
EXPOSE 9296