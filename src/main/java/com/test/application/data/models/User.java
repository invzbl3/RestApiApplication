package com.test.application.data.models;

import com.test.application.data.enums.Role;
import com.test.application.dto.ProjectDTO;
import com.test.application.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author invzbl3 on 12/25/2022
 * @project RestApiApplication
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_entity")
@Table(name = "users")
public class User {

    public User(UserDTO userDTO) {
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.role = userDTO.getRole();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Project> projects;
    @CreationTimestamp
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public User(long id) {
        super();
        this.id = id;
    }

    public User(String name, String email, String password, Role role) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}