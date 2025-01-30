# Usar una imagen de Java 17
FROM eclipse-temurin:17-jdk-alpine

# Configurar el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR al contenedor
COPY target/callcenter-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto de la aplicación (cambia el 8080 si usas otro puerto)
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
