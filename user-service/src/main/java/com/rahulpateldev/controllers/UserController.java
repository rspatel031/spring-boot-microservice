package com.rahulpateldev.controllers;

import com.rahulpateldev.entities.User;
import com.rahulpateldev.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //    Add User
    @PostMapping
    public ResponseEntity<User> addUsers(@RequestBody User user) {
        User savedUser = this.userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //    Fetch All User
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = this.userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //    Fetch 1 User
    @GetMapping("/{id}")
    public ResponseEntity<User> getUsers(@PathVariable String id) {
        User user = this.userService.getUsers(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //    Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsers(@PathVariable String id) {
        this.userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    //    Update User
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUsers(@PathVariable String id, @RequestBody User user) {
        User updatedUser = this.userService.updateUser(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}