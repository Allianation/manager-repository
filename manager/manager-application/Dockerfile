# For Java 15, try this
FROM azul/zulu-openjdk-alpine:15

# Refer to Maven build -> finalName
ARG JAR_FILE=target/manager-application-2.4.4.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/manager-application-2.4.4.jar /opt/app/manager-application-2.4.4.jar
COPY ${JAR_FILE} manager-application-2.4.4.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","manager-application-2.4.4.jar"]
