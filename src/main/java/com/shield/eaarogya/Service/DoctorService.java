package com.shield.eaarogya.Service;

import com.shield.eaarogya.DTO.DoctorDetails;

import java.util.List;

public interface DoctorService {

    public DoctorDetails addDoctor(DoctorDetails doctorDetails);

    public List<DoctorDetails> getAllDoctors();

    public void login(String email,String password);

    public DoctorDetails findByEmail(String email);
}
