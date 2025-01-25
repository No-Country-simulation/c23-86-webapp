FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/callcenter-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_callcenter.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_callcenter.jar"]