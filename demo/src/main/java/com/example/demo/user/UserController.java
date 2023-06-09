package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin //eliminates the CORS error when viewing logs
    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @CrossOrigin
    @PostMapping("/save")
    public void registerNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }

    @CrossOrigin
    @PostMapping("/validate")
    public void ValidateUser(@RequestBody User user){ userService.findUser(user);}

   @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
   }

   @PutMapping(path = "{userId}")
    public void updateUser (
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password){
                userService.updateUser(userId, name, email, password);
    }



}


