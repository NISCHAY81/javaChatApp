# ChatApp (Console-Based)

A simple console-based chat application built using Java.  
This project demonstrates basic networking concepts like **Server-Client communication** using **Sockets** and **multi-threading**.

## Features
- Real-time messaging between server and multiple clients
- Multi-threaded server to handle multiple clients simultaneously
- Simple and clean console interface
- Basic error handling and client disconnection management

## Technologies Used
- Java (Core Java)
- Java Sockets (TCP)
- Multithreading

## How It Works
1. Start the **Server** application — it listens for incoming client connections.
2. Start one or more **Client** applications — each client can send and receive messages from the server and other connected clients.
3. Messages sent by a client are broadcast to all other connected clients via the server.

## Folder Structure
```
/ChatApp
 ├── Server.java
 ├── Client.java
 └── README.md
```

## How to Run
1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/ChatApp.git
   cd ChatApp
   ```

2. **Compile the code**:
   ```bash
   javac Server.java
   javac Client.java
   ```

3. **Run the Server**:
   ```bash
   java Server
   ```

4. **Run the Clients** (in separate terminals):
   ```bash
   java Client
   ```

5. **Start chatting!**

## Requirements
- JDK 8 or higher
- Basic understanding of Java networking

## Future Improvements
- GUI interface using Java Swing or JavaFX
- Private messaging between clients
- User authentication (login/signup)
- Chat history logs

## Author
- [Nischay Kumar Swarnkar]

---

Would you also like me to generate a version that includes some badges (like "Java", "Networking", "Console App") for a more stylish GitHub look? 🚀
