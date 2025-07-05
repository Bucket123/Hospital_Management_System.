package com.acciojob.dhms.repository;

import com.acciojob.dhms.models.Hospital;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class HospitalRepository {

    HashMap<Integer, Hospital> hospitalDB;
    public HospitalRepository(){
        this.hospitalDB = new HashMap<>();
    }

    public void saveHospital(int id, Hospital hospital){
        hospitalDB.put(id,hospital);
    }
    public Hospital getHospital(int id){
        return hospitalDB.get(id);
    }

    public int totalHospital(){
        return hospitalDB.size();
    }
    public HashMap<Integer,Hospital> getAllHospitalL(){
        return hospitalDB;
    }
}
