package com.ind.sihc.pdapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardActivityP extends AppCompatActivity {

    FirebaseUser currenrUser;
    FirebaseAuth uAuth;
    SharedPreferences sp;
    Button btnPharmacy, btnDiagnosis, btnHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_p);


        sp = getSharedPreferences("p1", MODE_PRIVATE);
        uAuth= FirebaseAuth.getInstance();
        currenrUser=uAuth.getCurrentUser();

        btnDiagnosis=findViewById(R.id.btnDiagnosis);
        btnPharmacy=findViewById(R.id.btnPharmacy);
        btnHistory = findViewById(R.id.btnHistory);



        btnDiagnosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DiagnosisActivityP.class);
                startActivity(i);
//                Toast.makeText(getApplicationContext(), "Diagnosis", Toast.LENGTH_SHORT).show();
            }
        });


        btnPharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),PharamcyActivityP.class);
                startActivity(i);
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),RecordActivityP.class);
                startActivity(i);
            }
        });

        
    }
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("DO YOU WANT TO EXIT");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(1);

            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setNeutralButton("RATE US", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent inti=new Intent(DashboardActivityP.this,RatingActivity.class);
                startActivity(inti);
                finish();
            }
        });
        AlertDialog a = builder.create();
        a.setTitle("EXIT");
        a.show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(currenrUser == null)
        {
            sendUserToLoginActivity();
        }
    }

    private void sendUserToLoginActivity()
    {
        Intent i = new Intent(getApplicationContext(),LoginActivityP.class);
        startActivity(i);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.options,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId()==R.id.menuFindfriends)
        {

        }
        if(item.getItemId()==R.id.menuSetting)
        {
            Intent i=new Intent(DashboardActivityP.this,SettingActivityP.class);
            startActivity(i);
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
