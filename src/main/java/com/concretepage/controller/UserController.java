package com.concretepage.controller;

import java.util.List;

import com.concretepage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.mindrot.jbcrypt.*;
import com.concretepage.service.IUserService;

@CrossOrigin(origins = "http://localhost:8090", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAllUsers();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }

    @PostMapping("user")
    public ResponseEntity<User> addUser(@RequestBody User user, UriComponentsBuilder builder) {
        user.setUserGroupId(3);

        boolean flag = userService.addUser(user);
        if (flag == false) {
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @PutMapping("user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("user/{email}/{password}")
    public ResponseEntity<User> loginUser( @PathVariable("email") String email, @PathVariable("password") String password){
        User usr = userService.getUserByEmail(email);

        if (usr.getPassword()!= null && BCrypt.checkpw(password, usr.getPassword())) {
            return new ResponseEntity<>(usr, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>( HttpStatus.FORBIDDEN);
        }

    }

}
