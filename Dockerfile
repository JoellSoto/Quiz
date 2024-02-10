FROM maven:3.8.6-amazoncorretto-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -X -DskipTests

FROM openjdk:22
WORKDIR /app
COPY --from=build ./app/target/*.jar ./quiz-app.jar
ENTRYPOINT ["java","-jar","quiz-app.jar"]