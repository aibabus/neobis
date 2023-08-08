package com.ApiRest.ApiRest.service;

import com.ApiRest.ApiRest.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> userList;

    public UserService(List<User> userList) {
        this.userList = new ArrayList<>();
        User user1 = new User(1, "Ida", 32, "ida@gmail.com");
        User user2 = new User(2, "Aiba", 18, "aibek003@gmail.com");
        User user3 = new User(3, "Saiba", 20, "saiba0123@gmail.com");
        User user4 = new User(4, "Nurik", 19, "shnurick@gmail.com");
        User user5 = new User(5, "Beks", 45, "bekskeks@gmail.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));
    }

    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();
        for(User user: userList){
            if(id == user.getId()){
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}
