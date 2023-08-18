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

    @Scheduled(cron = "0 */1 * ? * *")
    public void reviewVacation() {
        LocalDate now = LocalDate.now();
        List<WorkInformation> workInformationList = workInformationRepository.findAllByState("working");
        workInformationList.forEach(workInformation -> {
            Period period = Period.between(workInformation.getEntryDate(), now);
            int yearsServices = period.getYears();

            if (yearsServices < 1) {
                workInformation.setRemainingDays(0);
            } else if (yearsServices < 6 && now.getDayOfMonth() == workInformation.getEntryDate().getDayOfMonth() &&
                    now.getMonth() == workInformation.getEntryDate().getMonth()) {
                workInformation.setRemainingDays(workInformation.getRemainingDays() + 15);
            } else if (yearsServices < 11 && now.getDayOfMonth() == workInformation.getEntryDate().getDayOfMonth() &&
                    now.getMonth() == workInformation.getEntryDate().getMonth()) {
                workInformation.setRemainingDays(workInformation.getRemainingDays() + 20);
            } else if(now.getDayOfMonth() == workInformation.getEntryDate().getDayOfMonth() &&
                    now.getMonth() == workInformation.getEntryDate().getMonth()) {
                workInformation.setRemainingDays(workInformation.getRemainingDays() + 30);
            }
            workInformationRepository.save(workInformation);
        });
    }
}
