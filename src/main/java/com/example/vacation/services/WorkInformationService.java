package com.example.vacation.services;

import com.example.vacation.DTO.WorkInformationDTO;
import com.example.vacation.models.WorkInformation;
import com.example.vacation.repository.WorkInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkInformationService {

    @Autowired
    private WorkInformationRepository workInformationRepository;

    public List<WorkInformation> getAllWorkInformation() {
        return workInformationRepository.findAll();
    }

    public void createWorkInformation(WorkInformationDTO workInformationDTO) {
//        WorkInformation wi =  WorkInformation.builder()
//                .da
//                .build();
    }
}
