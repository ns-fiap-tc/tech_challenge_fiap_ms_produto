FROM eclipse-temurin:17.0.13_11-jre-noble

WORKDIR /service

COPY target/*.jar ./app.jar

ARG PROFILE=dev

ENV SPRING_PROFILES_ACTIVE=$PROFILE
ENV DB_NAME=lanch_prod_db
ENV DB_USER=lanch_prod_user
ENV DB_PASSWORD=lanch_prod@1234
ENV DB_HOST=dbprodserver
ENV DB_PORT=5432

CMD ["java", "-jar", "./app.jar"]
