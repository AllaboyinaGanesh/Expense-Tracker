package service;

import dao.UserDAO;
import model.User;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public boolean registerUser(User user) {
        if (userDAO.getUser(user.getUsername()) == null) {
            return userDAO.insertUser(user);
        }
        return false; // User already exists
    }

    public User loginUser(String username, String password) {
        User user = userDAO.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public boolean deleteUser(String username) {
        return userDAO.deleteUser(username);
    }
}
