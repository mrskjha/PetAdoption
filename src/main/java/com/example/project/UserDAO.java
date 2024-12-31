import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // Method to add a new user
    public void addUser(User user) {
        String query = "INSERT INTO Users (name, email, password_hash, phone_number, address, role) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DatabaseConnectionDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPasswordHash());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getRole());
            preparedStatement.executeUpdate();
            System.out.println("User added successfully.");
            
        } catch (SQLException e) {
            System.err.println("Error while adding user!");
            
        }
    }

    // Method to retrieve a user by email
    public User getUserByEmail(String email) {
        User user = null;
        String query = "SELECT * FROM Users WHERE email = ?";
        
        try (Connection connection = DatabaseConnectionDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                user = new User(
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("password_hash"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("address"),
                    resultSet.getString("role")
                );
                user.setUserId(resultSet.getInt("user_id"));
            }
            
        } catch (SQLException e) {
            System.err.println("Error while retrieving user!");
        
        }
        return user;
    }

    // Additional CRUD methods (update, delete) can be added here
}
