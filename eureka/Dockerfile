FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install -DskipTests
FROM eclipse-temurin:21-jre
COPY --from=build /app/target/eureka-0.0.1-SNAPSHOT.jar /eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/eureka-server.jar"]
