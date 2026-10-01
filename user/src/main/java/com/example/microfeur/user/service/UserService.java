package com.example.microfeur.user.service;

import com.example.microfeur.user.model.User;
import com.example.microfeur.user.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(final int id){
        return userRepository.findById(id);
    }

    public Iterable<User> getUser(){
        return userRepository.findAll();
    }

    public void deleteUser(final int id){
        userRepository.deleteById(id);
    }

    public User saveUser(final User user){
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
