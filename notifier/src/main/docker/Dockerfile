FROM openjdk:8

# Reference: https://spring.io/guides/gs/spring-boot-docker/
#   VOLUME pointing to "/tmp" 
#       A Spring Boot application creates working directories for Tomcat by default in /tmp. 
#       The effect is to create a temporary file on your host under "/var/lib/docker" 
#       and link it to the container under "/tmp". This step is optional for the simple app that we wrote here, 
#       but can be necessary for other Spring Boot applications if they need to actually write in the filesystem.
VOLUME /tmp

# Enable remote debug
ENV JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=6000"
# kafak server for log collection
# ENV KAFKA_SERVER="10.220.202.120:9092"

ADD ./target/notifier-0.0.1-SNAPSHOT.jar app.jar

# You can use a RUN command to "touch" the jar file so that it has a file modification time 
# (Docker creates all container files in an "unmodified" state by default). 
# This actually isn't important for the simple app that we wrote, but any static content 
# (e.g. "index.html") would require the file to have a modification time.
RUN sh -c 'touch /app.jar'

EXPOSE 8080
# To reduce Tomcat startup time we added a system property pointing to "/dev/urandom" as a source of entropy.

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS $APP_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
