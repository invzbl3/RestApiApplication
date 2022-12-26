package com.test.application.service;

import com.test.application.data.models.User;
import com.test.application.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author invzbl3 on 12/26/2022
 * @project RestApiApplication
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> get() {
        return userRepository.findAll();
    }
}