package com.acciojob.dhms.controllers;

import com.acciojob.dhms.models.Doctor;
import com.acciojob.dhms.models.Hospital;
import com.acciojob.dhms.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/register")
    public String registerDoctor(@RequestBody Doctor doctor){
        doctorService.saveDoctorDetail(doctor);
        int id = doctor.getId();
        doctorService.assignDoctorToHospital(id);
        return "Doctor is Successfully Registered and Assigned to Hospital";
    }

    @GetMapping("/get/{id}")
    public Doctor getDoctorDetail(@PathVariable int id){
        return doctorService.getDoctorDetail(id);
    }

}
