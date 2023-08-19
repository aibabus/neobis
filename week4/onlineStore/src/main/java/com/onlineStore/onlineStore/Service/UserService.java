package com.onlineStore.onlineStore.Service;

import com.onlineStore.onlineStore.Entity.User;

import java.util.List;

public interface UserService {
    List<User> getUser();
    User saveUser (User user);
    User getSingleUser (int id);
    void deleteUser (int id);
    User updateUser (User user);
}
