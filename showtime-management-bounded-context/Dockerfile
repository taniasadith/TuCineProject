FROM openjdk:17-alpine
COPY ./target/showtime-management-bounded-context-0.0.1-SNAPSHOT.jar /
RUN sh -c 'touch showtime-management-bounded-context-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","/showtime-management-bounded-context-0.0.1-SNAPSHOT.jar"]
RUN chmod +x /showtime-management-bounded-context-0.0.1-SNAPSHOT.jar
