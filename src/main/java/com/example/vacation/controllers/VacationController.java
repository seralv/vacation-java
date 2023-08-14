package com.example.vacation.controllers;

import com.example.vacation.DTO.VacationDTO;
import com.example.vacation.services.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/vacations", "/vacations/"})
public class VacationController {

    @Autowired
    private VacationService vacationService;
    @PostMapping
    public void registerVacation(@RequestBody VacationDTO vacationDTO) {
        vacationService.createVacation(vacationDTO);
    }

    @GetMapping
    public void getVacations() {

    }
}
