FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install -DskipTests
FROM eclipse-temurin:21-jre
COPY --from=build /app/target/inventory-0.0.1-SNAPSHOT.jar /inventory-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/inventory-service.jar"]
