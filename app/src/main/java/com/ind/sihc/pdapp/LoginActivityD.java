package com.ind.sihc.pdapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivityD extends AppCompatActivity {
    EditText etEmail,etPassword;
    TextView tvForgetPassword;
    Button btnLogin;
    ProgressBar pbLogin;
    ImageView imgChild;
    FirebaseAuth uAuth;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_d);


        FirebaseApp.initializeApp(this);

        imgChild=findViewById(R.id.imgChild);
        etEmail=(EditText)findViewById(R.id.etEmail);
        etPassword=(EditText)findViewById(R.id.etPassword);
        tvForgetPassword=(TextView)findViewById(R.id.tvForgetPassword);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        uAuth=FirebaseAuth.getInstance();
        pbLogin=(ProgressBar)findViewById(R.id.pbLogin);
        pbLogin.setVisibility(View.GONE);

        sp = getSharedPreferences("p1", MODE_PRIVATE);
        String email = sp.getString("email", "");

        if (email.length() != 0)
        {
            Intent i =new Intent(LoginActivityD.this, DashboardActivityD.class);
            startActivity(i);
            finish();
        }
        else{
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    login();
                }
            });

            tvForgetPassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(LoginActivityD.this, ForgetPasswordActivityD.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(), "ForgetPasswordActivity", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
    private void login()
    {
        final String Email = etEmail.getText().toString().trim() + "d";
        final String Password = etPassword.getText().toString().trim();

        if (Email.isEmpty()) {
            etEmail.setError("Email Required");
            etEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            etEmail.setError("Enter a Valid Email-id");
            etEmail.requestFocus();
            return;
        }

        if (Password.isEmpty()) {
            etPassword.setError("Password Required");
            etPassword.requestFocus();
            return;
        }

        pbLogin.setVisibility(View.VISIBLE);
        uAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                pbLogin.setVisibility(View.GONE);
                if(task.isSuccessful())
                {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("email", Email);
                    editor.commit();
                    Intent i =new Intent(getApplicationContext(), DashboardActivityD.class);
                    i.putExtra("email",Email);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(LoginActivityD.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
