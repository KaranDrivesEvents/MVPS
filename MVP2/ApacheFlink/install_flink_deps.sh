#!/bin/bash

# Set the Flink lib directory
FLINK_LIB_DIR="/Users/karandharmendrapatel/Desktop/MVPS/MVP2/ApacheFlink/flink-1.20.1/lib"
PROJECT_DIR="/Users/karandharmendrapatel/Desktop/MVPS/MVP2/ApacheFlink/my-flink-project"

# Function to install a JAR file
install_jar() {
    local jar_file=$1
    local artifact_id=$2
    
    echo "Installing $jar_file..."
    mvn install:install-file \
        -Dfile="$FLINK_LIB_DIR/$jar_file" \
        -DgroupId=org.apache.flink \
        -DartifactId="$artifact_id" \
        -Dversion=1.20.1 \
        -Dpackaging=jar
}

# Navigate to the lib directory
cd "$FLINK_LIB_DIR" || exit

# Install each Flink JAR file
install_jar "flink-dist-1.20.1.jar" "flink-dist"
install_jar "flink-table-api-java-uber-1.20.1.jar" "flink-table-api-java-uber"
install_jar "flink-scala_2.12-1.20.1.jar" "flink-scala_2.12"
install_jar "flink-table-planner-loader-1.20.1.jar" "flink-table-planner-loader"
install_jar "flink-csv-1.20.1.jar" "flink-csv"
install_jar "flink-json-1.20.1.jar" "flink-json"
install_jar "flink-connector-files-1.20.1.jar" "flink-connector-files"
install_jar "flink-table-runtime-1.20.1.jar" "flink-table-runtime"
install_jar "flink-cep-1.20.1.jar" "flink-cep"

# Navigate to project directory and build
cd "$PROJECT_DIR" || exit
echo "Building project..."
mvn clean install

echo "Flink dependencies installation completed!" 