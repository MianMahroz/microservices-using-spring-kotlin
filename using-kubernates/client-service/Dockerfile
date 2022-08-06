FROM java:8
ADD target/client-service.jar  client-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "client-service.jar"]