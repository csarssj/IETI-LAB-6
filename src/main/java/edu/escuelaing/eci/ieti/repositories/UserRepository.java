package edu.escuelaing.eci.ieti.repositories;

import edu.escuelaing.eci.ieti.POJOS.User;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Component("UserRepository")
public class UserRepository {

    private HashMap userList = new HashMap<String, User>();

    public UserRepository(){
        User user1 = new User("user1@mail.com","user1","hola123");
        User user2 = new User("user2@mail.com","user2","hola123");
        userList.put("user1@mail.com",user1);
        userList.put("user2@mail.com",user2);
    }

    public Set<User> getAll(){
        Set<User> users = new HashSet<>(userList.values());
        return users;
    }
    public User getById(String userId){

        return (User) userList.get(userId);
    }
    public void create(User user){
        //User user_ = new User(user.getEmail(),user.getName(),user.getPass());
        userList.put(user.getEmail(),user);
    }
    public void update(User user){
        User user1 = (User) userList.get(user.getEmail());
        userList.remove(user.getEmail());
        userList.put(user1.getEmail(),user1);
    }
    public void remove(String userId){
        userList.remove(userId);
    }



}
