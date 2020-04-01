package com.ind.sihc.pdapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackActivity extends AppCompatActivity {

    EditText patientName;
    Button btnSubmit;
    EditText anySuggestions;


    float rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        patientName=findViewById(R.id.etpatientName);
        btnSubmit=findViewById(R.id.btnSubmit);
        final RatingBar ratingBar = findViewById(R.id.ratingBar);
        anySuggestions=findViewById(R.id.anySuggestions);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rating = ratingBar.getRating();

                String r1 = String.format("%f",rating);
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("FeedBack");

                FeedBack feedBack = new FeedBack(patientName.getText().toString(),r1,anySuggestions.getText().toString());
                databaseReference.push().setValue(feedBack);

                Toast.makeText(getApplicationContext(), "Rating is"+rating, Toast.LENGTH_SHORT).show();




            }
        });


    }
}
