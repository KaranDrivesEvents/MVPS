#!/bin/bash

# Create base project folder
mkdir -p MVP1

# Create base files
touch MVP1/.gitignore
touch MVP1/README.md

# CSV to API Component
mkdir -p MVP1/csv-to-api/app
mkdir -p MVP1/csv-to-api/data

touch MVP1/csv-to-api/README.md
touch MVP1/csv-to-api/app/main.py
touch MVP1/csv-to-api/app/__init__.py
touch MVP1/csv-to-api/data/V6_doorloop_feedbacks_10k_supernatural.csv
touch MVP1/csv-to-api/Dockerfile
touch MVP1/csv-to-api/requirements.txt

# Kafka-Rudder Component
mkdir -p MVP1/kafka-rudder/app
mkdir -p MVP1/kafka-rudder/config
mkdir -p MVP1/kafka-rudder/tests

touch MVP1/kafka-rudder/README.md
touch MVP1/kafka-rudder/docker-compose.yml
touch MVP1/kafka-rudder/app/main.py
touch MVP1/kafka-rudder/app/__init__.py
touch MVP1/kafka-rudder/config/kafka_config.py
touch MVP1/kafka-rudder/config/rudder_config.py
touch MVP1/kafka-rudder/tests/test_main.py

echo "MVP1 folder structure created successfully."
