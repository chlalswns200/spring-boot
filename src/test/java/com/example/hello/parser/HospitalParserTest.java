package com.example.hello.parser;

import com.example.hello.dao.HospitalDao;
import com.example.hello.domain.Hospital;
import com.example.hello.service.HospitalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HospitalParserTest {

    String filename = "C:\\Users\\chlal\\Desktop\\likeLion\\hello\\fulldata_01_01_02_P_의원.csv";
    String line1 = "\"1\",\"의원\",\"01_01_02_P\",\"3620000\",\"PHMA119993620020041100004\",\"19990612\",\"\",\"01\",\"영업/정상\",\"13\",\"영업중\",\"\",\"\",\"\",\"\",\"062-515-2875\",\"\",\"500881\",\"광주광역시 북구 풍향동 565번지 4호 3층\",\"광주광역시 북구 동문대로 24, 3층 (풍향동)\",\"61205\",\"효치과의원\",\"20211115113642\",\"U\",\"2021-11-17 02:40:00.0\",\"치과의원\",\"192630.735112\",\"185314.617632\",\"치과의원\",\"1\",\"0\",\"0\",\"52.29\",\"401\",\"치과\",\"\",\"\",\"\",\"0\",\"0\",\"\",\"\",\"0\",\"\"";

    @Autowired
    ReadLineContext<Hospital> hospitalReadLineContext;

    @Autowired
    HospitalDao hospitalDao;

    @Autowired
    HospitalService hospitalService;

    @Test
    void addAll2() {
        hospitalDao.deleteAll();
        hospitalService.insertLargeVolumeHospitalData2(filename);
    }

//    @Test
//    void addAll() throws IOException {
//        hospitalDao.deleteAll();
//        List<Hospital> hospitalList = hospitalReadLineContext.readByLine(filename);
//        for (Hospital hospital : hospitalList) {
//            hospitalDao.add(hospital);
//        }
//    }

//    @Test
//    @DisplayName("Hospital이 insert가 잘 되고 select도 잘 되는지")
//    void addAndGet() {
//        hospitalDao.deleteAll();
//        assertEquals(0,hospitalDao.getCount());
//
//        HospitalParser hp = new HospitalParser();
//        Hospital parse = hp.parse(line1);
//        hospitalDao.add(parse);
//
//        Hospital selectedHospital = hospitalDao.findById(parse.getId());
//        assertEquals(selectedHospital.getId(), parse.getId());
//        assertEquals(selectedHospital.getOpenServiceName(), parse.getOpenServiceName());
//
//        assertEquals(selectedHospital.getOpenLocalGovernmentCode(),parse.getOpenLocalGovernmentCode());
//        assertEquals(selectedHospital.getManagementNumber(),parse.getManagementNumber());
//        assertEquals(selectedHospital.getBusinessStatus(), parse.getBusinessStatus()); // idx:7
//        assertEquals(selectedHospital.getBusinessStatusCode(), parse.getBusinessStatusCode());
//
//        assertTrue(selectedHospital.getLicenseDate().isEqual(parse.getLicenseDate()));
//
//        assertEquals(selectedHospital.getPhone(), parse.getPhone());
//        assertEquals(selectedHospital.getFullAddress(), parse.getFullAddress());
//        assertEquals(selectedHospital.getRoadNameAddress(), parse.getRoadNameAddress());
//        assertEquals(selectedHospital.getHospitalName(), parse.getHospitalName());
//
//        assertEquals(selectedHospital.getBusinessTypeName(), parse.getBusinessTypeName());
//        assertEquals(selectedHospital.getHealthcareProviderCount(), parse.getHealthcareProviderCount());
//        assertEquals(selectedHospital.getPatientRoomCount(), parse.getPatientRoomCount());
//        assertEquals(selectedHospital.getTotalNumberOfBeds(), parse.getTotalNumberOfBeds());
//        // 날짜, float
//        assertEquals(selectedHospital.getTotalAreaSize(), parse.getTotalAreaSize());
//
//    }
//    @Test
//    void name() throws IOException {
//
//        List<Hospital> hospitalList = hospitalReadLineContext.readByLine(filename);
//        assertTrue(hospitalList.size()>1000);
//        assertTrue(hospitalList.size()>10000);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(hospitalList.get(i).getHospitalName());
//        }
//        System.out.printf("파싱된 데이터 개수:%d\n",hospitalList.size());
//    }

//    @Test
//    @DisplayName("csv 1줄을 Hospital로 잘 만드는지test")
//    void convertToHospital() {
//
//        HospitalParser hp = new HospitalParser();
//        Hospital hospital = hp.parse(line1);
//
//        assertEquals(1, hospital.getId()); // col:0
//        assertEquals("의원", hospital.getOpenServiceName());//col:1
//        assertEquals(3620000,hospital.getOpenLocalGovernmentCode()); // col: 3
//        assertEquals("PHMA119993620020041100004",hospital.getManagementNumber()); // col:4
//        assertEquals(LocalDateTime.of(1999, 6, 12, 0, 0, 0), hospital.getLicenseDate()); //19990612 //col:5
//        assertEquals(1, hospital.getBusinessStatus()); //col:7
//        assertEquals(13, hospital.getBusinessStatusCode());//col:9
//        assertEquals("062-515-2875", hospital.getPhone());//col:15
//        assertEquals("광주광역시 북구 풍향동 565번지 4호 3층", hospital.getFullAddress()); //col:18
//        assertEquals("광주광역시 북구 동문대로 24, 3층 (풍향동)", hospital.getRoadNameAddress());//col:19
//        assertEquals("효치과의원", hospital.getHospitalName());//col:21
//        assertEquals("치과의원", hospital.getBusinessTypeName());//col:25
//        assertEquals(1, hospital.getHealthcareProviderCount()); //col:29
//        assertEquals(0, hospital.getPatientRoomCount()); //col:30
//        assertEquals(0, hospital.getTotalNumberOfBeds()); //col:31
//        assertEquals(52.29f, hospital.getTotalAreaSize()); //col:32
//
//    }

}