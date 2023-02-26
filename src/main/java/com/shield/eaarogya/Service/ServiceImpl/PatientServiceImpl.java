package com.shield.eaarogya.Service.ServiceImpl;

import com.shield.eaarogya.Repository.PatientRepository;
import com.shield.eaarogya.DTO.PatientDetails;
import com.shield.eaarogya.Entity.Patient;
import com.shield.eaarogya.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // -------------------------- Testing DAO Layer --------------------------------------
    @Override
    public String testThis() {

        return "Till here it worked fine yeahhhhhhhhh!!";
    }

    @Override
    public List<Patient> getPatient() {
        return (List<Patient>) this.patientRepository.findAll();
    }

    @Override
    public Patient getPatientByPatientId(long patientId) {
        return patientRepository.findById(patientId).get();
    }

    public void register(Patient user) {

        patientRepository.save(user);
    }

    public void login(String email, String password) {
        Patient user = patientRepository.findByEmail(email);

        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid email or password");
        }
    }

    @Override
    public Patient findByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

}
