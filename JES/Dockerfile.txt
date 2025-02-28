# Use an official Maven image to build the app
FROM maven:3.8-openjdk-11 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and the source code
COPY pom.xml .
COPY src ./src

# Build the application using Maven
RUN mvn clean install

# Use an OpenJDK runtime image to run the app
FROM openjdk:11-jre-slim

WORKDIR /app

# Copy the built jar file from the Maven build stage
COPY --from=build /app/target/JobExpertSystems.jar /app/JobExpertSystems.jar

# Expose the port that your application will run on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "JobExpertSystems.jar"]
