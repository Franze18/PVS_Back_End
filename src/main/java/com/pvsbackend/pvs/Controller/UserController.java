package com.pvsbackend.pvs.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pvsbackend.pvs.Model.User;
import com.pvsbackend.pvs.NotFoundException.UserNotFoundException;
import com.pvsbackend.pvs.Repository.UserRepository;



@RestController
public class UserController {

    final UserRepository repo;
    
    public UserController (UserRepository repo){
        this.repo = repo;
    }
//http://127.0.0.1/User
    //getall User
    @GetMapping("/User")
    public List<User>getUser(){
        return repo.findAll();
    }
    //http://127.0.0.1:8080/User/1
    @GetMapping("/User/{id}")
    public User  getUserById(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow (()-> new UserNotFoundException(id));
    }  

    //http//:127.0.0.1:8080/User/new
    @PostMapping("/User/new")
    public String addUser(@RequestBody User newUser){
        repo.save(newUser);
        return "A new User is added!";

    }
   //UPDATE ENDPOINTS
   //http:127.0.0.1:8080/User/edit/1
   @PutMapping ("/User/edit/{id}")
   public User updateUser(@PathVariable Long id, 
   @RequestBody User newUser){
        return repo.findById(id)
        .map(User ->{
            User.setEmail(newUser.getEmail());
            User.setFirstname(newUser.getFirstname());
            User.setMiddlename(newUser.getMiddlename());
            User.setLastname(newUser.getLastname());
            User.setPhonenumber(newUser.getPhonenumber());
            User.setAddress(newUser.getAddress());
            User.setPassword(newUser.getPassword());
            return repo.save(User);
    }).orElseGet(()->{
        return repo.save(newUser);
    });
   }
   

   //DELETE ENDPOINTS
   //http://127.0.0.1:8080/User/delete/1
   @DeleteMapping ("User/delete/{id}")
   public String deleteUser(@PathVariable Long id){
     repo.deleteById(id);
     return "A user is deleted!";
   }
}
