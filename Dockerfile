FROM openjdk:8-jdk-alphine

EXPOSE 8080
 
ADD target/Address-1.jar Address-1.jar

ENTRYPOINT ["java","-jar,"Address-1.jar"]