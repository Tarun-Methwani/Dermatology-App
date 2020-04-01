package com.ind.sihc.pdapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Doctor {
    String name, regCouncil, email, password;
    String regYear;
    Long phone;
    String regNo, id;
    String gender;
    public Doctor() {
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Doctor(String name, String regCouncil, Long phone, String regNo, String regYear, String email, String password) {
        this.name = name;
        this.regCouncil = regCouncil;
        this.phone = phone;
        this.regNo = regNo;
        this.regYear = regYear;
        this.email = email;
        this.password = password;

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        this.id = ref.push().getKey();

        ref.child("Users/Doctors/" + this.id).setValue(this);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRegCouncil(String regCouncil) {
        this.regCouncil = regCouncil;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setRegYear(String regYear) {
        this.regYear = regYear;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
}