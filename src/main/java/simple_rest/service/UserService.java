package simple_rest.service;

import simple_rest.entity.Many2ManyEntity;
import simple_rest.entity.One2ManyEntity;
import simple_rest.entity.User;
import simple_rest.repository.*;
import java.util.List;

public class UserService {

    public List<User> findAll(){
        return UserDAO.findAll();
    }

    public User findById(int id) {
        return UserDAO.findById(id);
    }

    public void saveUser(User user) {
        UserDAO.saveUser(user);
    }

    public void updateUser(int userId, User user) {
        UserDAO.updateUser(userId, user);
    }

    public void deleteUser(int userId) {
        UserDAO.deleteUser(userId);
    }

    public List<One2ManyEntity> getOne2Many() {
        return UserDAO.getOne2Many();
    }

    public List<Many2ManyEntity> getMany2Many() {
        return UserDAO.getMany2Many();
    }
}