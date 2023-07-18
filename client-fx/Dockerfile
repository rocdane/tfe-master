FROM openjdk:19
EXPOSE 12735
COPY out/artifacts/client_jar/client.jar /opt
WORKDIR /opt
CMD ["java","-jar","./client.jar"]
