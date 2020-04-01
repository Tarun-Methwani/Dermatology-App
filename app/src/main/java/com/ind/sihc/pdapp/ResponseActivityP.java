package com.ind.sihc.pdapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.locks.Condition;

public class ResponseActivityP extends AppCompatActivity {
    // hello

    TextView tvPatientConditionf,tvPatientNamef,tvPatientAgef,tvPatientWeightf,tvPatientGenderf,tvPatientDescriptionf,tvDoctorNamef,tvDoctorDiagnosisf;
    DatabaseReference ref;
    FirebaseUser mRoofRef;
    StorageReference mStorage;
    public static String userId;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    Button btnChat;
    ArrayAdapter<String> adapter;
    ImageView ivPatientSkinImage;
    List<String> QueryList;
    Queries quer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response_p);
        ivPatientSkinImage = findViewById(R.id.ivPatientSkinImage);
        tvPatientConditionf=findViewById(R.id.tvPatientConditionf);
        tvPatientNamef=findViewById(R.id.tvPatientNamef);
        tvPatientAgef=findViewById(R.id.tvPatientAgef);
        tvPatientWeightf=findViewById(R.id.tvPatientWeightf);
        tvPatientGenderf=findViewById(R.id.tvPatientGenderf);
        tvPatientDescriptionf=findViewById(R.id.tvPatientDescriptionf);
        tvDoctorNamef=findViewById(R.id.tvDoctorNamef);
        tvDoctorDiagnosisf=findViewById(R.id.tvDoctorDiagnosisf);

         Intent i=getIntent();
         final int index=Integer.parseInt(i.getStringExtra("index"));
        Toast.makeText(this, ""+index, Toast.LENGTH_SHORT).show();

        database=FirebaseDatabase.getInstance();
        ref=database.getReference("Queries/Patients");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int x = index;

                String urlll = "";
                for(DataSnapshot i:dataSnapshot.getChildren())
                {
                    if (x == 0)
                    {

                        quer=i.getValue(Queries.class);
                        urlll = quer.getUrl();
                        Toast.makeText(getApplicationContext(), urlll, Toast.LENGTH_SHORT).show();
                        new DownloadImage().execute(urlll);
                        tvPatientConditionf.setText(quer.getCondition());
                        tvPatientNamef.setText(quer.getPatientName());

                        tvPatientAgef.setText(quer.getPatientAge());

                        tvPatientWeightf.setText(quer.getPatientWeight());

                        tvPatientDescriptionf.setText(quer.getPatientDescription());
                        tvPatientGenderf.setText(quer.getGender());

                        tvDoctorNamef.setText(quer.getDoctorName());
                        tvDoctorDiagnosisf.setText(quer.getSolution());

                        break;
                    }
                    else {
                        x--;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }

    private class DownloadImage extends AsyncTask<String,Void,Bitmap>
    {

        @Override
        protected Bitmap doInBackground(String... URL) {

            String imageURL = URL[0];

            Bitmap bitmap = null;
            try {
                // Download Image from URL
                InputStream input = new java.net.URL(imageURL).openStream();
                // Decode Bitmap
                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // Set the bitmap into ImageView
            ivPatientSkinImage.setImageBitmap(result);


            // Close progressdialog
            //mProgressDialog.dismiss();
        }
    }




}
