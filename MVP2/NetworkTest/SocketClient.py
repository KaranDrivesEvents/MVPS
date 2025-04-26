import socket
import sys

try:
    # Create a socket object
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    
    # Connect to the server on localhost:9002
    client_socket.connect(('localhost', 9000))
    
    # Print a message to indicate connection
    print("Connected to server. Listening for data...")
    
    # Receive data in a loop
    while True:
        try:
            # Receive data from the server (buffer size of 1024 bytes)
            data = client_socket.recv(1024)
            
            # If no data is received, the connection is closed
            if not data:
                print("Connection closed by server")
                break
                
            # Decode and print the received data
            print(f"Received: {data.decode('utf-8')}")
            
        except socket.error as e:
            print(f"Error receiving data: {e}")
            break
            
except socket.error as e:
    print(f"Connection error: {e}")
    sys.exit(1)
    
finally:
    # Always close the socket
    print("Closing connection...")
    client_socket.close()
