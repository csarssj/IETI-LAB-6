package edu.escuelaing.eci.ieti.services;

import edu.escuelaing.eci.ieti.POJOS.User;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {
    Set<User> getAll();

    User getById(String userId);

    void create(User user);

    void update(User user);

    void remove(String userId);
}