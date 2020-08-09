package lk.ijse.student_management.dao.custom.impl;

import lk.ijse.student_management.dao.CrudUtil;
import lk.ijse.student_management.dao.custom.UserDAO;
import lk.ijse.student_management.entity.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FORM User");
        List<User>users = new ArrayList<>();
        while (resultSet.next()){
            users.add(new User(resultSet.getString(1),resultSet.getString(2)));
        }
        return users;
    }

    @Override
    public User find(String key) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM User WHERE username = ?",key);
        if(resultSet.next()){
            return new User(resultSet.getString(1),resultSet.getString(2));
        }
        return null;
    }

    @Override
    public boolean save(User entity) throws Exception {
        return CrudUtil.execute("INSERT INTO User VALUES(?,?)",entity.getUsername(),entity.getPassword());
    }

    @Override
    public boolean update(User entity) throws Exception {
        return CrudUtil.execute("UPDATE User SET password = ? WHERE username = ?",entity.getPassword(),entity.getUsername());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM User WHERE username = ?",key);
    }

    @Override
    public boolean login(User user) throws Exception {
        return CrudUtil.execute("SELECT * FROM User WHERE username = ? AND password = ?",user.getUsername(),user.getUsername());
    }
}
