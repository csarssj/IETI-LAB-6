package edu.escuelaing.eci.ieti.services.impl;

import edu.escuelaing.eci.ieti.POJOS.User;
import edu.escuelaing.eci.ieti.repositories.UserRepository;
import edu.escuelaing.eci.ieti.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Set;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userR = null;

    public Set<User> getAll(){
        return userR.getAll();
    }
    public User getById(String userId){
        return userR.getById(userId);
    }
    public void create(User user){
        userR.create(user);
    }
    public void update(User user){
        userR.update(user);
    }
    public void remove(String userId){
        userR.remove(userId);
    }
}
