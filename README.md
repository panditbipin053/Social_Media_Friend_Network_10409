# Social Media Friend Network

A console-based Social Media Friend Network application developed using **Java** and **Data Structures & Algorithms (DSA)**.

This project simulates a basic social networking platform where users can connect with each other, manage friendships, find mutual friends, explore friend suggestions, and analyze network connections using Graph algorithms.

## 🚀 Features

1. **Add New User** – Register a new user with ID, name, and bio.
2. **Add Friendship** – Establish a friendship between two users.
3. **Remove Friendship** – Remove an existing friendship.
4. **Display All Users** – View all registered users and their friend counts.
5. **Search User** – Search users using their unique ID.
6. **Display Friends** – View the friends of a particular user.
7. **BFS Traversal** – Explore the network using Breadth First Search.
8. **DFS Traversal** – Explore the network using Depth First Search.
9. **Mutual Friends** – Find common friends between two users.
10. **Shortest Connection Path** – Find the shortest friendship path between two users.
11. **Friend Suggestions** – Recommend new friends based on common connections.
12. **Remove User** – Delete a user and all associated friendships.
13. **Network Statistics** – Display total users, friendships, isolated users, and the most connected user.
14. **Reload Sample Data** – Restore the predefined sample network.

## 🛠️ Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework
- HashMap
- HashSet
- ArrayList
- Queue
- Graph Data Structure
- Breadth First Search (BFS)
- Depth First Search (DFS)

## 🧠 Data Structures & Algorithms

The project uses an **Undirected Graph** to represent the social media network.

- **HashMap:** Stores user information and graph connections.
- **HashSet:** Maintains unique friendships and visited users.
- **Queue:** Used in BFS traversal and shortest path calculation.
- **ArrayList:** Stores traversal results and user lists.
- **BFS:** Finds the shortest path in an unweighted graph.
- **DFS:** Explores connected users recursively.
- **Set Intersection:** Identifies mutual friends.

### Graph Representation

Each user represents a vertex (node), and each friendship represents an undirected edge.

Example:

```text
       Aarav
       /   \
     Riya  Kabir
       \   /
       Ananya
          |
        Meera
          |
        Ishaan
```

## 📂 Project Structure

```text
SocialMediaFriendNetwork/
│
├── SocialMediaFriendNetwork.java
├── README.md
└── .gitignore
```

## ⚙️ How to Run the Project

### Prerequisites

- Java JDK 8 or above
- VS Code / IntelliJ IDEA / Eclipse
- Terminal or Command Prompt

### Step 1: Clone the Repository

```bash
git clone YOUR_REPOSITORY_URL
```

### Step 2: Open the Project Folder

```bash
cd SocialMediaFriendNetwork
```

### Step 3: Compile the Java File

```bash
javac SocialMediaFriendNetwork.java
```

### Step 4: Run the Application

```bash
java SocialMediaFriendNetwork
```

## 📸 Application Menu

```text
==================================
   SOCIAL MEDIA FRIEND NETWORK
==================================

1. Add New User
2. Add Friendship
3. Remove Friendship
4. Display All Users
5. Search User
6. Display Friends
7. BFS Traversal
8. DFS Traversal
9. Find Mutual Friends
10. Shortest Connection Path
11. Friend Suggestions
12. Remove User
13. Network Statistics
14. Reload Sample Data
0. Exit

Enter your choice:
```

## 🎯 Learning Outcomes

Through this project, I explored:

- Practical implementation of Graph Data Structures.
- Understanding of BFS and DFS algorithms.
- Application of Java Collections Framework.
- Implementation of friendship management using an undirected graph.
- Finding shortest paths in an unweighted network.
- Applying Object-Oriented Programming concepts to a real-world problem.

## 🔮 Future Improvements

- Develop a graphical user interface (GUI).
- Add user authentication and login functionality.
- Implement database integration using MySQL.
- Add real-time messaging functionality.
- Develop an online social networking platform.

## 👨‍💻 Author

**Bipin Pandey**

B.Tech – Computer Science & Engineering

Rungta International Skills University

---

⭐ If you find this project interesting, feel free to explore the code and learn from it.

**Built with Java | Data Structures & Algorithms | Graph Theory**