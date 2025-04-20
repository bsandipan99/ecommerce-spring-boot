FROM maven:3.9.3-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install -DskipTests
FROM eclipse-temurin:21-jre
COPY --from=build /app/target/product-service-0.0.1-SNAPSHOT.jar /product-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/product-service.jar"]
