package com.acciojob.dhms.service;

import com.acciojob.dhms.models.Hospital;
import com.acciojob.dhms.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class HospitalService {
    @Autowired
    HospitalRepository hospitalRepository;

    public void saveHospitalDetail(Hospital hospital){
        int id = hospitalRepository.totalHospital()+1;
        hospital.setId(id);
        hospitalRepository.saveHospital(id,hospital);
    }

    public Hospital getHospitalDetail(int id){
        return hospitalRepository.getHospital(id);
    }

    public List<Hospital> getAllHospitalList(){
        HashMap<Integer,Hospital> list = hospitalRepository.getAllHospitalL();
        List<Hospital> hospitals = new ArrayList<>();
        for(int key: list.keySet())
        {
            hospitals.add(list.get(key));
        }
        return hospitals;
    }

    public Hospital getMinDoctorHospital(){
        List<Hospital> hospitals = getAllHospitalList();
        Hospital ans = null;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<hospitals.size(); i++)
        {
            Hospital hospital = hospitals.get(i);
            if(hospital.getDoctors().size() < min)
            {
                min = hospital.getDoctors().size();
                ans = hospital;
            }
        }
        return ans;
    }
}
