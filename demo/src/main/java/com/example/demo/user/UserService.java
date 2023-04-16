package com.example.demo.user;

import jakarta.annotation.PreDestroy;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional =
                userRepository.findUserByEmail(user.getEmail());

        if(userOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        userRepository.save(user);

//        System.out.println(user);
    }

    public void deleteUser(Long userId) {
      boolean exists = userRepository.existsById(userId);
      if(!exists){
          throw new IllegalStateException("User with user id " + userId  + " does not exist");

      }
      userRepository.deleteById(userId);
    }

    @Transactional // No need for Queries in the repository to update
    public void updateUser(Long userId, String name, String email, String password) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalStateException("user with id " + userId + " does not exist"));

        if (name!= null &&
                name.length() > 0 &&
                !name.equals(user.getName())){
            user.setName(name);
        }

        if (email!= null &&
                email.length() > 0 &&
                !email.equals(user.getEmail())){
            Optional<User> userOptional =
                    userRepository.findUserByEmail(email );

            if(userOptional.isPresent()){
                throw new IllegalStateException("Email taken");
            }
            user.setEmail(email);
        }
        if (password!= null &&
                password.length() > 0 &&
                !password.equals(user.getPassword())){
            user.setPassword(password);
        }
    }

    public void findUser(User user) {
//        String userEmail = user.getEmail();
        Optional<User> userFound =
                userRepository.findUserByEmail(user.getEmail());

        if(userFound.isPresent()){
            String repoPass = (userFound.get()).getPassword();
            if(!Objects.equals(user.getPassword(), repoPass)){
                throw new IllegalStateException("Email and password do not match!");
            }
        }
        else{
            throw new IllegalStateException("User does not exist");
        }
    }

    @PreDestroy
    public void deleteAllData() {
        userRepository.deleteAll();
    }
}
