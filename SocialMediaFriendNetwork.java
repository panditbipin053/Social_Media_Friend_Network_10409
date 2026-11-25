import java.util.*;

public class SocialMediaFriendNetwork {

    private static Scanner sc = new Scanner(System.in);

    private Map<String, User> users = new HashMap<>();
    private Map<String, Set<String>> graph = new HashMap<>();

    // User Class
    static class User {
        String id;
        String name;
        String bio;

        User(String id, String name, String bio) {
            this.id = id;
            this.name = name;
            this.bio = bio;
        }
    }

    // Main Method
    public static void main(String[] args) {

        SocialMediaFriendNetwork app =
                new SocialMediaFriendNetwork();

        app.loadSampleData();
        app.run();
    }

    // Main Menu
    private void run() {

        boolean running = true;

        System.out.println("\n==================================");
        System.out.println("   SOCIAL MEDIA FRIEND NETWORK");
        System.out.println("==================================");

        while (running) {

            System.out.println("\n1. Add New User");
            System.out.println("2. Add Friendship");
            System.out.println("3. Remove Friendship");
            System.out.println("4. Display All Users");
            System.out.println("5. Search User");
            System.out.println("6. Display Friends");
            System.out.println("7. BFS Traversal");
            System.out.println("8. DFS Traversal");
            System.out.println("9. Find Mutual Friends");
            System.out.println("10. Shortest Connection Path");
            System.out.println("11. Friend Suggestions");
            System.out.println("12. Remove User");
            System.out.println("13. Network Statistics");
            System.out.println("14. Reload Sample Data");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input!");
                continue;
            }

            switch (choice) {

                case 1:
                    addUserInput();
                    break;

                case 2:
                    addFriendInput();
                    break;

                case 3:
                    removeFriendInput();
                    break;

                case 4:
                    displayUsers();
                    break;

                case 5:
                    searchUserInput();
                    break;

                case 6:
                    displayFriendsInput();
                    break;

                case 7:
                    bfsInput();
                    break;

                case 8:
                    dfsInput();
                    break;

                case 9:
                    mutualFriendsInput();
                    break;

                case 10:
                    shortestPathInput();
                    break;

                case 11:
                    suggestFriendsInput();
                    break;

                case 12:
                    removeUserInput();
                    break;

                case 13:
                    networkStatistics();
                    break;

                case 14:
                    loadSampleData();
                    break;

                case 0:
                    running = false;
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Add User
    private boolean addUser(String id, String name, String bio) {

        id = id.trim().toUpperCase();

        if (id.isEmpty() || name.trim().isEmpty()
                || users.containsKey(id)) {
            return false;
        }

        users.put(id, new User(id, name.trim(), bio));
        graph.put(id, new HashSet<>());

        return true;
    }

    private void addUserInput() {

        System.out.print("Enter User ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Bio: ");
        String bio = sc.nextLine();

        if (addUser(id, name, bio)) {
            System.out.println("User added successfully!");
        } else {
            System.out.println("User already exists or invalid input!");
        }
    }

    // Add Friendship
    private boolean addFriendship(String id1, String id2) {

        id1 = id1.trim().toUpperCase();
        id2 = id2.trim().toUpperCase();

        if (id1.equals(id2)
                || !users.containsKey(id1)
                || !users.containsKey(id2)
                || graph.get(id1).contains(id2)) {
            return false;
        }

        graph.get(id1).add(id2);
        graph.get(id2).add(id1);

        return true;
    }

    private void addFriendInput() {

        System.out.print("Enter First User ID: ");
        String id1 = sc.nextLine();

        System.out.print("Enter Second User ID: ");
        String id2 = sc.nextLine();

        if (addFriendship(id1, id2)) {
            System.out.println("Friendship added successfully!");
        } else {
            System.out.println("Unable to add friendship!");
        }
    }

    // Remove Friendship
    private void removeFriendInput() {

        System.out.print("Enter First User ID: ");
        String id1 = sc.nextLine().trim().toUpperCase();

        System.out.print("Enter Second User ID: ");
        String id2 = sc.nextLine().trim().toUpperCase();

        if (!users.containsKey(id1) || !users.containsKey(id2)) {
            System.out.println("User not found!");
            return;
        }

        if (graph.get(id1).remove(id2)) {
            graph.get(id2).remove(id1);
            System.out.println("Friendship removed successfully!");
        } else {
            System.out.println("Friendship does not exist!");
        }
    }

    // Display All Users
    private void displayUsers() {

        System.out.println("\n========== ALL USERS ==========");

        if (users.isEmpty()) {
            System.out.println("No users available!");
            return;
        }

        List<String> ids = new ArrayList<>(users.keySet());

        Collections.sort(ids);

        for (String id : ids) {

            User user = users.get(id);

            System.out.println(
                    "ID: " + user.id
                    + " | Name: " + user.name
                    + " | Friends: " + graph.get(id).size()
            );
        }
    }

    // Search User
    private void searchUserInput() {

        System.out.print("Enter User ID: ");

        String id = sc.nextLine().trim().toUpperCase();

        User user = users.get(id);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.println("\nUser Details");
        System.out.println("ID: " + user.id);
        System.out.println("Name: " + user.name);
        System.out.println("Bio: " + user.bio);
        System.out.println("Friends: " + graph.get(id).size());
    }

    // Display Friends
    private void displayFriendsInput() {

        System.out.print("Enter User ID: ");

        String id = sc.nextLine().trim().toUpperCase();

        if (!users.containsKey(id)) {
            System.out.println("User not found!");
            return;
        }

        System.out.println("\nFriends of " + users.get(id).name);

        List<String> friends = new ArrayList<>(graph.get(id));

        Collections.sort(friends);

        if (friends.isEmpty()) {
            System.out.println("No friends available!");
            return;
        }

        for (String friend : friends) {
            System.out.println(users.get(friend).name
                    + " (" + friend + ")");
        }
    }

    // Breadth First Search
    private List<String> bfs(String start) {

        start = start.trim().toUpperCase();

        if (!users.containsKey(start)) {
            return null;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {

            String current = queue.poll();

            result.add(current);

            List<String> friends =
                    new ArrayList<>(graph.get(current));

            Collections.sort(friends);

            for (String friend : friends) {

                if (!visited.contains(friend)) {

                    visited.add(friend);
                    queue.offer(friend);
                }
            }
        }

        return result;
    }

    private void bfsInput() {

        System.out.print("Enter Starting User ID: ");

        String start = sc.nextLine();

        List<String> result = bfs(start);

        if (result == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.println("\nBFS Traversal:");

        for (String id : result) {
            System.out.print(users.get(id).name + " -> ");
        }

        System.out.println("END");
    }

    // Depth First Search
    private List<String> dfs(String start) {

        start = start.trim().toUpperCase();

        if (!users.containsKey(start)) {
            return null;
        }

        List<String> result = new ArrayList<>();

        Set<String> visited = new HashSet<>();

        dfsRecursive(start, visited, result);

        return result;
    }

    private void dfsRecursive(
            String current,
            Set<String> visited,
            List<String> result) {

        visited.add(current);

        result.add(current);

        List<String> friends =
                new ArrayList<>(graph.get(current));

        Collections.sort(friends);

        for (String friend : friends) {

            if (!visited.contains(friend)) {

                dfsRecursive(friend, visited, result);
            }
        }
    }

    private void dfsInput() {

        System.out.print("Enter Starting User ID: ");

        String start = sc.nextLine();

        List<String> result = dfs(start);

        if (result == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.println("\nDFS Traversal:");

        for (String id : result) {
            System.out.print(users.get(id).name + " -> ");
        }

        System.out.println("END");
    }

    // Mutual Friends
    private void mutualFriendsInput() {

        System.out.print("Enter First User ID: ");

        String id1 = sc.nextLine().trim().toUpperCase();

        System.out.print("Enter Second User ID: ");

        String id2 = sc.nextLine().trim().toUpperCase();

        if (!users.containsKey(id1) || !users.containsKey(id2)) {
            System.out.println("User not found!");
            return;
        }

        Set<String> mutual =
                new HashSet<>(graph.get(id1));

        mutual.retainAll(graph.get(id2));

        System.out.println("\nMutual Friends:");

        if (mutual.isEmpty()) {
            System.out.println("No mutual friends found!");
            return;
        }

        for (String id : mutual) {
            System.out.println(users.get(id).name);
        }
    }

    // Shortest Connection Path
    private List<String> shortestPath(String source, String destination) {

        source = source.trim().toUpperCase();
        destination = destination.trim().toUpperCase();

        if (!users.containsKey(source)
                || !users.containsKey(destination)) {
            return null;
        }

        Queue<String> queue = new LinkedList<>();

        Set<String> visited = new HashSet<>();

        Map<String, String> parent = new HashMap<>();

        queue.offer(source);

        visited.add(source);

        parent.put(source, null);

        while (!queue.isEmpty()) {

            String current = queue.poll();

            if (current.equals(destination)) {
                break;
            }

            for (String friend : graph.get(current)) {

                if (!visited.contains(friend)) {

                    visited.add(friend);

                    parent.put(friend, current);

                    queue.offer(friend);
                }
            }
        }

        if (!visited.contains(destination)) {
            return null;
        }

        List<String> path = new ArrayList<>();

        String current = destination;

        while (current != null) {

            path.add(current);

            current = parent.get(current);
        }

        Collections.reverse(path);

        return path;
    }

    private void shortestPathInput() {

        System.out.print("Enter Source User ID: ");
        String source = sc.nextLine();

        System.out.print("Enter Destination User ID: ");
        String destination = sc.nextLine();

        List<String> path = shortestPath(source, destination);

        if (path == null) {
            System.out.println("No connection path found!");
            return;
        }

        System.out.println("\nShortest Connection Path:");

        for (String id : path) {
            System.out.print(users.get(id).name + " -> ");
        }

        System.out.println("END");

        System.out.println(
                "Connection Distance: " + (path.size() - 1)
        );
    }

    // Friend Suggestions
    private void suggestFriendsInput() {

        System.out.print("Enter User ID: ");

        String id = sc.nextLine().trim().toUpperCase();

        if (!users.containsKey(id)) {
            System.out.println("User not found!");
            return;
        }

        Map<String, Integer> suggestions = new HashMap<>();

        Set<String> directFriends = graph.get(id);

        for (String friend : directFriends) {

            for (String candidate : graph.get(friend)) {

                if (!candidate.equals(id)
                        && !directFriends.contains(candidate)) {

                    suggestions.put(
                            candidate,
                            suggestions.getOrDefault(candidate, 0) + 1
                    );
                }
            }
        }

        if (suggestions.isEmpty()) {
            System.out.println("No suggestions available!");
            return;
        }

        List<String> candidates =
                new ArrayList<>(suggestions.keySet());

        candidates.sort((a, b) ->
                suggestions.get(b) - suggestions.get(a)
        );

        System.out.println("\nFriend Suggestions:");

        for (String candidate : candidates) {

            System.out.println(
                    users.get(candidate).name
                    + " | Common Friends: "
                    + suggestions.get(candidate)
            );
        }
    }

    // Remove User
    private void removeUserInput() {

        System.out.print("Enter User ID to Remove: ");

        String id = sc.nextLine().trim().toUpperCase();

        if (!users.containsKey(id)) {
            System.out.println("User not found!");
            return;
        }

        for (String friend : new HashSet<>(graph.get(id))) {

            graph.get(friend).remove(id);
        }

        graph.remove(id);

        users.remove(id);

        System.out.println("User removed successfully!");
    }

    // Network Statistics
    private void networkStatistics() {

        int totalConnections = 0;

        int isolatedUsers = 0;

        int maxFriends = 0;

        String popularUser = "None";

        for (String id : users.keySet()) {

            int count = graph.get(id).size();

            totalConnections += count;

            if (count == 0) {
                isolatedUsers++;
            }

            if (count > maxFriends) {

                maxFriends = count;

                popularUser = users.get(id).name;
            }
        }

        System.out.println("\n========== NETWORK STATISTICS ==========");

        System.out.println("Total Users: " + users.size());

        System.out.println(
                "Total Friendships: " + totalConnections / 2
        );

        System.out.println(
                "Users Without Friends: " + isolatedUsers
        );

        System.out.println(
                "Maximum Friends: " + maxFriends
        );

        System.out.println(
                "Most Connected User: " + popularUser
        );
    }

    // Sample Data
    private void loadSampleData() {

        users.clear();

        graph.clear();

        addUser("U101", "Aarav", "Technology Lover");

        addUser("U102", "Riya", "Music Lover");

        addUser("U103", "Kabir", "Computer Science Student");

        addUser("U104", "Ananya", "Travel Enthusiast");

        addUser("U105", "Vihaan", "Sports Lover");

        addUser("U106", "Meera", "Design Enthusiast");

        addUser("U107", "Ishaan", "Java Developer");

        addFriendship("U101", "U102");

        addFriendship("U101", "U103");

        addFriendship("U102", "U104");

        addFriendship("U103", "U104");

        addFriendship("U103", "U105");

        addFriendship("U104", "U106");

        addFriendship("U105", "U106");

        addFriendship("U106", "U107");

        System.out.println("\nSample Data Loaded Successfully!");
    }
}