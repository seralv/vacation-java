package com.example.vacation.components;

import com.example.vacation.models.WorkInformation;
import com.example.vacation.repository.WorkInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Component
public class RemaindVacations {

    @Autowired
    private WorkInformationRepository workInformationRepository;

    @Scheduled(cron = "234")
    public void reviewVacation() {
        LocalDate now = LocalDate.now();
        List<WorkInformation> workInformationList = workInformationRepository.findAllByState("working");
        workInformationList.forEach(workInformation -> {
            Period periodo = Period.between(workInformation.getEntryDate(), now);
            int yearsServices = periodo.getYears();

            if (yearsServices < 1) {
                workInformation.setRemainingDays(0);
            } else if (yearsServices < 6) {
                workInformation.setRemainingDays(workInformation.getRemainingDays() + 15);
            } else if (yearsServices < 11) {
                workInformation.setRemainingDays(workInformation.getRemainingDays() + 20);
            } else {
                workInformation.setRemainingDays(workInformation.getRemainingDays() + 30);
            }
            workInformationRepository.save(workInformation);
        });
    }
}
