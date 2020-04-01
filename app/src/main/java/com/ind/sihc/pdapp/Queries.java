package com.ind.sihc.pdapp;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Queries {

    public String patientName;
    public String patientAge;
    public String patientWeight;
    public String patientDescription;
    public String gender;
    public String condition;
    public String solution;
    public String doctorName;
    public String url;
    ImageView iv;

    String id;




    public Queries( String patientName, String patientAge, String patientWeight, String patientDescription, String gender, String condition,String solution,String doctorName,String url) {
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientWeight = patientWeight;
        this.patientDescription = patientDescription;
        this.gender = gender;
        this.condition = condition;
        this.solution = solution;
        this.doctorName = doctorName;
        this.url = url;





        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Queries/Patients");
        this.id = ref.push().getKey();

        ref.child(this.id).setValue(this);
    }

    public Queries() {

    }



    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public void setPatientWeight(String patientWeight) {
        this.patientWeight = patientWeight;
    }

    public void setPatientDescription(String patientDescription) {
        this.patientDescription = patientDescription;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public String getPatientWeight() {
        return patientWeight;
    }

    public String getPatientDescription() {
        return patientDescription;
    }

    public String getGender() {
        return gender;
    }

    public String getCondition() {
        return condition;
    }

    public String getSolution() {
        return solution;
    }

    public String getId() {
        return id;
    }
}

