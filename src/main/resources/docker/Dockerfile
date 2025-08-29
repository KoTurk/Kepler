# Generated with JReleaser 1.18.0 at 2025-08-28T23:23:10.787769+02:00
FROM azul/zulu-openjdk-alpine:21-jre

LABEL "org.opencontainers.image.title"="kepler"
LABEL "org.opencontainers.image.description"="Kepler demo application"
LABEL "org.opencontainers.image.url"="https://koturk.nl"
LABEL "org.opencontainers.image.licenses"="APACHE-2.0"
LABEL "org.opencontainers.image.version"="1.0.0-SNAPSHOT"
LABEL "org.opencontainers.image.revision"="9cfd6768c2dcc333ceb0417d47a139f39530c645"


COPY assembly/ /

RUN unzip kepler-1.0.0-SNAPSHOT.zip && \
    rm kepler-1.0.0-SNAPSHOT.zip && \
    chmod +x kepler-1.0.0-SNAPSHOT/bin/kepler


ENV PATH="${PATH}:/kepler-1.0.0-SNAPSHOT/bin"

ENTRYPOINT ["java", "-jar", "/kepler-1.0.0-SNAPSHOT/lib/kepler-1.0.0-SNAPSHOT.jar"]
