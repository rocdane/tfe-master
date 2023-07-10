FROM openjdk:19
EXPOSE 8006
COPY target/report-service-0.0.1-SNAPSHOT.jar /opt
WORKDIR /opt
ENTRYPOINT ["java", "-jar","./report-service-0.0.1-SNAPSHOT.jar"]