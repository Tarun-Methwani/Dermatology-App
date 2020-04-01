package com.ind.sihc.pdapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
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

public class RecordActivityP extends AppCompatActivity {

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
        setContentView(R.layout.activity_record_p);
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
                    Toast.makeText(RecordActivityP.this, urlll, Toast.LENGTH_SHORT).show();
                    //new DownloadImage().execute(urlll);
                    QueryList.add("Name: " + quer.getPatientName() + "\n" + "Age:" + " " + quer.getPatientAge() + "\n" + "Gender: " + quer.getGender());
                }
                Toast.makeText(RecordActivityP.this, urlll, Toast.LENGTH_SHORT).show();
                lv.setAdapter(adapter);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(RecordActivityP.this, ResponseActivityP.class);
                intent.putExtra("index", "" + position);
                startActivity(intent);

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
        ImageView x=findViewById(R.id.imgDisease);
        //x.setImageBitmap(result);


        // Close progressdialog
        //mProgressDialog.dismiss();
    }
}
}

