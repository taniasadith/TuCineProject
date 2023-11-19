FROM openjdk:17-alpine
COPY ./target/discovery-0.0.1-SNAPSHOT.jar /
RUN sh -c 'touch discovery-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","/discovery-0.0.1-SNAPSHOT.jar"]
RUN chmod +x /discovery-0.0.1-SNAPSHOT.jar