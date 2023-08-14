package com.example.vacation.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
