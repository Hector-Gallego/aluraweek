package com.alurageek.alurageek.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alurageek.alurageek.models.User;
import com.alurageek.alurageek.services.users.IUserService;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

    //metotodo para retornar todos los usuarios registrados en el sistema
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.findAllUsers();
    }

    //metodo para buscar un usuario por su id y retornarlo
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable(value="id") Long id){
        return userService.findByIdUser(id);
    }

    //metodo para elimianar a un usuario
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable(value="id") Long id){
        userService.deleteByIdUser(id);
    }


    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id){
        return userService.updateUser(user, id);
    }
    
}
