package com.ind.sihc.pdapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class BabyNotification extends AppCompatActivity {

    TextView tvNoti;
    RadioGroup rgNoti;
    String a1;
    Button btnSubmit;
    RadioButton rbtnYes,rbtnNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_notification);

//        rgNoti=findViewById(R.id.rgNoti);
//        tvNoti=findViewById(R.id.tvNotification);
//
//        int id1 = rgNoti.getCheckedRadioButtonId();
//        RadioButton rbtnYes = rgNoti.findViewById(id1);
//        a1 = rbtnYes.getText().toString();
//        btnSubmit=findViewById(R.id.btnSubmit);
//
//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(a1.equals("Yes"))
//                {
//                    Intent i=new Intent(getApplicationContext(),DashboardActivityP.class);
//                    startActivity(i);
//                    finish();
//                }
//                else
//                {
//                    Intent i=new Intent(getApplicationContext(),UrgentActivity.class);
//                    startActivity(i);
//                    finish();
//
//                }
//            }
//        });


    }
}
