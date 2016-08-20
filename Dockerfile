FROM java:8
ADD target/nginx-springboot-demo-1.0-SNAPSHOT.jar /opt/spring/nginx-springboot-demo.jar
EXPOSE 8080
WORKDIR /opt/spring/
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "nginx-springboot-demo.jar"]