FROM openjdk:17-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} cd-api-gateway-microservice.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/cd-api-gateway-microservice.jar"]