package com.ind.sihc.pdapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardActivityD extends AppCompatActivity {

    Button btnPatientQueries, btnAboutUs;

    FirebaseUser currenrUser;
    FirebaseAuth uAuth;
    SharedPreferences sp;
    String email="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_d);

        Intent i =getIntent();
        email = i.getStringExtra("email");

        btnPatientQueries = findViewById(R.id.btnPatientQueries);
        btnAboutUs=findViewById(R.id.btnAboutUs);


        btnPatientQueries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PatientQueriesD.class);
                startActivity(i);

                Toast.makeText(getApplicationContext(), "Patient Queries", Toast.LENGTH_LONG).show();
            }
        });


        btnAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Help", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),AboutUsActivity.class);
                startActivity((i));
            }
        });
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        if(currenrUser==null)
//        {
//            sendUserToLoginActivity();
//        }
//    }
//
    private void sendUserToLoginActivity()
    {
        Intent i = new Intent(DashboardActivityD.this, LoginActivityD.class);
        startActivity(i);
        finish();
    }
//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.options,menu);
        return true;
    }
//
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId()==R.id.menuFindfriends)
        {

        }
        if(item.getItemId()==R.id.menuSetting)
        {
            Toast.makeText(DashboardActivityD.this, "Setting Activity", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.menuLogout)
        {
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("email", "");
            editor.apply();
            uAuth.signOut();
            sendUserToLoginActivity();
        }
        return  true;

    }
}
