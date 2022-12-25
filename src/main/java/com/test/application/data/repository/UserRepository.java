package com.test.application.data.repository;

import com.test.application.data.models.User;

/**
 * @author invzbl3 on 12/25/2022
 * @project RestApiApplication
 */
public interface UserRepository {
    User findByEmail(String email);
}