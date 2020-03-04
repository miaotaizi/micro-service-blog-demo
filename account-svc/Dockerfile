FROM apache/skywalking-base:6.4.0

# Use agent folder only

WORKDIR skywalking

RUN set -eux; \
    rm -rf "config"; \
    rm -rf "webapp"; rm -rf "oap-libs";

COPY ./target/account-svc-1.0.jar /usr/app/
WORKDIR /usr/app

RUN sh -c 'touch account-svc-1.0.jar'

ENTRYPOINT ["java", "-javaagent:/skywalking/agent/skywalking-agent.jar", "-jar", "account-svc-1.0.jar"]
