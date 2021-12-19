# to use JDK 11
FROM adoptopenjdk/openjdk11:alpine-jre

RUN addgroup yassir && adduser -S -G yassir yassir
USER yassir

VOLUME /tmp

EXPOSE 8090
COPY /target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]



