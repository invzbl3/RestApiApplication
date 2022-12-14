package com.test.application.web;

import com.test.application.data.models.Employee;
import com.test.application.data.payloads.request.EmployeeRequest;
import com.test.application.data.payloads.response.MessageResponse;
import com.test.application.service.EmployeeService;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * @author invzbl3 on 12/15/2022
 * @project RestApiApplication
 *
 * Browser links for testing purposes:
 *
 * http://localhost:8080/api/employee/all
 * http://localhost:8080/api/employee/find/{id}
 * http://localhost:8080/api/employee/add
 * http://localhost:8080/api/employee/update/{id}
 * http://localhost:8080/api/employee/delete/{id}
 *
 * Example of the structure:
 *
 * {
 *     "firstName": "Christiano",
 *     "lastName": "Ronaldo",
 *     "phoneNumber": "+421905123456",
 *     "email": "test@gmail.com",
 *     "salary": 50000.00,
 *     "role": "TEAM_LEADER",
 *     "password": "testPassword",
 *     "username": "C7"
 * }
 */
@Data
@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, " +
                "please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, " +
                "your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. " +
                "Please bear with us."),
}
)
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
        Employee employee = employeeService.getASingleEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * Reminder instruction for testing:
     *
     * how to add employee step by step using Postman:
     *
     * 1. Choose the section "Body" in the Postman app
     * 2. Choose "raw" + JSON as a type of inserting
     * 3. Choose POST in dropdown
     * 4. Insert in the body the following entry as for testing:
     * 5. Check if you have the correct admin role in "Authorization" section
     *
     * {
     *   "firstName": "Test",
     *   "lastName": "Test2",
     *   "phoneNumber": "+4219051234532",
     *   "email": "test100@gmail.com",
     *   "salary": 500000.00,
     *   "role": "TEAM_LEADER",
     *   "password": "testPassword",
     *   "username": "C9"
     *  }
     *
     */
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addEmployee(@RequestBody EmployeeRequest employee) {
        MessageResponse newEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    /**
     * Reminder instruction for testing:
     *
     * how to update new entity step by step using Postman:
     *
     * 1. Choose the section "Body" in the Postman app
     * 2. Choose "raw" + JSON as a type of updating
     * 3. Choose PUT in dropdown
     * 4. Insert in the body the following entry as for testing:
     * 5. Check if you have the correct admin role in "Authorization" section
     *
     * {
     *   "firstName": "Test",
     *   "lastName": "Test2",
     *   "phoneNumber": "+4219051234532",
     *   "email": "test100@gmail.com",
     *   "salary": 500000.00,
     *   "role": "TEAM_LEADER",
     *   "password": "testPassword",
     *   "username": "C9"
     *  }
     *
     */
    @PutMapping("/update/{id}")
    public Optional<Employee> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeRequest employee) {
        return employeeService.updateEmployee(id, employee);
    }

    /**
     * Reminder instruction for testing:
     *
     * how to delete new entity step by step using Postman:
     *
     * 1. Choose the section "Body" in the Postman app
     * 2. Choose DELETE in dropdown
     * 3. Check if you have the correct admin role in "Authorization" section
     *
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}