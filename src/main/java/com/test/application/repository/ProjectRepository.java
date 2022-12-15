package com.test.application.repository;

import com.test.application.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author invzbl3 on 12/15/2022
 * @project RestApiApplication
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // all crud database methods
}