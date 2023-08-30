package com.example.vacation.DTO;

import com.example.vacation.models.Employee;
import lombok.Data;

import java.util.Date;

@Data
public class WorkInformationDTO {
    private Date entryDate;
    private int remainingDays;
    private String state;
    private Employee employee;
}
