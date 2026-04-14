#!/bin/bash
set -e

echo "Starting deployment..."

echo "Stopping old containers..."
docker compose down || true

echo "Building and starting containers..."
docker compose up -d --build

echo "Waiting for app..."
sleep 15

echo "Checking health..."
bash scripts/health-check.sh