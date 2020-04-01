package com.ind.sihc.pdapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class QueryActivityD extends AppCompatActivity {

    TextView tvPatientConditionf,tvPatientNamef,tvPatientAgef,tvPatientWeightf,tvPatientGenderf,tvPatientDescriptionf;
    EditText etDiagnosis;

    TextView tvPredictedDisease, tvPredictedDiseaseA;
    CheckBox cbPredict;
    ImageView ivPatientSkinImage;

    Button btnDiagnosis;
    DatabaseReference ref;
    FirebaseUser mRoofRef;
    StorageReference mStorage;
    public static String userId;
    FirebaseAuth mAuth;
    FirebaseDatabase database;

    ArrayAdapter<String> adapter;

    List<String> QueryList;
    Queries quer;

    DatabaseReference rootRef;
    String currentUserID;

    //MODEL VARS
    private static final String MODEL_PATH = "optimized_graph.lite";
    private static final boolean QUANT = false;
    private static final String LABEL_PATH = "labels.txt";
    private static final int INPUT_SIZE = 224;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    //static final int REQUEST_TAKE_PHOTO = 1;
    Uri photoURI;
    File photoFile;
    String mCurrentPhotoPath;
    Bitmap bitmap;

    private Classifier classifier;

    private Executor executor = Executors.newSingleThreadExecutor();
    private TextView textViewResult;
    private Button btnDetectObject, btnSendPic;
    ProgressBar pgsBar;
    LinearLayout layout;
    TextView tvPatientN;
    TextView tvPatientAge;
    TextView tvPatientWeight;
    TextView tvPatientCondition;
    TextView tvGender;
    TextView tvPatientDescription;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_d);

        //GET ALL LABELS
        tvPatientN=findViewById(R.id.tvPatientName);
        tvPatientAge=findViewById(R.id.tvPatientName);
        tvPatientWeight=findViewById(R.id.tvPatientWeight);
        tvPatientCondition=findViewById(R.id.tvPatientName);
        tvGender=findViewById(R.id.tvGender);
        tvPatientDescription=findViewById(R.id.tvPatientDescription);
        tvPredictedDisease=findViewById(R.id.tvPredictedDisease);
        cbPredict= findViewById(R.id.cbPredict);
        etDiagnosis=findViewById(R.id.etDiagnosis);
        btnDiagnosis=findViewById(R.id.btnDiagnosis);

        //GET ALL TEXTVIEWS
        tvPatientConditionf = findViewById(R.id.tvPatientConditionf);
        tvPatientNamef = findViewById(R.id.tvPatientNamef);
        tvPatientAgef = findViewById(R.id.tvPatientAgef);
        tvPatientWeightf = findViewById(R.id.tvPatientWeightf);
        tvPatientGenderf = findViewById(R.id.tvPatientGenderf);
        tvPatientDescriptionf = findViewById(R.id.tvPatientDescriptionf);
        tvPatientDescriptionf.setMovementMethod(new ScrollingMovementMethod());


        ivPatientSkinImage = findViewById(R.id.ivPatientSkinImage);
        tvPredictedDisease = findViewById(R.id.tvPredictedDisease);
        tvPredictedDiseaseA = findViewById(R.id.tvPredictedDiseaseA);
        cbPredict = findViewById(R.id.cbPredict);
        rootRef = FirebaseDatabase.getInstance().getReference();
        mAuth=FirebaseAuth.getInstance();
        Log.d("mAuth : : : : ",mAuth.getCurrentUser().toString());
        currentUserID = mAuth.getCurrentUser().getUid();

        etDiagnosis = findViewById(R.id.etDiagnosis);
        //btnDiagnosis = findViewById(R.id.btnDiagnosis);
        initTensorFlowAndLoadModel();

        Intent i=getIntent();
        final int index=Integer.parseInt(i.getStringExtra("index"));
        // Toast.makeText(this, ""+index, Toast.LENGTH_SHORT).show();

        pgsBar =  (ProgressBar)findViewById(R.id.progressBar4);
        pgsBar.setVisibility(View.VISIBLE);

//        //HIDE ALL VIEWS
//        tvPatientN.setVisibility(View.GONE);
//        tvPatientAge.setVisibility(View.GONE);
//        tvPatientWeight.setVisibility(View.GONE);
//        tvPatientCondition.setVisibility(View.GONE);
//        tvGender.setVisibility(View.GONE);
//        tvPatientDescription.setVisibility(View.GONE);
//        tvPredictedDisease.setVisibility(View.GONE);
//        cbPredict.setVisibility(View.GONE);
//        etDiagnosis.setVisibility(View.GONE);
//        btnDiagnosis.setVisibility(View.GONE);
//        //DATA FIELDS
//        tvPatientNamef.setVisibility(View.GONE);
//        tvPatientAgef.setVisibility(View.GONE);
//        tvPatientWeightf.setVisibility(View.GONE);
//        tvPatientConditionf.setVisibility(View.GONE);
//        tvPatientGenderf.setVisibility(View.GONE);
//        tvPatientDescriptionf.setVisibility(View.GONE);
//        tvPredictedDiseaseA.setVisibility(View.GONE);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Queries/Patients");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int x = index;
                String urlll = "";
                for (DataSnapshot i : dataSnapshot.getChildren())
                {
                    if (x == 0) {
                        quer = i.getValue(Queries.class);
                        urlll=quer.getUrl();
                        new DownloadImage().execute(urlll);
                        tvPatientConditionf.setText(quer.getCondition());
                        tvPatientNamef.setText(quer.getPatientName());
                        tvPatientAgef.setText(quer.getPatientAge());
                        tvPatientWeightf.setText(quer.getPatientWeight());
                        tvPatientDescriptionf.setText(quer.getPatientDescription());
                        tvPatientGenderf.setText(quer.getGender());
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

        btnDiagnosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Diagnosis = etDiagnosis.getText().toString();
                rootRef.child("Queries/Patients").child(currentUserID).setValue(Diagnosis).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())  {
                            Toast.makeText(QueryActivityD.this, "Send", Toast.LENGTH_SHORT).show(); }
                        else {
                            String message = task.getException().toString();
                            Toast.makeText(QueryActivityD.this, message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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
            pgsBar.setVisibility(View.GONE);
            //UNHIDE LABELS
//            pgsBar.setVisibility(View.GONE);
//            tvPatientN.setVisibility(View.GONE);
//            tvPatientAge.setVisibility(View.GONE);
//            tvPatientWeight.setVisibility(View.GONE);
//            tvPatientCondition.setVisibility(View.GONE);
//            tvGender.setVisibility(View.GONE);
//            tvPatientDescription.setVisibility(View.GONE);
//            tvPredictedDisease.setVisibility(View.GONE);
//            cbPredict.setVisibility(View.GONE);
//            etDiagnosis.setVisibility(View.GONE);
//            btnDiagnosis.setVisibility(View.GONE);
//            //DATA FIELDS
//            tvPatientNamef.setVisibility(View.GONE);
//            tvPatientAgef.setVisibility(View.GONE);
//            tvPatientWeightf.setVisibility(View.GONE);
//            tvPatientConditionf.setVisibility(View.GONE);
//            tvPatientGenderf.setVisibility(View.GONE);
//            tvPatientDescriptionf.setVisibility(View.GONE);
//            tvPredictedDiseaseA.setVisibility(View.GONE);



            tvPatientNamef.setEnabled(true);
            Toast.makeText(getApplicationContext(),"Got",Toast.LENGTH_SHORT).show();
            if(result==null)
                Toast.makeText(getApplicationContext(),"No image",Toast.LENGTH_SHORT).show();
            else{
                result = Bitmap.createScaledBitmap(result, INPUT_SIZE, INPUT_SIZE, false);
                Log.d("////////////",result.toString());
                final List<Classifier.Recognition> results = classifier.recognizeImage(result);
                tvPredictedDiseaseA.setText(results.get(0).toString().substring(3));
            }
            // Close progressdialog
            //mProgressDialog.dismiss();
        }
    }

    private void initTensorFlowAndLoadModel() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    classifier = TensorFlowImageClassifier.create(
                            getAssets(),
                            MODEL_PATH,
                            LABEL_PATH,
                            INPUT_SIZE,
                            QUANT);

                } catch (final Exception e) {
                    throw new RuntimeException("Error initializing TensorFlow!", e);
                }
            }
        });
    }
}
