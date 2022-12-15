package com.test.application.model;

import lombok.*;
import javax.persistence.*;

/**
 * @author invzbl3 on 12/15/2022
 * @project RestApiApplication
 */

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id", updatable = false, nullable = false)
    private Integer projectID;



}
