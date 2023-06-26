FROM openjdk:17
LABEL maintainer="burli.pranav3@gmail.com"
ARG JAR_PATH= target/*.jar
COPY ${JAR_PATH} api-gateway.jar
ENTRYPOINT [ "java","-jar","/api-gateway.jar" ]
EXPOSE 8181