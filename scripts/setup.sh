#!/bin/bash
echo "Updating & upgrading"
sudo apt update -y
sudo apt upgrade -y
echo "Downloading java"
 sudo apt install openjdk-17-jdk -y
 echo "Installing Docker"
 sudo apt install docker.io -y
 echo "Starting Docker"
 sudo systemctl start docker
 echo "Enabling Docker"
 sudo systemctl enable docker
 echo "Adding user to Docker group"
 sudo usermod -aG docker $USER
 sudo apt install docker-compose -y
 