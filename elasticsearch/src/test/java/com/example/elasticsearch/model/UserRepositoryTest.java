package com.example.elasticsearch.model;

import com.example.elasticsearch.ElasticsearchApplication;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ElasticsearchApplication.class)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    public void before() {
        userRepository.deleteAll();
        userRepository.save(new User("1", "anna", "abc@gmail.com", 18));
        userRepository.save(new User("2", "gg", "abc@gmail.com", 15));
        userRepository.save(new User("3", "feifei", "abc@gmail.com", 28));
        userRepository.save(new User("4", "lili", "abc@gmail.com", 38));
        userRepository.save(new User("5", "bkak", "abc@gmail.com", 14));
    }

    @Test
    public void testSearch() {
        List<User> users = (List<User>) userRepository.findAll();
        System.out.println(users.toString());
    }
}