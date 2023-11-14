package com.hellospring.joe.user;

import java.time.LocalDate;
import java.time.Period;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "'user'")
public class User {
    @Id
    @SequenceGenerator(
        name="user_sequence",
        sequenceName ="user_sequence",
        allocationSize = 1
    )

    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_sequence"
        )
        private Long Id;
        private String Name;
        private String Email;
        private LocalDate dob;
        @Transient
        private Integer age;


        public User() {
        }
        
        public User(Long id, String name, String email, LocalDate dob) {
            Id = id;
            Name = name;
            Email = email;
            this.dob = dob;

        }
        public User(String name, String email, LocalDate dob) {
            Name = name;
            Email = email;
            this.dob = dob;

        }
        public Long getId() {
            return Id;
        }
        public String getName() {
            return Name;
        }
        public String getEmail() {
            return Email;
        }
        public LocalDate getDob() {
            return dob;
        }

        public Integer getAge() {
            return Period.between(dob, LocalDate.now()).getYears();
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User [Id=" + Id + ", Name=" + Name + ", Email=" + Email + ", dob=" + dob + "]";
        }


        

        


}
