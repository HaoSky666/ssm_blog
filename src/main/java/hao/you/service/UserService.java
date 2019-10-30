package hao.you.service;

import hao.you.domain.User;

import java.util.List;

public interface UserService {
    public int addUser(User user);
    public int deleteUserById(int id);
    public int update(User user);
    public User getUserById(String id);
    public User getUserByName(String name);
    public List<User> getAllUser();
}
