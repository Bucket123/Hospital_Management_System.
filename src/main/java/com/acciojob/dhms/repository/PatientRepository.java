package com.acciojob.dhms.repository;

import com.acciojob.dhms.models.Patient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PatientRepository {

    HashMap<Integer, Patient> patientDB;
    public PatientRepository(){
        this.patientDB = new HashMap<>();
    }
    public void savePatient(int id, Patient patient){
        patientDB.put(id,patient);
    }
    public Patient getPatient(int id){
        return patientDB.get(id);
    }
    public int totalPatient(){
        return patientDB.size();
    }
}
