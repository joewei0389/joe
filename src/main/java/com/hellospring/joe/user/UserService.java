package com.hellospring.joe.user;

import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

public List<User> getUsers(){
    return userRepository.findAll();
}
public void addNewUser(User user){
    System.out.println(user);
}

}
 

