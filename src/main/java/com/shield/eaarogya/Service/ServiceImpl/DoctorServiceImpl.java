package com.shield.eaarogya.Service.ServiceImpl;

import com.shield.eaarogya.DTO.DoctorDetails;
import com.shield.eaarogya.Entity.Department;
import com.shield.eaarogya.Entity.Doctor;
import com.shield.eaarogya.Repository.DoctorRepository;
import com.shield.eaarogya.Service.DepartmentService;
import com.shield.eaarogya.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DoctorRepository doctorRepository;

    // --------------------------------- Add Doctor to Database -------------------------------------
    @Override
    public DoctorDetails addDoctor(DoctorDetails doctorDetails) {

        Department department = departmentService.getDepartmentByName(doctorDetails.getDepartmentName());

        Doctor doctor = new Doctor(doctorDetails.getTitle(),
                doctorDetails.getFirstName(), doctorDetails.getLastName(),
                doctorDetails.getEmail(), doctorDetails.getRegistration_number(),
                doctorDetails.getDob(), doctorDetails.getGender(),
                doctorDetails.getAddr(), doctorDetails.getCity(),
                doctorDetails.getPincode(), department,doctorDetails.getPassword());

        doctorRepository.save(doctor);
        return doctorDetails;
    }

    @Override
    public List<DoctorDetails> getAllDoctors() {

        List<Doctor> doctorList = doctorRepository.findAll();

        List<DoctorDetails> doctorDetailsList = new ArrayList<DoctorDetails>();

        for(Doctor doctor: doctorList) {
            doctorDetailsList.add(new DoctorDetails(doctor.getDoctorId(),
                    doctor.getTitle(), doctor.getFirstName(),
                    doctor.getLastName(), doctor.getEmail(),
                    doctor.getRegistration_number(), doctor.getDob(),
                    doctor.getGender(), doctor.getAddr(), doctor.getCity(),
                    doctor.getPincode(), doctor.getDepartment().getDepartmentName(),doctor.getPassword()));
        }

        return doctorDetailsList;
    }

    @Override
    public void login(String email, String password) {
        Doctor user = doctorRepository.findByEmail(email);

        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid email or password");
        }
    }

    @Override
    public DoctorDetails findByEmail(String email) {
        Doctor doctor = doctorRepository.findByEmail(email);

        return new DoctorDetails(doctor.getDoctorId(),
                doctor.getTitle(), doctor.getFirstName(),
                doctor.getLastName(), doctor.getEmail(),
                doctor.getRegistration_number(),
                doctor.getDob(), doctor.getGender(),
                doctor.getAddr(), doctor.getCity(),
                doctor.getPincode(),
                doctor.getDepartment().getDepartmentName());
    }


}
