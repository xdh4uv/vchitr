# ===============================
# Build stage
# ===============================
FROM maven:3.9-eclipse-temurin-25 AS build
WORKDIR /app

# Copy pom.xml first for dependency caching
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source and build
COPY src ./src
RUN mvn clean package -DskipTests

# ===============================
# Runtime stage
# ===============================
FROM eclipse-temurin:25-jre-alpine
WORKDIR /app

# Copy the built JAR
COPY --from=build /app/target/*.jar app.jar

# Cloud Run / Spring Boot default
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
