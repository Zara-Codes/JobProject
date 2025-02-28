# Use an OpenJDK image as the base image (Java 11 in this example)
FROM openjdk:11-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the root of your repository to the container
# If your .jar file is directly in the root directory of your repository, change the path accordingly
COPY JobExpertSystem-0.0.1-SNAPSHOT.jar /app/JobExpertSystem.jar

# Expose the port your application will run on (usually 8080 for Spring Boot)
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "/app/JobExpertSystem.jar"]
