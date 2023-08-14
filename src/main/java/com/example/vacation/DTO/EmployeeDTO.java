package com.example.vacation.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDTO {
    private String name;
    @JsonProperty("last_name")
    private String lastName;
    private String address;
    private String phone;
    private String position;

    @JsonProperty("entry_date")
    private LocalDate entryDate;
}
