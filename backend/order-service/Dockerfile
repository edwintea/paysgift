FROM openjdk:21-jdk-slim-buster

# Install curl
RUN apt-get update && apt-get install -y curl && apt-get clean && rm -rf /var/lib/apt/lists/*

# Expose the application port
EXPOSE 7004

# Set the working directory
WORKDIR /app

# Copy the .env file into the container
COPY .env .env

# Copy the WAR file into the container
COPY target/order-service-0.0.1.war app.war

# Command to run the application
CMD ["java", "-jar", "app.war"]
