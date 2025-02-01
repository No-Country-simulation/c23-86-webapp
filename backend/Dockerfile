# Usar una imagen de Java 17 más ligera
FROM eclipse-temurin:17-jre-alpine

# Crear un usuario no root por seguridad
RUN addgroup -S spring && adduser -S spring -G spring

# Configurar el directorio de trabajo
WORKDIR /app

# Definir un volumen para datos persistentes (H2 modo archivo)
VOLUME /app/data

# Copiar el archivo JAR al contenedor
COPY target/callcenter-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto de la aplicación
EXPOSE 8080

# Ejecutar la aplicación correctamente
CMD ["java", "-jar", "app.jar"]

