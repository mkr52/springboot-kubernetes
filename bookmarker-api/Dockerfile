FROM eclipse-temurin:21-jre
LABEL authors="mohitkumar"

ADD target/*.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]