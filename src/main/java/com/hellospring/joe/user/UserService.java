package com.hellospring.joe.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

/*     public void addNewUser(User user){
        System.out.println(user);
    } */
    public void addNewUser(User user){
    Optional<User> userOptional = userRepository
            .findUserByEmail(user.getEmail());
    if (userOptional.isPresent()){
        throw new IllegalStateException("email taken");
    }
        userRepository.save(user);
    } 
    public void deleteUser(Long userId){
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException(
                "user with id " + userId + "does not exists");
        }
        userRepository.deleteById(userId);
    }
}
