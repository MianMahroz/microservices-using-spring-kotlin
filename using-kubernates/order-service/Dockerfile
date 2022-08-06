FROM java:8
ADD target/order-service.jar  order-service.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "order-service.jar"]