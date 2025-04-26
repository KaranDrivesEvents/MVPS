# Network Test: Netcat & Python Socket Client

## Overview
This project demonstrates simple socket-based communication between a netcat server and a Python client. You can use this setup to send and receive messages for testing or educational purposes.

---

## 1. Using Netcat as a Server

Netcat (`nc`) is a versatile networking tool that can listen for incoming TCP connections and display received data.

### Start Netcat Server
Run the following command in your terminal:

```sh
nc -l -p 9000 -v
```
- `-l`: Listen mode (acts as a server)
- `-p 9000`: Listen on port 9000
- `-v`: Verbose output (shows connection info)

When a client connects, you'll see a message like:
```
Connection from 127.0.0.1:XXXXX
```
You can then type messages in the netcat terminal to send to the client, or see messages sent from the client.

---

## 2. Python Socket Client

The Python client script connects to the netcat server and prints any data received.

### Usage
1. Make sure netcat is running as described above.
2. In another terminal, run the client script:

```sh
python3 SocketClient.py
```

### What the Client Does
- Connects to `localhost` on port `9000`
- Prints any data received from the server
- Handles connection errors and closes the socket cleanly

---

## 3. Troubleshooting
- **Connection Refused**: Make sure netcat is running and listening on the correct port before starting the client.
- **No Output**: Ensure you are sending data from the netcat terminal, or that the client is running and connected.
- **Port in Use**: If you get an error about the port being in use, try a different port (e.g., 9001) in both the netcat and client script.

---

## 4. Example Workflow
1. Start netcat:
   ```sh
   nc -l -p 9000 -v
   ```
2. Start the Python client:
   ```sh
   python3 SocketClient.py
   ```
3. Type messages in the netcat terminal and see them appear in the client terminal.

---

## 5. Customization
- You can change the port by editing the port number in both the netcat command and the client script.
- You can extend the client script to process or respond to messages as needed.

---

## 6. References
- [Netcat Manual](https://www.unix.com/man-page/osx/1/nc/)
- [Python socket documentation](https://docs.python.org/3/library/socket.html) 