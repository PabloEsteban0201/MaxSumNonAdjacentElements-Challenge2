# Usar una imagen base con JDK 8 y Gradle
FROM gradle:8.5-jdk17 AS build

# Establecer un directorio de trabajo
WORKDIR /app

# Copiar archivos de tu proyecto al directorio de trabajo
COPY . /app

# Ejecutar Gradle para construir el proyecto
RUN gradle clean build

FROM openjdk:17-jdk-slim-buster
EXPOSE 8080
COPY --from=build /app/build/libs/MaxSumTheftAPI-0.0.1-SNAPSHOT.war /app/app.war
ENTRYPOINT [ "java","-jar","/app/app.war" ]