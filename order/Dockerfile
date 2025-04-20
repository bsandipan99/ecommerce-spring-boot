FROM maven:3.9.5-eclipse-temurin-21-jammy AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install -DskipTests
FROM eclipse-temurin:21-jre
COPY --from=build /app/target/order-service-0.0.1-SNAPSHOT.jar /order-service.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "/order-service.jar"]
