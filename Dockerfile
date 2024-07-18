FROM maven:3.9.8 AS build
LABEL authors="Maxim Galitskiy"

ARG profile=""

ENV HOME=/app
ENV JAVA_TOOL_OPTIONS="-Dspring.profiles.active=${profile}"

RUN mkdir -p $HOME

WORKDIR $HOME

COPY pom.xml $HOME

RUN ["mvn", "clean"]

RUN ["/usr/local/bin/mvn-entrypoint.sh", "mvn", "verify", "-P${profile}", "clean", "--fail-never"]

COPY . $HOME

RUN ["mvn", "package"]

FROM openjdk:21-slim
LABEL authors="Maxim Galitskiy"

ARG profile=""
ENV JAVA_TOOL_OPTIONS="-Dspring.profiles.active=${profile}"

WORKDIR /app
COPY --from=build /app/target/digital-chief-check-library.jar .

CMD ["java", "-jar", "digital-chief-check-library.jar"]
