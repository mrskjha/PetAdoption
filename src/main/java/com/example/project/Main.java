public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // Create a new user
        User newUser = new User("John Doe", "john@example.com", "hashed_password", "1234567890", "123 Street, City", "user");
        userDAO.addUser(newUser);

        // Retrieve user by email
        User retrievedUser = userDAO.getUserByEmail("john@example.com");
        if (retrievedUser != null) {
            System.out.println("Retrieved User: " + retrievedUser.getName());
        } else {
            System.out.println("User not found.");
        }

        // Close connections handled by DAO class
    }
}
