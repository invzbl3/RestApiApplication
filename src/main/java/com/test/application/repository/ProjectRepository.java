package com.test.application.repository;

import com.test.application.data.models.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
public interface ProjectRepository {

    Page<Project> findAll(Pageable pageable);
}
