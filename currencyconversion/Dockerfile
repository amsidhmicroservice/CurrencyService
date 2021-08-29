FROM openjdk:8-alpine
VOLUME /tmp
COPY /target/currencyconversion-*.jar currencyconversion.jar
COPY src src
COPY Dockerfile Dockerfile
COPY pom.xml pom.xml
ENTRYPOINT ["java", "-jar", "currencyconversion.jar"]