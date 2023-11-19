FROM openjdk:17-alpine
COPY ./target/reservation-purchase-bounded-context-0.0.1-SNAPSHOT.jar /
RUN sh -c 'touch reservation-purchase-bounded-context-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","/reservation-purchase-bounded-context-0.0.1-SNAPSHOT.jar"]
RUN chmod +x /reservation-purchase-bounded-context-0.0.1-SNAPSHOT.jar
