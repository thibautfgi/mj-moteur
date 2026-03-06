FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
# Cache des dépendances Maven
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
COPY start-mo.sh /app/start-mo.sh
RUN chmod +x /app/start-mo.sh

EXPOSE 8080
ENTRYPOINT ["/app/start-mo.sh"]
