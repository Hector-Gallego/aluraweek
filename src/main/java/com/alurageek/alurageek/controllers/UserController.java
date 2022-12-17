package com.alurageek.alurageek.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.alurageek.alurageek.models.User;
import com.alurageek.alurageek.services.users.IUserService;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

    //metotodo para retornar todos los usuarios registrados en el sistema
    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers(){
            List<User> users = userService.findAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //metodo para buscar un usuario por su id y retornarlo
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable(value="id") Long id){

        User user = userService.findByIdUser(id); 
        return new ResponseEntity<>(user,HttpStatus.OK); 
            
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

    /* 
     *  @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String,String>> execptionError(NoSuchElementException exception){
        Map<String,String> error = new HashMap<>();
        
        error.put("error", "no se encontro al elemento");
        return new ResponseEntity<Map<String,String>>(error,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String,String>> execptionError2(MethodArgumentTypeMismatchException exception){
        Map<String,String> error = new HashMap<>();
        error.put("error", "formato de parametro invalido");
        return new ResponseEntity<Map<String,String>>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
     * 
    */
   


    
}
