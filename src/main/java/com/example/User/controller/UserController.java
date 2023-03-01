package com.example.User.controller;

import com.example.User.dto.UserDto;
import com.example.User.exception.UserNOtFoundException;
import com.example.User.service.UserService;
import com.example.User.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

@PostMapping("/signup")
    public ResponseEntity<User>saveUser(@RequestBody  @Valid UserDto userDto){
        return new ResponseEntity<User>(userService.saveUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>>getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());

    }
    @GetMapping("/{id}")
    public ResponseEntity<User>getUser(@PathVariable int id) throws UserNOtFoundException {
    return ResponseEntity.ok(userService.getUser(id));
    }

    @DeleteMapping("/delete/{user}")
    public ResponseEntity<String> deleteUser(@PathVariable User user){
    userService.deleteUser(user);
    return new ResponseEntity<>("Successfully deleted by user id",HttpStatus.OK);



    }

}
