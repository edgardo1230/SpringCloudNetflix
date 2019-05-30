FROM azul/zulu-openjdk:8
MAINTAINER Edgardo Cruz <edgardo.cruz@nearshoretechnology.com>, https://bitbucket.org/nsfocalpoint

VOLUME /tmp

ENV USER_NAME apisvc
ENV APP_HOME /opt/nearshore-cloud/$USER_NAME
RUN \
  useradd -ms /bin/bash $USER_NAME && \
  mkdir -p $APP_HOME

ADD api-gateway.jar ${APP_HOME}/api-gateway.jar
RUN \
  chown $USER_NAME $APP_HOME/api-gateway.jar && \
  bash -c 'touch ${APP_HOME}/api-gateway.jar'

ENV JAVA_TOOL_OPTIONS "-Xms256M -Xmx256M -Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom"

USER $USER_NAME
WORKDIR $APP_HOME
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]