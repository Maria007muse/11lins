FROM eclipse-temurin:21-jdk-alpine as build

LABEL maintainer="Podzolko"
VOLUME /tmp

ARG JAR_FILE

COPY ${JAR_FILE} app.jar
EXPOSE 8080

RUN mkdir -p target/dependency && (cd target/dependency; jar -xf /app.jar)

FROM eclipse-temurin:21-jdk-alpine

VOLUME /tmp

ARG DEPENDENCY=/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","com.dolsoft.licenses.LicenseApplication"]
