FROM node:18-alpine AS frontend-builder
WORKDIR /dooshop-front

COPY dooshop-front/package*.json ./
RUN npm install

COPY dooshop-front/ ./
RUN npm run build


FROM maven:3.9.4-eclipse-temurin-17-alpine AS backend-builder
WORKDIR /dooshop-back

COPY dooshop-back/pom.xml ./
RUN mvn dependency:go-offline

COPY dooshop-back/ ./
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=backend-builder /dooshop-back/target/*.jar /app/app.jar

COPY --from=frontend-builder /dooshop-front/dist /app/static

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "/app/app.jar"]