package com.hasnain.crudapiproject.crudapi.controller;
import com.hasnain.crudapiproject.crudapi.model.User;
import com.hasnain.crudapiproject.crudapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController // Makes this class a REST API controller
@RequestMapping("/api/users") // All routes will start with this
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updateUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updateUser.getName());
            user.setEmail(updateUser.getEmail());
            return userRepository.save(user);
        }).orElse(null);
        }

     @DeleteMapping("/{id}")
     public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
}
    }
