package com.ind.sihc.pdapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Patient {
    String parentName;
    String parentEmail;
    String parentContact;
    String childName;
    String childGender;
    String childDOB;
    String password;
    String bloodGroup;
    String id;

    public Patient(String parentName, String parentEmail, String parentContact, String childName, String childDOB, String childGender, String bloodGroup, String password) {
        this.parentName = parentName;
        this.parentEmail = parentEmail;
        this.parentContact = parentContact;
        this.childName = childName;
        this.childDOB = childDOB;
        this.password = password;
        this.childGender = childGender;
        this.bloodGroup = bloodGroup;

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        this.id = ref.push().getKey();
        ref.child("Users/Patients/" + this.id).setValue(this);
    }
}
