# Use an OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy your JAR file into the container
COPY JobExpertSystem-0.0.1-SNAPSHOT.jar /app

# Expose the port the app will run on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "JobExpertSystem-0.0.1-SNAPSHOT.jar"]
