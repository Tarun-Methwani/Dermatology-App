package com.ind.sihc.pdapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;

public class RegisterActivityP extends AppCompatActivity implements View.OnClickListener {

    EditText etParentName, etParentEmail, etParentContact, etChildName, etPassword, etConfirmPassword;
    TextView etChildDOB;
    Button btn_date, btnPatientRegister;
    Spinner spnBloodGroup;
    RadioGroup rgGender;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private FirebaseAuth auth;
    public static String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_p);

        etParentName = findViewById(R.id.etParentName);
        etParentEmail = findViewById(R.id.etParentEmail);
        etParentContact = findViewById(R.id.etParentContact);
        etChildName = findViewById(R.id.etChildName);
        etChildDOB = findViewById(R.id.etChildDOB);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btn_date = findViewById(R.id.btn_date);
        btnPatientRegister = findViewById(R.id.btnPatientRegister);
        spnBloodGroup = findViewById(R.id.spnBloodGroup);
        rgGender = findViewById(R.id.rgGender);
        auth = FirebaseAuth.getInstance();

        btnPatientRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String parentName = etParentName.getText().toString();
                String parentEmail = etParentEmail.getText().toString();
                String parentContact = etParentContact.getText().toString();
                String childName = etChildName.getText().toString();
                String childDOB = etChildDOB.getText().toString();
                String password = etPassword.getText().toString();
                int id = rgGender.getCheckedRadioButtonId();
                RadioButton rb = rgGender.findViewById(id);
                String gender = rb.getText().toString();
                String bloodGroup = spnBloodGroup.getSelectedItem().toString();

                Patient newPatient = new Patient(parentName, parentEmail, parentContact, childName, childDOB, gender, bloodGroup, password);
                Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();

                auth = FirebaseAuth.getInstance();
                FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                        if (firebaseUser != null) {
                            userId = firebaseUser.getUid();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "nahi aya", Toast.LENGTH_LONG).show();
                        }
                    }
                };

                Toast.makeText(getApplicationContext(), userId, Toast.LENGTH_LONG).show();
                auth.createUserWithEmailAndPassword(parentEmail, password)
                        .addOnCompleteListener(RegisterActivityP.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(RegisterActivityP.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(RegisterActivityP.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(RegisterActivityP.this, LoginActivityP.class));
                                    finish();
                                }
                            }
                        });
            }
        });

        btn_date.setOnClickListener(this);
    }//end of onCreate()

    @Override
    public void onClick(View v) {
        if (v == btn_date) {
            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    etChildDOB.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }
}
