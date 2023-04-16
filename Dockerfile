FROM tomcat:9.0.73-jdk11-corretto
COPY ./target/testcontainer-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/testcontainer.war
RUN cd /usr/local/tomcat/webapps/
RUN ls -lrt

