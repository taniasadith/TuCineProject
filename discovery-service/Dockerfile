FROM openjdk:17-alpine
COPY ./target/discovery-server-0.0.1-SNAPSHOT.jar /
RUN sh -c 'touch discovery-server-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","/discovery-server-0.0.1-SNAPSHOT.jar"]
RUN chmod +x /discovery-server-0.0.1-SNAPSHOT.jar