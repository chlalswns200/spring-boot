package com.example.hello.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HospitalDto {

    private String fullAddress;
    private String roadNameAddress;
    private String hospitalName;
    private int healthcareProviderCount;
    private int patientRoomCount;
    private float totalAreaSize;
    private String isClose;
}
