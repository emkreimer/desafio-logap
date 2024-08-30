# FROM ubuntu:22.04 AS build

# RUN apt-get update
# RUN apt-get install openjdk-17-jdk -y
# COPY . .
#
# RUN apt-get install maven -y
# RUN mvn clean install
#
# FROM openjdk:17-jdk-slim
#
# EXPOSE 8080
#
# COPY --from=build /target/dooshop-0.0.1-SNAPSHOT.jar dooshop.jar
#
# ENTRYPOINT [ "java", "-jar", "dooshop.jar" ]


FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/dooshop-0.0.1-SNAPSHOT.jar /app/dooshop.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "dooshop.jar"]
