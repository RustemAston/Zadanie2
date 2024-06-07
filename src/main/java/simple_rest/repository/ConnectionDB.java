package simple_rest.repository;

import simple_rest.Util.propertiesFile;
import simple_rest.entity.User;
import simple_rest.exception.NoUserFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionDB {
    private static final String DRIVER = "driver-class-name";
    private static final String URL = "url";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static Connection connection;

    static {
        try {
            Class.forName(propertiesFile.getProperties(DRIVER));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{
            connection = DriverManager.getConnection(propertiesFile.getProperties(URL),
                                                    propertiesFile.getProperties(USERNAME),
                                                    propertiesFile.getProperties(PASSWORD));
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    public static List<User> findAll() {
        List<User> list = new ArrayList<>();
            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

                while (resultSet.next()){
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setNickname(resultSet.getString("nickname"));
                    user.setAge(resultSet.getInt("age"));
                    list.add(user);
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        return list;
    }

    public static User findById(int userId) {
        User possibleUser = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id=?")) {
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next() == false)                          // checking whether user is not found at all
                throw new NoUserFoundException("No user is found in database");
            else{
                do{
                    possibleUser.setId(resultSet.getInt("id"));
                    possibleUser.setNickname(resultSet.getString("nickname"));
                    possibleUser.setAge(resultSet.getInt("age"));
                } while(resultSet.next());
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return possibleUser;
    }

    public static void saveUser(User user) {
        try(PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO users(nickname, age) VALUES(?,?)")){

            preparedStatement.setString(1, user.getNickname());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void updateUser(int userId, User user) {
        try(PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE users SET nickname=?, age=? WHERE id=?")){

            preparedStatement.setString(1, user.getNickname());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setInt(3, userId);

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void deleteUser(int userId) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id=?")){

            preparedStatement.setInt(1, userId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}