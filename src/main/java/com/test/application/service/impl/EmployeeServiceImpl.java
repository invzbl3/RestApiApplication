package com.test.application.service.impl;

import com.test.application.data.models.Employee;
import com.test.application.data.payloads.request.EmployeeRequest;
import com.test.application.data.payloads.response.MessageResponse;
import com.test.application.data.repository.EmployeeRepository;
import com.test.application.exception.ResourceNotFoundException;
import com.test.application.service.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * @author invzbl3 on 12/15/2022
 * @project RestApiApplication
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public MessageResponse createEmployee(EmployeeRequest employeeRequest) {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName(employeeRequest.getFirstName());
        newEmployee.setLastname(employeeRequest.getLastname());
        newEmployee.setPhoneNumber(employeeRequest.getPhoneNumber());
        newEmployee.setEmail(employeeRequest.getEmail());
        newEmployee.setSalary(employeeRequest.getSalary());
        newEmployee.setRole(employeeRequest.getRole());
        employeeRepository.save(newEmployee);
        return new MessageResponse("New Employee created successfully");

    }

    @Override
    public Optional<Employee> updateEmployee(Integer employeeId, EmployeeRequest employeeRequest) throws ResourceNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isEmpty()) {
            throw new ResourceNotFoundException("Employee", "id", employeeId);
        } else {
            employee.get().setFirstName(employeeRequest.getFirstName());
            employee.get().setLastname(employeeRequest.getLastname());
            employee.get().setPhoneNumber(employeeRequest.getPhoneNumber());
            employee.get().setEmail(employeeRequest.getEmail());
            employee.get().setSalary(employeeRequest.getSalary());
            employee.get().setRole(employeeRequest.getRole());
            employeeRepository.save(employee.get());
            return employee;
        }
    }

    @Override
    public Employee getASingleEmployee(Integer employeeId) throws ResourceNotFoundException {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(Integer employeeId) throws ResourceNotFoundException {
        if (employeeRepository.getReferenceById(employeeId).getId().equals(employeeId)) {
            employeeRepository.deleteById(employeeId);
        } else throw new ResourceNotFoundException("Employee", "id", employeeId);
    }
}