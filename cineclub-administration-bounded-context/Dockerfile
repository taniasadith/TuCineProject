FROM openjdk:17-alpine
COPY ./target/cineclub-administration-0.0.1-SNAPSHOT.jar /
RUN sh -c 'touch cineclub-administration-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","/cineclub-administration-0.0.1-SNAPSHOT.jar"]
RUN chmod +x /cineclub-administration-0.0.1-SNAPSHOT.jar