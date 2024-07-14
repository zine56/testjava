# Stage 1: Build the application
FROM gradle:7.3.3-jdk11 as builder

WORKDIR /home/gradle/project

COPY gradlew .
COPY gradle/ gradle/
COPY build.gradle .
COPY settings.gradle .
COPY src/ src/
COPY db/ db/

# Ensure the wrapper uses the correct version of Gradle
RUN ./gradlew wrapper --gradle-version 7.3.3 --distribution-type bin

# Run the Gradle build
RUN chmod +x gradlew
RUN ./gradlew build -x test --no-daemon

# Stage 2: Create the runtime image
FROM openjdk:11

COPY --from=builder /home/gradle/project/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
