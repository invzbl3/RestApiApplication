package com.test.application.repository;

import com.test.application.data.models.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
public interface ProjectRepository {

    Page<Project> findAll(Pageable pageable);

    List<Project> findAll();

    Project save(Project user);

    Optional<Project> findById(Long id);

    void deleteById(Integer id);
}