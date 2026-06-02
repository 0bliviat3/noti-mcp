# Multi-Stage Docker Build for noti-mcp

# Stage 1: Build the application
FROM openjdk:21-jdk-slim AS builder

WORKDIR /app

# Copy Maven files
COPY pom.xml .
COPY src src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM openjdk:21-jre-slim

WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=builder /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Create a non-root user
RUN addgroup --system spring && \
    adduser --system --ingroup spring spring
USER spring:spring

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]