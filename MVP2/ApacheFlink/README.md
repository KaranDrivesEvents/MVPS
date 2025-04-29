# This project was created with a purpose of writing sample Flink application. 

Below instructions will help you 
- Start a Flink Cluster. 
- Run existing stream application. 

Running this locally won’t be a smooth ride. Thank you for taking the time to try out the monolithic setup :D.  We’ll be migrating to a managed service soon and setting up a universal development environment to make collaboration seamless. 

## 1. Prerequisites
- Java 8 or 11 installed
- Apache Flink (tested with version 1.20.1)
- Maven

> **Note:** If your Flink version is not compatible with your local device, please Email Karan: buildeventdriven@gmail.com 

---

## 2. Start a Standalone Flink Cluster
Navigate to your Flink installation directory (e.g., `flink-1.20.1`):
```sh
cd /Users/karandharmendrapatel/Desktop/MVPS/MVP2/ApacheFlink/flink-1.20.1
./bin/start-cluster.sh
```
This will start both the JobManager and a TaskManager locally.

---

## 3. Directory Structure
All commands below assume you are in the project root:
```
/Users/karandharmendrapatel/Desktop/MVPS/MVP2/ApacheFlink/my-flink-project
```

---

## 4. Build the Project
Navigate to the project directory and run:
```sh
cd /Users/karandharmendrapatel/Desktop/MVPS/MVP2/ApacheFlink/my-flink-project
mvn clean package
```
This will generate a JAR file in the `target/` directory.

---

## 5. Start the Socket Data Source (Netcat)
In a new terminal, run netcat to provide data to the Flink job:
```sh
nc -l -p 9000 -v
```

---

## 6. Run the Flink Streaming Application
From the project directory, submit the job:
```sh
cd /Users/karandharmendrapatel/Desktop/MVPS/MVP2/ApacheFlink/my-flink-project
flink run -c com.pluralsight.streaming.HighSpeedDetection target/my-flink-project-1.0.jar
```
- `-c com.pluralsight.streaming.HighSpeedDetection` specifies the main class.
- The JAR path may differ if you change the version.

---

## 7. Post Data from Netcat Terminal
Type lines like:
```
toyota,30
mercedes,80
toyota,90
```
These will be sent to the Flink job for processing.

---

## 8. Access the Flink Web UI
Open your browser and go to:
```
http://localhost:8081
```
Here you can monitor jobs, check logs, and view cluster status.

---

## 9. Where to Check the Output
- The output from the job (filtered high-speed cars) will appear as **stdout in the TaskManager logs**.
- To view the output:
  1. Go to the Flink Web UI: [http://localhost:8081](http://localhost:8081)
  2. Click on the running job, then on the TaskManager, and view the **stdout** or **logs** tab.
  3. Alternatively, tail the log file directly from the Flink installation's `log/` directory:
     ```sh
     tail -f /Users/karandharmendrapatel/Desktop/MVPS/MVP2/ApacheFlink/flink-1.20.1/log/flink-*-taskexecutor-*.log
     ```

---

## 10. Stopping the Cluster
To stop the Flink cluster, run:
```sh
cd /Users/karandharmendrapatel/Desktop/MVPS/MVP2/ApacheFlink/flink-1.20.1
./bin/stop-cluster.sh
```

---

## 11. Troubleshooting
- **No Output:** Ensure netcat is running and you are sending data in the correct format.
- **Connection Refused:** Start netcat before submitting the Flink job.
- **Incompatible Flink Version:** Contact Karan for help setting up a compatible Flink environment.

---

## 12. Contact
For Flink setup issues or compatibility help, please Email **Karan**: buildeventdriven@gmail.com