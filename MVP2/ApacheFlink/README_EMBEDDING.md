
- We'll be adding creating an embedding pipeline under the same repo, yet another (a new) project. 
- This will be listening from Kafka broker instead of local-test-server (netcat). 
- Flink will perform necessary transformations (chunkfy/tokenize) before sending it out for embedding generation. 
- Then Flink will write the received embeddings to the Vector Database. 
- This will be an MVP pipeline. We'll create a prod version of it which will consist of dynamic code that can be utilized across multiple use-cases. 

# Create a shell-script for project creation. This one will need Kafka-part to be added. Rudderstack in nspecific. Or may be we can start decoupling form now on. We are not going to use no local anyway. 

mvn archetype:generate \
-DarchetypeGroupId=org.apache.flink \
-DarchetypeArtifactId=flink-quickstart-java \
-DarchetypeVersion=1.20.1 \
-DgroupId=my-flink-project \
-DartifactId=realtime-embedding-mvp \
-Dversion=1.0 \
-Dpackage=com.embedding.inference \
-DinteractiveMode=false


# Keep copnsistency 
Prepare Documentation for each save-point. 
Operator ID <> Operator UID
Make reusable operators-packages.  



