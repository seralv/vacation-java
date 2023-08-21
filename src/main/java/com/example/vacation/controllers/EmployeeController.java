package com.example.vacation.controllers;

import com.example.vacation.DTO.EmployeeDTO;
import com.example.vacation.models.Employee;
import com.example.vacation.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/employees/"}) // , "/employees"
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.createEmployee(employeeDTO);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping("/{employeeId}")
    public void updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeDTO updatedEmployeeDTO) {
        employeeService.updateEmployee(employeeId, updatedEmployeeDTO);
    }
}
