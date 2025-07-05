package com.acciojob.dhms.controllers;



import com.acciojob.dhms.models.Hospital;
import com.acciojob.dhms.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/hospital")
public class HospitalController {

    @Autowired
    HospitalService hospitalService;

    @PostMapping("/register")
    public String registerHospital(@RequestBody Hospital hospital){

        System.out.println("we got the object body of hospital" + hospital);
        hospitalService.saveHospitalDetail(hospital);
        return "Successfully Registered";
    }
    @GetMapping("/get/{id}")
    public Hospital getHospitalDetailById(@PathVariable int id){
        return hospitalService.getHospitalDetail(id);
    }
    @GetMapping("/get/all")
    public List<Hospital> getAllHospital(){
        return hospitalService.getAllHospitalList();
    }
}
