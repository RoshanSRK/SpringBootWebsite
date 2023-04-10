package com.example.demo.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.time.Month;
import java.util.IllegalFormatWidthException;
import java.util.List;
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
            throw new IllegalStateException("email taken");
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
                throw new IllegalStateException("email taken");
            }
            user.setEmail(email);
        }
    }
}
