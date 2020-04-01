package com.ind.sihc.pdapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DecideActivity extends AppCompatActivity {

    LinearLayout idAccept, idReject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decide);

        idAccept = findViewById(R.id.idAccept);
        idReject = findViewById(R.id.idReject);

        idAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Accepted", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        idReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Rejected", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
