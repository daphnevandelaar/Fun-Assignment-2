#https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html

FROM maven:3.6.0-jdk-11

#FROM maven-jdk8u181

# Install maven
#RUN apt-get -y update
#RUN apt-get install -y maven

#RUN	mkdir -p /root/.m2/repository
#COPY repository/ /root/.m2/repository/
MAINTAINER Daphne van de Laar (daphne.vandelaar@student.fontys.nl)

WORKDIR /code

# Prepare by downloading dependencies
ADD pom.xml /code/pom.xml
RUN ["mvn", "clean", "install"]
#RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
#ADD hello-world-0.1-SNAPSHOT-jar-with-dependencies.jar /code/hello-world-0.1-SNAPSHOT-jar-with-dependencies.jar
ADD src /code/src
RUN ["mvn", "package"]

EXPOSE 9001

CMD ["java", "-jar", "target/Backend-1.0-SNAPSHOT-jar-with-dependencies.jar"]