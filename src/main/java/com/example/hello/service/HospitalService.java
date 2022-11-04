package com.example.hello.service;

import com.example.hello.dao.HospitalDao;
import com.example.hello.domain.Hospital;
import com.example.hello.domain.dto.HospitalDto;
import com.example.hello.parser.ReadLineContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public int insertLargeVolumeHospitalData2(String filename) {
        List<Hospital> hospitalList;
        try {
            hospitalList = hospitalReadLineContext.readByLine(filename);
            System.out.println("파싱이 끝났습니다.");
            hospitalList.stream()
                    .forEach(hospital -> {
                        try {
                            this.hospitalDao.add(hospital); // db에 insert하는 구간
                        } catch (Exception e) {
                            System.out.printf("id:%d 레코드에 문제가 있습니다.\n", hospital.getId());
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (!Optional.of(hospitalList).isEmpty()) {
            return hospitalList.size();
        } else {
            return 0;
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