package com.example.hello.controller;

import com.example.hello.dao.HospitalDao;
import com.example.hello.domain.Hospital;
import com.example.hello.domain.dto.HospitalDto;
import com.example.hello.service.HospitalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospital")
public class HospitalController {

    private final HospitalDao hospitalDao;
    private final HospitalService hospitalService;

    public HospitalController(HospitalDao hospitalDao, HospitalService hospitalService) {
        this.hospitalDao = hospitalDao;
        this.hospitalService = hospitalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalDto> get(@PathVariable int id) {
        Hospital byId = hospitalDao.findById(id);

        HospitalDto hospitalDto = hospitalService.makeDto(byId);
        Optional<HospitalDto> hp = Optional.of(hospitalDto);

        if (!hp.isEmpty()) {
            return ResponseEntity.ok().body(new HospitalDto(hospitalDto.getHospitalName(), hospitalDto.getFullAddress(),
                    hospitalDto.getRoadNameAddress(),hospitalDto.getHealthcareProviderCount(),
                    hospitalDto.getPatientRoomCount(),hospitalDto.getTotalAreaSize(),hospitalDto.getIsClose()));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HospitalDto());
        }
    }

}
