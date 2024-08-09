FROM jenkins/jenkins:lts

USER root

# Install Maven
RUN apt-get update && apt-get install -y maven

USER jenkins
