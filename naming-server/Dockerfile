FROM openjdk:19
EXPOSE 8761
COPY target/naming-server-0.0.1-SNAPSHOT.jar /opt
WORKDIR /opt
ENTRYPOINT ["java","-jar","./naming-server-0.0.1-SNAPSHOT.jar"]