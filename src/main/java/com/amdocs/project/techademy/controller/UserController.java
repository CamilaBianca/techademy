package com.amdocs.project.techademy.controller;

import com.amdocs.project.techademy.model.User;
import com.amdocs.project.techademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // get all users
    @GetMapping(value = "/user")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity(userService.getAllUser(), HttpStatus.ACCEPTED);
    }

    // create user rest api
    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return new ResponseEntity(userService.createUser(user), HttpStatus.CREATED);
    }

    // get user by id rest api
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        return new ResponseEntity(userService.getUserById(id), HttpStatus.ACCEPTED);
    }

    // update user rest api
    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User newUserDetails) {
        return new ResponseEntity(userService.updateByWithNewUser(id, newUserDetails), HttpStatus.ACCEPTED);
    }

    // delete user rest api
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        return new ResponseEntity(userService.deleteUser(id), HttpStatus.GONE);
    }

    // update upload photo rest api
    @PutMapping("/user/upload/{id}")
    public ResponseEntity updateUploadPhoto(@PathVariable int id, @RequestParam("uploadPhoto") MultipartFile uploadPhoto) {
        return new ResponseEntity(userService.updateUploadPhoto(id, uploadPhoto), HttpStatus.ACCEPTED);
    }

}
