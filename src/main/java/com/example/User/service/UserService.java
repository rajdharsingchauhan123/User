package com.example.User.service;

import com.example.User.dto.UserDto;
import com.example.User.repository.UserRepository;
import com.example.User.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserDto userDto){
        User user=User.build(0, userDto.getName(), userDto.getEmail(), userDto.getMobile(), userDto.getGender(), userDto.getAge(), userDto.getNationality());
        return  userRepository.save(user);
    }
    public List<User>getAllUser(){
        return userRepository.findAll();

    }
    public User getUser(int id) {

        User user= userRepository.findByUserId(id);
//        Optional<User>User=Optional.of(user);
        return user;

    }
    public String deleteUser(User user){
        userRepository.delete(user);
        return "sucesss";
    }
}
