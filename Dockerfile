FROM adoptopenjdk:8u212-b04-jre-hotspot-bionic
COPY target/poc-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java", "-jar","-Dspring.profiles.active=prod", "/app/app.jar"]
EXPOSE 8080
