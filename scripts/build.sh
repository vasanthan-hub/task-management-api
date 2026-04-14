#!/bin/bash
set -e

echo "Starting build..."

mvn clean package -DskipTests

echo "Checking build output..."
if ! ls target/*.jar 1> /dev/null 2>&1; then
  echo "Build failed: JAR not found "
  exit 1
fi

echo "Build successful "