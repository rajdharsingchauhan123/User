package com.example.User.service;

import com.example.User.dto.UserDto;
import com.example.User.repository.UserRepository;
import com.example.User.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public User getUser(int id){
        return userRepository.findByUserId(id);
    }
    public void deleteUser(User user){
        userRepository.delete(user);
    }
}
