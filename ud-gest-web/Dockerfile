FROM openjdk:8-jdk-alpine
MAINTAINER vpnr vi.pannier@gmail.com
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} ud-gest-web.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=prod","-jar","/ud-gest-web.jar"]