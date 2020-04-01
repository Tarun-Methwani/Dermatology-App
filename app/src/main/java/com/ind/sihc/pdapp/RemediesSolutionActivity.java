package com.ind.sihc.pdapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RemediesSolutionActivity extends AppCompatActivity {
    TextView tvRemedies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remedies_solution);

        String rem = null;

        tvRemedies = findViewById(R.id.tvRemedies);
        Intent i = getIntent();
        rem = i.getStringExtra("rem");
        if(!(rem==null))
        {
            tvRemedies.setText(rem);

        }
        if(rem == null)
        {
            rem = i.getStringExtra("rem");

            tvRemedies.setText(rem);
        }
    }
}
