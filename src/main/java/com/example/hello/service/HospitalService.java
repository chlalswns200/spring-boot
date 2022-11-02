package com.example.hello.service;

import com.example.hello.dao.HospitalDao;
import com.example.hello.domain.Hospital;
import com.example.hello.domain.dto.HospitalDto;
import com.example.hello.parser.ReadLineContext;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class HospitalService {

    private final ReadLineContext<Hospital> hospitalReadLineContext;
    private final HospitalDao hospitalDao;

    public HospitalService(ReadLineContext<Hospital> hospitalReadLineContext, HospitalDao hospitalDao) {
        this.hospitalReadLineContext = hospitalReadLineContext;
        this.hospitalDao = hospitalDao;
    }

    public void insertLargeVolumeHospitalData(String filename) {
        try {
            List<Hospital> hospitalList = hospitalReadLineContext.readByLine(filename);
            for (Hospital hospital : hospitalList) {
                this.hospitalDao.add(hospital);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public HospitalDto makeDto(Hospital hospital) {

        String isClose = "영업중";
        if (hospital.getBusinessStatusCode() == 3) {

            isClose = "폐업";
        }

        return new HospitalDto(hospital.getHospitalName(), hospital.getFullAddress(),
                hospital.getRoadNameAddress(),hospital.getHealthcareProviderCount(),
                hospital.getPatientRoomCount(),hospital.getTotalAreaSize(),isClose);

    }
}
