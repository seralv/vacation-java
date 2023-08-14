package com.example.vacation.services;

import com.example.vacation.DTO.EmployeeDTO;
import com.example.vacation.models.Employee;
import com.example.vacation.models.WorkInformation;
import com.example.vacation.repository.EmployeeRepository;
import com.example.vacation.repository.WorkInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private WorkInformationRepository workInformationRepository;

    public void createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = Employee.builder()
                .name(employeeDTO.getName())
                .address(employeeDTO.getAddress())
                .lastName(employeeDTO.getLastName())
                .phone(employeeDTO.getPhone())
                .position(employeeDTO.getPosition())
                .build();

        employeeRepository.save(employee);
        WorkInformation workInformation = WorkInformation.builder()
                .employee(employee)
                .entryDate(employeeDTO.getEntryDate())
                .state("working")
                .remainingDays(0)
                .build();
        workInformationRepository.save(workInformation);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
