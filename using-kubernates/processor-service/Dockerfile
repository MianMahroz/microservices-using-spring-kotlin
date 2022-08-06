FROM java:8
ADD target/processor-service.jar  processor-service.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "processor-service.jar"]