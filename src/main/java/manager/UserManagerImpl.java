package manager;


import conf.DBConnectionProvider;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManagerImpl implements UserManager {

    private final Connection connection = DBConnectionProvider.getInstance().getConnection();

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            String query = "SELECT * FROM users";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("something wrong during work");
        }
        return users;
    }

    @Override
    public User getById(Integer id) {
        User user = new User();
        try {
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }

        } catch (SQLException e) {
            System.out.println("something wrong during work in method getById");
        }

        return null;
    }

    @Override
    public void create(User objet) {
        try {
            String query = "INSERT INTO users(name, lastname, age, email, password) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, objet.getName());
            preparedStatement.setString(2, objet.getLastName());
            preparedStatement.setInt(3, objet.getAge());
            preparedStatement.setString(4, objet.getEmail());
            preparedStatement.setString(5, objet.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("something wrong during work in method create");
        }
    }

    @Override
    public void update(User objet) {
        try {
            String query = "UPDATE users Set name = ?, lastname = ?, age = ?, email = ?, password = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, objet.getName());
            preparedStatement.setString(2, objet.getLastName());
            preparedStatement.setInt(3, objet.getAge());
            preparedStatement.setString(4, objet.getEmail());
            preparedStatement.setString(5, objet.getPassword());
            preparedStatement.setInt(6, objet.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("something wrong during work in method create");
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("something wrong during work in method delete");
        }
    }

    @Override
    public User getByEmailAndPassword(String username, String password) {

        User user = new User();
        try {
            String query = "SELECT * FROM users WHERE email = ? and password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }

        } catch (SQLException e) {
            System.out.println("something wrong during work in method getByEmailAndPassword");
        }

        return null;
    }
}
