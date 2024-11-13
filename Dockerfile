FROM maven:3.9.6-amazoncorretto-21-debian as build

WORKDIR /app
COPY ./pom.xml .
COPY ./src ./src

RUN mvn clean package -e

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/app.jar .

CMD ["java", "-jar", "app.jar"]
