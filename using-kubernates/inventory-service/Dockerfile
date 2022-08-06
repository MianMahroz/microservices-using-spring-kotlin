FROM java:8
ADD target/inventory-service.jar  inventory-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "inventory-service.jar"]