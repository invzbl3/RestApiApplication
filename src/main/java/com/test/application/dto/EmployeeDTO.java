package com.test.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.test.application.data.enums.Role;
import com.test.application.data.models.Employee;
import com.test.application.data.models.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class EmployeeDTO implements Serializable {

    public EmployeeDTO(Employee employee) {
        this.firstName = employee.getFirstName();
        this.lastname = employee.getLastname();
        this.phoneNumber = employee.getPhoneNumber();
        this.email = employee.getEmail();
        this.salary = employee.getSalary();
        this.role = employee.getRole();
        this.password = employee.getPassword();
        this.username = employee.getUsername();
    }

    private String firstName;

    private String lastname;

    private String phoneNumber;

    private String email;

    private double salary;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String password;

    private String username;
}