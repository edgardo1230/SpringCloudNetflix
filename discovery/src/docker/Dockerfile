FROM azul/zulu-openjdk:8
MAINTAINER Edgardo Cruz <edgardo.cruz@nearshoretechnology.com>, https://bitbucket.org/nsfocalpoint

VOLUME /tmp

ENV USER_NAME discoverysvc
ENV APP_HOME /opt/nearshore-cloud/$USER_NAME
RUN \
  useradd -ms /bin/bash $USER_NAME && \
  mkdir -p $APP_HOME

ADD discovery-server.jar ${APP_HOME}/discovery-server.jar
RUN \
  chown $USER_NAME $APP_HOME/discovery-server.jar && \
  bash -c 'touch ${APP_HOME}/discovery-server.jar'

ENV JAVA_TOOL_OPTIONS "-Xms256M -Xmx256M -Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom"

USER $USER_NAME
WORKDIR $APP_HOME
ENTRYPOINT ["java", "-jar", "discovery-server.jar"]