package com.ind.sihc.pdapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    CircleImageView doctorLogo, patientLogo, registerLogo;
    ImageView btnDrLogin, btnRegister, btnPLogin;
    LinearLayout doctorLogin, register, patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        doctorLogo = findViewById(R.id.doctorLogo);
        patientLogo = findViewById(R.id.patientLogo);
        registerLogo = findViewById(R.id.registerLogo);
        btnDrLogin = findViewById(R.id.btnDrLogin);
        doctorLogin = findViewById(R.id.doctorLogin);
        btnRegister = findViewById(R.id.btnRegister);
        register = findViewById(R.id.register);
        btnPLogin = findViewById(R.id.btnPLogin);
        patient = findViewById(R.id.patient);


        final Animation lt = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_translate);
        doctorLogo.startAnimation(lt);
        registerLogo.startAnimation(lt);

        final Animation rt = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_translate);
        patientLogo.startAnimation(rt);

        final Animation f = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        btnDrLogin.startAnimation(f);
        btnRegister.startAnimation(f);
        btnPLogin.startAnimation(f);

        doctorLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LoginActivityD.class);
                startActivity(i);
                finish();
            }
        });

        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LoginActivityP.class);
                startActivity(i);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), RegisterActivityP.class);
                startActivity(i);
            }
        });

    }
}
