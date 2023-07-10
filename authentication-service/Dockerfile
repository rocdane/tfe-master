FROM openjdk:19
EXPOSE 8001
COPY target/authentication-service-0.0.1-SNAPSHOT.jar /opt
WORKDIR /opt
ENTRYPOINT ["java","-jar","./authentication-service-0.0.1-SNAPSHOT.jar"]