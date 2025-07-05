package com.acciojob.dhms.service;

import com.acciojob.dhms.models.Doctor;
import com.acciojob.dhms.models.Hospital;
import com.acciojob.dhms.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    HospitalService hospitalService;

    public void saveDoctorDetail(Doctor doctor){
        int id = doctorRepository.totalDoctor()+1;
        doctor.setId(id);
        doctorRepository.saveDoctor(id,doctor);
    }

    public Doctor getDoctorDetail(int id){
        return doctorRepository.getDoctorDetail(id);
    }

    public void assignDoctorToHospital(int id){
        Doctor doctor = doctorRepository.getDoctorDetail(id);
        Hospital hospital = hospitalService.getMinDoctorHospital();
        List<Doctor> doctors = hospital.getDoctors();
        doctors.add(doctor);
    }

}
