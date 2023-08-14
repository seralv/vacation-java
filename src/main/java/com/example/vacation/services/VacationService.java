package com.example.vacation.services;

import com.example.vacation.DTO.VacationDTO;
import com.example.vacation.models.Vacation;
import com.example.vacation.models.WorkInformation;
import com.example.vacation.repository.VacationRepository;
import com.example.vacation.repository.WorkInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacationService {

    @Autowired
    private VacationRepository vacationRepository;
    @Autowired
    private WorkInformationRepository workInformationRepository;

    public void createVacation(VacationDTO vacationDto) {
        Vacation vacation = Vacation.builder()
                .initDate(vacationDto.getInitDate())
                .endDate(vacationDto.getEndDate())
                .daysTaken(vacationDto.getDaysTaken())
                .employee(vacationDto.getEmployee())
                .build();
        vacationRepository.save(vacation);
        WorkInformation workInformation = workInformationRepository.getReferenceById(vacationDto.getEmployee().getWorkInformation().getId());
        int remainingDays = workInformation.getRemainingDays() - vacationDto.getDaysTaken();
        workInformation.setRemainingDays(remainingDays);
        workInformationRepository.save(workInformation);
    }
}
