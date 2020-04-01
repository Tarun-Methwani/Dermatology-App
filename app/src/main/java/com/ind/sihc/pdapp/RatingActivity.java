package com.ind.sihc.pdapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class RatingActivity extends AppCompatActivity {
    RatingBar rabApp;
    TextView tvRating;
    Button btnSubmit,btnShare;
    String msg;

    int rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        rabApp=(RatingBar)findViewById(R.id.rabApp);
        tvRating=(TextView)findViewById(R.id.tvRating);
        btnShare=(Button)findViewById(R.id.btnShare);
        btnSubmit=(Button)findViewById(R.id.btnSubmit);
        int orientation= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(orientation);



        tvRating.setText(msg);
        rabApp.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                rating = (int) rabApp.getRating();
                if(rating==1)
                {
                    msg="POOR";
                    tvRating.setText(msg);
                    tvRating.setTextColor(Color.RED);


                }
                else if(rating==2)
                {
                    msg="OK OK";
                    tvRating.setText(msg);
                    tvRating.setTextColor(Color.BLUE);
                }
                else if(rating==3)
                {
                    msg="AVERAGE";
                    tvRating.setText(msg);
                    tvRating.setTextColor(Color.MAGENTA);
                }



                else if(rating==4)
                {
                    msg="GOOD";
                    tvRating.setText(msg);
                    tvRating.setTextColor(Color.BLUE);
                }


                else
                {
                    msg="EXCELLENT";
                    tvRating.setText(msg);
                    tvRating.setTextColor(Color.GREEN);
                }


                // Toast.makeText(RatingActivity.this, ""+rating, Toast.LENGTH_SHORT).show();

            }
        });





        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,"Here is my review of IndiaNeoDesign App According to me this App performance is "+msg+" Rating is "+rating +"stars");
                startActivity(i);

            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("sms:"+"9999999999"));
                i.putExtra("sms_body",msg+" Rating is "+ rating +" stars");
                startActivity(i);


            }
        });


    }
}

