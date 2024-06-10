package simple_rest.repository;

import simple_rest.Util.ConnectionDB;
import simple_rest.entity.Many2ManyEntity;
import simple_rest.entity.One2ManyEntity;
import simple_rest.entity.User;
import simple_rest.exception.NoUserFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static simple_rest.Util.ConnectionDB.getConnection;

public class UserDAO {

    public static List<User> findAll() {
        List<User> list = new ArrayList<>();
        try (Statement statement = ConnectionDB.getConnection().createStatement()) {

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
        try (PreparedStatement preparedStatement =
                     getConnection().prepareStatement("SELECT * FROM users WHERE id=?")){
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
                    getConnection().prepareStatement("INSERT INTO users(nickname, age) VALUES(?,?)")){

            preparedStatement.setString(1, user.getNickname());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void updateUser(int userId, User user) {
        try(PreparedStatement preparedStatement =
                    getConnection().prepareStatement("UPDATE users SET nickname=?, age=? WHERE id=?")){

            preparedStatement.setString(1, user.getNickname());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setInt(3, userId);

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void deleteUser(int userId) {
        try(PreparedStatement preparedStatement = getConnection().prepareStatement("DELETE FROM users WHERE id=?")){

            preparedStatement.setInt(1, userId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<One2ManyEntity> getOne2Many() {
        List<One2ManyEntity> list = new ArrayList<>();
        try (Statement statement = getConnection().createStatement()) {

            ResultSet resultSet =
                    statement.executeQuery("SELECT * FROM users JOIN adverts ON users.id = adverts.user_id");

            while (resultSet.next()){
                One2ManyEntity one2ManyEntity = new One2ManyEntity();

                one2ManyEntity.setId(resultSet.getInt("id"));
                one2ManyEntity.setNickname(resultSet.getString("nickname"));
                one2ManyEntity.setAge(resultSet.getInt("age"));
                one2ManyEntity.setTitle(resultSet.getString("title"));
                one2ManyEntity.setUser_id(resultSet.getInt("user_id"));

                list.add(one2ManyEntity);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public static List<Many2ManyEntity> getMany2Many() {
        List<Many2ManyEntity> list = new ArrayList<>();
        try (Statement statement = getConnection().createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users JOIN user_society ON" +
                    " users.id=user_society.user_id\n JOIN societies ON user_society.society_id=societies.id;");

            while (resultSet.next()){
                Many2ManyEntity many2ManyEntity = new Many2ManyEntity();

                many2ManyEntity.setUser_id(resultSet.getInt("user_id"));
                many2ManyEntity.setNickname(resultSet.getString("nickname"));
                many2ManyEntity.setAge(resultSet.getInt("age"));
                many2ManyEntity.setSociety_id(resultSet.getInt("society_id"));
                many2ManyEntity.setHeading(resultSet.getString("heading"));

                list.add(many2ManyEntity);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

}