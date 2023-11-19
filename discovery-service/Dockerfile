FROM openjdk:17-alpine
COPY ./target/discovery-service-0.0.1-SNAPSHOT.jar /
RUN sh -c 'touch discovery-service-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","/discovery-service-0.0.1-SNAPSHOT.jar"]
RUN chmod +x /discovery-service-0.0.1-SNAPSHOT.jar