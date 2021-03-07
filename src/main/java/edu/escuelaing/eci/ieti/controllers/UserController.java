package edu.escuelaing.eci.ieti.controllers;

import edu.escuelaing.eci.ieti.POJOS.User;
import edu.escuelaing.eci.ieti.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
public class UserController {
    @Autowired
    UserService userS = null;

    @RequestMapping(value="/user" ,method = RequestMethod.GET)
    public ResponseEntity<?> getUsers() {
        Set<User> users = null;
        try {
            users = userS.getAll();
            for(User u : users){
                System.out.print(u.toString());
            }
            return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return null;
        }
    }
    @RequestMapping(value="/user/{email}" ,method = RequestMethod.GET)
    public ResponseEntity<?> getUsers(@PathVariable String email) {
        User userr = null;
        try {
            userr = userS.getById(email);
            return new ResponseEntity<>(userr, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return null;
        }
    }
    @RequestMapping(value="/" ,method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        try {
            userS.create(user);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(Exception ex) {
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value="/user/{email}" ,method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable String email,  @RequestBody User user) {
        try {
            userS.update(user);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(Exception ex) {
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
    }
}
