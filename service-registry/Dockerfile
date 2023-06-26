FROM openjdk:17
LABEL maintainer="burli.pranav3@gmail.com"
ARG JAR_PATH=target/service-registry-0.0.2.jar
COPY ${JAR_PATH} service-registry.jar
ENTRYPOINT [ "java","-jar","/service-registry.jar" ]
EXPOSE 8761