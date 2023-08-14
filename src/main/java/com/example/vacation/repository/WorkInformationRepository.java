package com.example.vacation.repository;

import com.example.vacation.models.WorkInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkInformationRepository extends JpaRepository<WorkInformation, Long> {

    List<WorkInformation> findAllByState(String state);
}
