 package com.hellospring.joe.user;
 import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 @SpringBootApplication
 @Repository
 public interface UserRepository 
            extends JpaRepository<User,Long> {

    
}
