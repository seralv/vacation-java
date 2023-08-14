package com.example.vacation.DTO;

import com.example.vacation.models.Employee;
import lombok.Data;

import java.util.Date;

@Data
public class VacationDTO {
    private Date initDate;
    private Date endDate;
    private int daysTaken;
    private Employee employee;
}
