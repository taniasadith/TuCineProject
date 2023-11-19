FROM openjdk:17-alpine
COPY ./target/config-server-1.0.0-SNAPSHOT.jar /
RUN sh -c 'touch config-server-1.0.0-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","/config-server-1.0.0-SNAPSHOT.jar"]
RUN chmod +x /config-server-1.0.0-SNAPSHOT.jar