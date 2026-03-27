FROM eclipse-temurin:17-jdk-alpine
WORKDIR /home/app
COPY target/*.jar /home/app/my-spring-boot-app.jar
EXPOSE 8080
CMD ["java", "-jar", "/home/app/my-spring-boot-app.jar"]

