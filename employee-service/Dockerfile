FROM openjdk:17
LABEL maintainer="burli.pranav3@gmail.com"
ARG JAR_PATH=target/*.jar
COPY ${JAR_PATH} employee-service.jar
ENTRYPOINT [ "java","-jar","/employee-service.jar" ]
EXPOSE 9002