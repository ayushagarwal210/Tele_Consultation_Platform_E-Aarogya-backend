package com.shield.eaarogya.DTO;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/*
    This Class is to merge the department and doctor data and transfer it through the API
*/

public class DoctorDetails {

    private long doctorId;

    private String title;

    private String firstName;

    private String lastName;

    private String email;

    private String registration_number;

    @Temporal(TemporalType.DATE)
    private Date dob;

    private String gender;

    private String addr;

    private String city;

    private long pincode;

    private String departmentName;

    private String password;

//    private String description;

    // ---------------------------------- Constructors ----------------------------------


    public DoctorDetails() {
    }

    public DoctorDetails(long doctorId, String title, String firstName, String lastName, String email, String registration_number, Date dob, String gender, String addr, String city, long pincode, String departmentName) {
        this.doctorId = doctorId;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.registration_number = registration_number;
        this.dob = dob;
        this.gender = gender;
        this.addr = addr;
        this.city = city;
        this.pincode = pincode;
        this.departmentName = departmentName;
    }

    public DoctorDetails(long doctorId, String title, String firstName, String lastName, String email, String registration_number, Date dob, String gender, String addr, String city, long pincode, String departmentName,String password) {
        this.doctorId = doctorId;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.registration_number = registration_number;
        this.dob = dob;
        this.gender = gender;
        this.addr = addr;
        this.city = city;
        this.pincode = pincode;
        this.departmentName = departmentName;
        this.password=password;
    }

    // ----------------------------------- Getters and Setters --------------------------------------


    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
// ------------------------------- toString() method -------------------------------


    @Override
    public String toString() {
        return "DoctorDetails{" +
                "doctorId=" + doctorId +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", registration_number='" + registration_number + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", addr='" + addr + '\'' +
                ", city='" + city + '\'' +
                ", pincode=" + pincode +
                ", departmentName='" + departmentName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
