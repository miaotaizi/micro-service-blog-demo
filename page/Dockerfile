ARG SW_VERSION=latest
FROM apache/skywalking-base:${SW_VERSION}

# Use agent folder only

WORKDIR skywalking

RUN set -eux; \
    rm -rf "config"; \
    rm -rf "webapp"; rm -rf "oap-libs";

COPY ./target/page-1.0.jar /usr/app/
WORKDIR /usr/app

RUN sh -c 'touch page-1.0.jar'

ENTRYPOINT ["java", "-javaagent:/skywalking/agent/skywalking-agent.jar", "-jar", "page-1.0.jar"]
