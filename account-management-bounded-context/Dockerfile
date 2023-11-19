FROM openjdk:17-alpine
COPY ./target/springboot-mysql-docker.jar /
RUN sh -c 'touch springboot-mysql-docker.jar'
ENTRYPOINT ["java","-jar","/springboot-mysql-docker.jar"]
RUN chmod +x /springboot-mysql-docker.jar