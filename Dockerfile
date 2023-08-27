FROM openjdk:11
#VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]





###### ONLY FOR LEARNING PURPOSE #######
#FROM ubuntu
#CMD ["echo", "Hello StackOverflows!"]
#ENTRYPOINT ["tail", "-f", "/dev/null"]
## THis is the working directory
#WORKDIR my-app
#
## THis will copy the files from logs to my-app. So the result is file is copied to my-app with hero.log content
#COPY logs/spring-boot-logger.log hero.log
#RUN apt-get -y update
#
## This will install net-tools . Try ifconfig in the docker terminal. You can run it bcoz u installed net-tools.
#RUN apt-get install net-tools


