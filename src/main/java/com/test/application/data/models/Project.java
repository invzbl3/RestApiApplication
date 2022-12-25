package com.test.application.data.models;

import com.test.application.dto.ProjectDTO;
import lombok.*;
import javax.persistence.*;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "project_entity")
@Table(name = "projects")
public class Project {

    public Project(ProjectDTO projectDTO) {
        this.name = projectDTO.getName();
        this.abbreviation = projectDTO.getAbbreviation();
        this.customer = projectDTO.getCustomer();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    private String name;

    private String abbreviation;

    private String customer;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}