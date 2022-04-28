package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUser(){
        return userService.getUsers();
    }

    @PostMapping
    public UserModel createUser(@RequestBody UserModel newUser){
        return userService.createUser(newUser);
    }

    @GetMapping( path = "/{id}")
    public Optional<UserModel> getUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    @GetMapping("/query")
    public ArrayList<UserModel> getByPriority(@RequestParam("priority") Integer priority){
        return userService.getByPriority(priority);
    }

    @DeleteMapping( path = "/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        boolean ok = userService.deleteUser(id);
        if(ok){
            return "Se elimino el usuario con id: "+ id + " correctamente";
        }else{
            return "No se pudo eliminar el usuario con ID: " + id; 
        }
    }
    
}
