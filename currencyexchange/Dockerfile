FROM openjdk:8-alpine
VOLUME /tmp
COPY /target/currencyexchange-*.jar currencyexchange.jar
COPY src src
COPY Dockerfile Dockerfile
COPY pom.xml pom.xml
ENTRYPOINT ["java", "-jar", "currencyexchange.jar"]
