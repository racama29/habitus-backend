# Etapa 1: construir la app
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: imagen final mínima
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar app.jar

ENV TZ=UTC
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
