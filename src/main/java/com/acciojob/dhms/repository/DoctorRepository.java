package com.acciojob.dhms.repository;

import com.acciojob.dhms.models.Doctor;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.HashMap;

@Repository
public class DoctorRepository {

    HashMap<Integer, Doctor> doctorDB;
    public DoctorRepository(){
        this.doctorDB = new HashMap<>();
    }

    public void saveDoctor(int id,Doctor doctor){
        doctorDB.put(id,doctor);
    }
    public Doctor getDoctorDetail(int id){
        return doctorDB.get(id);
    }
    public int totalDoctor(){
        return doctorDB.size();
    }

}
