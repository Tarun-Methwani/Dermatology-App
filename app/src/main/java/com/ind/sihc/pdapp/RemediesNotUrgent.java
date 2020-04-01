package com.ind.sihc.pdapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class RemediesNotUrgent extends AppCompatActivity {

    TextView tvSymptoms,tvSolution;

    String sym = null;
    String sol =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remedies_not_urgent);

        tvSymptoms = findViewById(R.id.tvSymptoms);
        tvSolution = findViewById(R.id.tvSolution);

        Intent i = getIntent();
        sym = i.getStringExtra("symp1");
        sol = i.getStringExtra("sol1");
        if(!(sym==null))
        {
            tvSymptoms.setText(sym);
            tvSolution.setText(sol);
        }
        if(sym == null)
        {
            sym = i.getStringExtra("symp2");
            sol = i.getStringExtra("sol2");
            tvSymptoms.setText(sym);
            tvSolution.setText(sol);
        }
        if(sym == null)
        {
            sym = i.getStringExtra("symp3");
            sol = i.getStringExtra("sol3");
            tvSymptoms.setText(sym);
            tvSolution.setText(sol);
        }
        if(sym == null)
        {
            sym = i.getStringExtra("symp4");
            sol = i.getStringExtra("sol4");
            tvSymptoms.setText(sym);
            tvSolution.setText(sol);
        }
        if(sym == null)
        {
            sym = i.getStringExtra("symp5");
            sol = i.getStringExtra("sol5");
            tvSymptoms.setText(sym);
            tvSolution.setText(sol);
        }
        if(sym == null)
        {
            sym = i.getStringExtra("symp6");
            sol = i.getStringExtra("sol6");
            tvSymptoms.setText(sym);
            tvSolution.setText(sol);
        }
        if(sym == null)
        {
            sym = i.getStringExtra("symp7");
            sol = i.getStringExtra("sol7");
            tvSymptoms.setText(sym);
            tvSolution.setText(sol);
        }
        if(sym == null)
        {
            sym = i.getStringExtra("symp8");
            sol = i.getStringExtra("sol8");
            tvSymptoms.setText(sym);
            tvSolution.setText(sol);
        }
        if(sym == null)
        {
            sym = i.getStringExtra("symp9");
            sol = i.getStringExtra("sol9");
            tvSymptoms.setText(sym);
            tvSolution.setText(sol);
        }
        if(sym == null)
        {
            sym = i.getStringExtra("symp10");
            sol = i.getStringExtra("sol10");
            tvSymptoms.setText(sym);
            tvSolution.setText(sol);
        }
        if(sym == null)
        {
            sym = i.getStringExtra("symp11");
            sol = i.getStringExtra("sol11");
            tvSymptoms.setText(sym);
            tvSolution.setText(sol);
        }
        if(sym == null)
        {
            sym = i.getStringExtra("symp12");
            sol = i.getStringExtra("sol12");
            tvSymptoms.setText(sym);
            tvSolution.setText(sol);
        }
    }
}
