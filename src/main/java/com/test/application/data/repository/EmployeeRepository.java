package com.test.application.data.repository;

import com.test.application.data.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author invzbl3 on 12/15/2022
 * @project RestApiApplication
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}