package com.ind.sihc.pdapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ListItemActivityD extends AppCompatActivity {

    TextView tvPatientField1, tvPatientField1A;
    TextView tvPatientField2, tvPatientField2A;
    TextView tvPatientField3, tvPatientField3A;
    TextView tvPatientField4, tvPatientField4A;
    TextView tvPatientField5, tvPatientField5A;
    TextView tvPatientField6, tvPatientField6A;
    TextView tvPatientField7, tvPatientField7A;
    TextView tvPatientField8, tvPatientField8A;
    TextView tvPatientField9, tvPatientField9A;
    TextView tvPredictedDisease, tvPredictedDiseaseA;
    CheckBox cbPredict;
    ImageView ivPatientSkinImage;
    EditText etDiagnosis;
    Button btnDiagnosis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item_d);

        tvPatientField1 = findViewById(R.id.tvPatientField1);
        tvPatientField1A = findViewById(R.id.tvPatientField1A);
        tvPatientField2 = findViewById(R.id.tvPatientField2);
        tvPatientField2A = findViewById(R.id.tvPatientField2A);
        tvPatientField3 = findViewById(R.id.tvPatientField3);
        tvPatientField3A = findViewById(R.id.tvPatientField3A);
        tvPatientField4 = findViewById(R.id.tvPatientField4);
        tvPatientField4A = findViewById(R.id.tvPatientField4A);
        tvPatientField5 = findViewById(R.id.tvPatientField5);
        tvPatientField5A = findViewById(R.id.tvPatientField5A);
        tvPatientField6 = findViewById(R.id.tvPatientField6);
        tvPatientField6A = findViewById(R.id.tvPatientField6A);
        tvPatientField7 = findViewById(R.id.tvPatientField7);
        tvPatientField7A = findViewById(R.id.tvPatientField7A);
        tvPatientField8 = findViewById(R.id.tvPatientField8);
        tvPatientField8A = findViewById(R.id.tvPatientField8A);
        tvPatientField9 = findViewById(R.id.tvPatientField9);
        tvPatientField9A = findViewById(R.id.tvPatientField9A);

        ivPatientSkinImage = findViewById(R.id.ivPatientSkinImage);
        tvPredictedDisease = findViewById(R.id.tvPredictedDisease);
        tvPredictedDiseaseA = findViewById(R.id.tvPredictedDiseaseA);
        cbPredict = findViewById(R.id.cbPredict);

        etDiagnosis = findViewById(R.id.etDiagnosis);
        btnDiagnosis = findViewById(R.id.btnDiagnosis);
    }
}
