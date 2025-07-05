package com.acciojob.dhms.controllers;

import com.acciojob.dhms.models.Patient;
import com.acciojob.dhms.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/register")
    public String registerPatient(@RequestBody Patient patient){
        patientService.savePatientDetail(patient);
        patientService.assignPatientToHospital(patient);
        return "Successfully registered and allocated hospital and doctor";
    }

    @GetMapping("/get/{id}")
    public Patient getPatientDetail(@PathVariable int id){

        return patientService.getPatientDetail(id);
    }
}
