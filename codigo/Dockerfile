#Entorno de trabajo
FROM maven:3.8.3-openjdk-17 AS build

#Copiar todos los archivos del proyecto
COPY . .

#Paquetes de maven
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:17-jdk-slim

# Copiar el archivo JAR construido desde la etapa de construcción
COPY --from=build /target/SignchatMS-0.0.1-SNAPSHOT.jar SignchatMS.jar

# Exponer el puerto 8080 para que la aplicación sea accesible
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "SignchatMS.jar"]