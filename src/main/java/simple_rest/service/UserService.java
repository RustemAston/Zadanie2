package simple_rest.service;

import simple_rest.entity.User;
import simple_rest.repository.ConnectionDB;
import java.util.List;

public class UserService {

    public List<User> findAll(){
        return ConnectionDB.findAll();
    }

    public User findById(int id) {
        return ConnectionDB.findById(id);
    }

    public void saveUser(User user) {
        ConnectionDB.saveUser(user);
    }

    public void updateUser(int userId, User user) {
        ConnectionDB.updateUser(userId, user);
    }

    public void deleteUser(int userId) {
        ConnectionDB.deleteUser(userId);
    }
}