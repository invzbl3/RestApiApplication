package com.test.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.test.application.data.enums.Role;
import com.test.application.data.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author invzbl3 on 12/25/2022
 * @project RestApiApplication
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class UserDTO implements Serializable {

    public UserDTO(User user) {
        this.firstName = user.getName();
        this.lastName = user.getEmail();
        this.phoneNumber = user.getPassword();
        this.email = user.getEmail();
        this.role = user.getRole();
    }

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private double salary;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String password;

    private String username;
}