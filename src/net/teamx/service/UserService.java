package net.teamx.service;

import net.teamx.bean.User;
import net.teamx.dao.UserDao;

import java.sql.SQLException;

public class UserService {
    public User login(String username, String password) throws SQLException {
        UserDao userDao=new UserDao();
        User user = userDao.login(username, password);
        return  user;
    }
}
