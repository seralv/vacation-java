package com.example.vacation.controllers;

import com.example.vacation.DTO.EmployeeDTO;
import com.example.vacation.DTO.WorkInformationDTO;
import com.example.vacation.models.WorkInformation;
import com.example.vacation.services.WorkInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/work-information/")
public class WorkInformationController {

    @Autowired
    private WorkInformationService workInformationService;

    @GetMapping
    public List<WorkInformation> getAllWorkInformation() {
        return workInformationService.getAllWorkInformation();
    }

    @PostMapping
    public void createWorkInformation(@RequestBody WorkInformationDTO workInformationDTO) {
        workInformationService.createWorkInformation(workInformationDTO);
    }
}
