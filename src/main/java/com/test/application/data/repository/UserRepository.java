package com.test.application.data.repository;

import com.test.application.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author invzbl3 on 12/25/2022
 * @project RestApiApplication
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}