FROM java:8
ADD target/delivery-service.jar  delivery-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "delivery-service.jar"]