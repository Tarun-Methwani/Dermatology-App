package com.ind.sihc.pdapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PatientQueriesD extends AppCompatActivity implements View.OnClickListener {

    private ListView lv;
    DatabaseReference ref;
    FirebaseUser mRoofRef;
    StorageReference mStorage;
    public static String userId;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    ArrayAdapter<String> adapter;
    FirebaseStorage storage;

    List<String> QueryList;

//    List<Ret> QueryList;

    Queries quer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_queries_d);

        QueryList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.queries_list, R.id.queriesList,  QueryList);
        quer = new Queries();
        lv = (ListView) findViewById(R.id.lvForm);
        storage=FirebaseStorage.getInstance();
//        mStorage=storage.getReferenceFromUrl();
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Queries/Patients");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String urlll = "";
                for (DataSnapshot i : dataSnapshot.getChildren()) {
                    quer = i.getValue(Queries.class);
                    urlll = quer.getUrl();
                    Toast.makeText(PatientQueriesD.this, urlll, Toast.LENGTH_SHORT).show();
                   // new PatientQueriesD.DownloadImage().execute(urlll);
                    QueryList.add("Name: " + quer.getPatientName() + " " + "Age:" + " " + quer.getPatientAge() + "\n" + "Gender: " + quer.getGender());
                }
                Toast.makeText(PatientQueriesD.this, urlll, Toast.LENGTH_SHORT).show();
                lv.setAdapter(adapter);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PatientQueriesD.this, QueryActivityD.class);
                intent.putExtra("index", "" + position);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onClick(View v) {

    }


    private class DownloadImage extends AsyncTask<String,Void,Bitmap> {

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
            ImageView x = findViewById(R.id.imgDisease);
            //x.setImageBitmap(result);


            // Close progressdialog
            //mProgressDialog.dismiss();
        }
    }
}