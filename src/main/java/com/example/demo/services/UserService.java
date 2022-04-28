package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>)userRepository.findAll();
    }

    public UserModel createUser(UserModel newUser){
        return userRepository.save(newUser);
    }
    //Lo ponemos de tipo Optional por si el id no existe no falle
    public Optional<UserModel> getUser(Long id){
        return userRepository.findById(id);
    }

    public ArrayList<UserModel> getByPriority(Integer priority) {
        return userRepository.findByPriority(priority);
    }

    public boolean deleteUser(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
