FROM openjdk:19
COPY target/customer-service-0.0.1-SNAPSHOT.jar /opt
WORKDIR /opt
ENTRYPOINT ["java","-jar","./customer-service-0.0.1-SNAPSHOT.jar"]