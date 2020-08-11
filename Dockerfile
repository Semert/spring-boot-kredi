FROM openjdk:11
EXPOSE 8080
ADD target/springboot-interview-project.jar springboot-interview-project.jar
ENTRYPOINT ["java","-jar","/springboot-interview-project.jar"]