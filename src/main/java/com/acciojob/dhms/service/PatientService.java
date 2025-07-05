package com.acciojob.dhms.service;

import com.acciojob.dhms.models.Doctor;
import com.acciojob.dhms.models.Hospital;
import com.acciojob.dhms.models.Patient;
import com.acciojob.dhms.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    HospitalService hospitalService;

    public void savePatientDetail(Patient patient){
        int id = patientRepository.totalPatient()+1;
        patient.setId(id);
        patientRepository.savePatient(id,patient);
    }

    public Patient getPatientDetail(int id){
        return patientRepository.getPatient(id);
    }

    public void assignDoctorToPatient(Hospital hospital, Patient patient){
        List<Doctor> doctorList = hospital.getDoctors();
        Doctor assignedDoctor = null;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<doctorList.size(); i++)
        {
            Doctor doctor = doctorList.get(i);
            if(doctor.getPatients().size() < min)
            {
                assignedDoctor = doctor;
                min = doctor.getPatients().size();
            }
        }
        if(assignedDoctor!=null) {
            List<Patient> patients = assignedDoctor.getPatients();
            patients.add(patient);
        }
    }

    public void assignPatientToHospital(Patient patient){
        Hospital hospital = hospitalService.getMinPatientHospital();
        List<Patient> patientList = hospital.getPatients();
        patientList.add(patient);

        assignDoctorToPatient(hospital,patient);
    }
}
