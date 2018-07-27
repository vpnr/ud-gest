# Base image
FROM openjdk:8-jdk-alpine

# Author
MAINTAINER vpnr vi.pannier@gmail.com

# Create directory in image
VOLUME /app

# Le jar qui doit etre inséré à l'image
ARG JAR_FILE

# La copie du jar dans le repertoire cible crée précédement
COPY ${JAR_FILE} /app/ud-gest-web.jar

# Installation de bash à l'image de base
RUN apk update && apk add bash

# Le point d'entré au démarage
# On précise ici le profil spring à utilisé par défaut
# On précise également un fichier de configuration externe au jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/ud-gest-web.jar","-Dspring.profiles.active=prod","--spring.config.location=file:/app/conf/conf.properties"]
