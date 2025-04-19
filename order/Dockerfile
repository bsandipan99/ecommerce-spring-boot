FROM openjdk:21-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/order-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/app.jar"]
