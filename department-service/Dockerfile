FROM openjdk:17
LABEL maintainer="burli.pranav3@gmail.com"
ARG JAR_PATH= target/*.jar
COPY ${JAR_PATH} department-service.jar
ENTRYPOINT [ "java","-jar","/department-service.jar" ]
EXPOSE 9001