package com.onlineStore.onlineStore.Controller;

import com.onlineStore.onlineStore.Entity.Products;
import com.onlineStore.onlineStore.Entity.User;
import com.onlineStore.onlineStore.Repository.ProductsRepository;
import com.onlineStore.onlineStore.Repository.UserRepository;
import com.onlineStore.onlineStore.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/findUsers")
    public List<User> findAllUsers(){
        return userService.getUser();
    }

    @GetMapping("/findUser/{id}")
    public User findUser(@PathVariable int id){
        return userService.getSingleUser(id);
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user){
        user.setUser_id(id);
        return userService.updateUser(user);

    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@RequestParam int id){
        userService.deleteUser(id);

    }

}
