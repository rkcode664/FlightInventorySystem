package org.example.managers;

import java.util.ArrayList;
import java.util.List;
import org.example.entities.User;

public class UserManager {
    private List<User> users;
    public UserManager(){
        this.users=new ArrayList<>();
    }
    public User addUser(String userId,String name,double funds){
        User newUser = new User(userId,name,funds);
        users.add(newUser);
        return newUser;
    }
    public User getUser(String userId){
        return users.stream().filter(user -> user.getUserId().equals(userId)).findFirst().orElse(null);
    }
    public List<User> getAllUser(){
        return users;
    }

}
