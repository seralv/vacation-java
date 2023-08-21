package com.example.vacation.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "employees_workinformation")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("entryDate")
    private LocalDate entryDate;
    private int remainingDays;
    private String state;

    @OneToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee;
}
