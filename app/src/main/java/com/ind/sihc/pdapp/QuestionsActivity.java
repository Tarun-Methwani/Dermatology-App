package com.ind.sihc.pdapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {

    RadioGroup rgQ1,rgQ2,rgQ3,rgQ4;
    EditText etQ5;
    Button btnSubmit;
    TextView tvQ4;
    String condition,disease;
    String a1,a2,a3,a4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Intent i=getIntent();
        disease=i.getStringExtra("disease");
        Toast.makeText(this, disease, Toast.LENGTH_SHORT).show();

        btnSubmit=findViewById(R.id.btnSubmit);
        rgQ1=findViewById(R.id.rgQ1);
        rgQ2=findViewById(R.id.rgQ2);
        rgQ3=findViewById(R.id.rgQ3);
        rgQ4=findViewById(R.id.rgQ4);
        tvQ4=findViewById(R.id.tvQ4);




        etQ5=findViewById(R.id.etQ5);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                int id1 = rgQ1.getCheckedRadioButtonId();
                RadioButton rb1 = rgQ1.findViewById(id1);
                a1 = rb1.getText().toString();


                int id2 = rgQ2.getCheckedRadioButtonId();
                RadioButton rb2 = rgQ2.findViewById(id2);
                a2 = rb2.getText().toString();

                int id3 = rgQ3.getCheckedRadioButtonId();
                RadioButton rb3 = rgQ3.findViewById(id3);
                a3 = rb3.getText().toString();

                int id4 = rgQ4.getCheckedRadioButtonId();
                RadioButton rb4 = rgQ4.findViewById(id4);
                a4 = rb4.getText().toString();





    if (a1.equals("No") && a2.equals("No") && a3.equals("No") && (a4.equals("No"))) {

        condition = "not urgent";


    } else if (a1.equals("Yes") && a2.equals("Yes") && a3.equals("Yes") && (a4.equals("No") || a4.equals("Yes"))) {

        condition = "urgent";

    } else if ((a1.equals("No") || a1.equals("Yes")) && (a2.equals("No") || a2.equals("Yes")) && (a3.equals("No") || a3.equals("Yes")) && a4.equals("Yes")) {
        condition = " urgent";


    } else if (a1.equals("Yes") && (a2.equals("No") || a2.equals("Yes")) && (a3.equals("No") || a3.equals("Yes")) && (a4.equals("No") || a4.equals("Yes"))) {
        condition = "not urgent";


    } else if ((a1.equals("No") || a1.equals("Yes")) && a2.equals("Yes") && (a3.equals("No") || a3.equals("Yes")) && (a4.equals("Yes") || a4.equals("No"))) {
        condition = "not urgent";


    } else if (a1.equals("Yes") && (a2.equals("No") || a2.equals("Yes")) && (a3.equals("No") || a3.equals("Yes")) && a4.equals("Yes")) {
        condition = "not urgent";


    } else if ((a1.equals("No") || a1.equals("Yes")) && a2.equals("Yes") && (a3.equals("No") || a3.equals("Yes")) && a4.equals("Yes")) {
        condition = "not urgent";


    } else if ((a1.equals("No") || a1.equals("Yes")) && (a2.equals("No") || a2.equals("Yes")) && a3.equals("Yes") && a4.equals("Yes")) {
        condition = "not urgent";


    } else if ((a1.equals("No") || a1.equals("Yes")) && (a2.equals("No") || a2.equals("Yes")) && a3.equals("Yes") && (a4.equals("Yes") || a4.equals("No"))) {

        condition = "not urgent";


    } else {
        condition = "urgent";
    }

//




                if(condition.equals("urgent"))
                {

                    Toast.makeText(QuestionsActivity.this, "urgent", Toast.LENGTH_SHORT).show();
                    Intent ii=new Intent(getApplicationContext(),UrgentActivity.class);
                    ii.putExtra("disease",disease);
                    startActivity(ii);
                }
                else
                {
                    Toast.makeText(QuestionsActivity.this, "not urgent", Toast.LENGTH_SHORT).show();
                    Intent ik=new Intent(getApplicationContext(),QuestionSolutionActivity.class);
                    ik.putExtra("disease",disease);
                    startActivity(ik);

                }}
        });
    };
}














