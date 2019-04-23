package dao;

import models.User;

import java.util.List;

public interface UserDao {
    public User get(int id);
    public void add(User user);
    public void update(User user);
    public List<User> findAll();
}
