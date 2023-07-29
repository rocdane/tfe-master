FROM openjdk:19
EXPOSE 8004
WORKDIR /opt
COPY etl ./etl
RUN chmod +x etl/tfe_master/tfe_master_run.sh
COPY target/monitoring-service-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","./monitoring-service-0.0.1-SNAPSHOT.jar"]