package com.test.application.service;

import com.test.application.data.models.Employee;
import com.test.application.data.payloads.request.EmployeeRequest;
import com.test.application.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

/**
 * @author invzbl3 on 12/15/2022
 * @project RestApiApplication
 */
@Component
public interface EmployeeService {
    MessageResponse createEmployee(EmployeeRequest employeeRequest);
    Optional<Employee> updateEmployee(Integer employeeId, EmployeeRequest employeeRequest);
    void deleteEmployee(Integer employeeId);
    Employee getASingleEmployee(Integer employeeId);
    List<Employee> getAllEmployee();
}