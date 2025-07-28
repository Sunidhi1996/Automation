#!/bin/bash

# Verify that the JAR file exists
if [ ! -f ./target/mobile-test-automation-framework-1.0-SNAPSHOT.jar ]; then
    echo "JAR file not found. Building the project..."
    mvn clean package -DskipTests
fi

# Check if the build was successful
if [ ! -f ./target/mobile-test-automation-framework-1.0-SNAPSHOT.jar ]; then
    echo "Failed to build the project. Please check the logs."
    exit 1
fi

echo "JAR file found. Project built successfully."
echo "To run tests, use: mvn test"
echo "To run tests with specific profile, use: mvn test -P<profile_name>"
echo "Available profiles: android, ios, smoke, regression"
