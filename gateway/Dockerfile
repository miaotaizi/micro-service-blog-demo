ARG SW_VERSION=latest
FROM apache/skywalking-base:${SW_VERSION}

# Use agent folder only

WORKDIR skywalking

RUN set -eux; \
    rm -rf "config"; \
    rm -rf "webapp"; rm -rf "oap-libs";

RUN set -eux; \
    cp ./agent/optional-plugins/apm-spring-cloud* ./agent/plugins

COPY ./target/gateway-1.0.jar /usr/app/
WORKDIR /usr/app

RUN sh -c 'touch gateway-1.0.jar'

ENTRYPOINT ["java", "-javaagent:/skywalking/agent/skywalking-agent.jar", "-jar", "gateway-1.0.jar"]
