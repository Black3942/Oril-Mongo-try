FROM openjdk:17-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.host=mongo-db", "-Dserver.port=8081", "-jar", "app.jar"]
