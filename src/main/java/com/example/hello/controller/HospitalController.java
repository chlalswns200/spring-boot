package com.example.hello.controller;

import com.example.hello.dao.HospitalDao;
import com.example.hello.domain.Hospital;
import com.example.hello.domain.dto.HospitalDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hospital")
public class HospitalController {

    private final HospitalDao hospitalDao;

    public HospitalController(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @GetMapping("/{id}")
    public HospitalDto get(@PathVariable int id) {
        Hospital byId = hospitalDao.findById(1);
        String isClose ="영업중";
        if(byId.getBusinessStatusCode()==3) isClose ="폐업";
        return new HospitalDto(byId.getHospitalName(), byId.getFullAddress(),
                byId.getRoadNameAddress(),byId.getHealthcareProviderCount(),
                byId.getPatientRoomCount(),byId.getTotalAreaSize(),isClose);
    }

}
