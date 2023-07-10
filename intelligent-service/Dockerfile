FROM openjdk:19
EXPOSE 8005
COPY target/intelligent-service-0.0.1-SNAPSHOT.jar /opt
WORKDIR /opt
ENTRYPOINT ["java","-jar","./intelligent-service-0.0.1-SNAPSHOT.jar"]