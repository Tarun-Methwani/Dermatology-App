package com.ind.sihc.pdapp;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DiagnosisActivityP extends AppCompatActivity {

    ImageView ivImageToUpload;

    TextView tvPatientName,tvPatientAge,tvCondition,tvWeight,tvDescription,tvPatientGender;
    EditText etPatientName,etPatientAge,etWeight,etDescription;
    RadioGroup rgPatientGender,rgCondition;
    Button btnSend;
    DatabaseReference ref;
    public static String userId;
    ProgressDialog mProgress;
    Bitmap photo;
    private FirebaseAuth auth;
    Button btnCamera, btnGallery;
    private ProgressBar mProgressBar;
    private Uri mImageUri;
    String solution= "NA";
    String doctorName= "NA";
    FirebaseUser mRoofRef;
    public String urlf;
    private StorageReference mStorageRef;

    private DatabaseReference mDatabaseRef;
    private StorageTask mUploadTask;
    private Classifier classifier;
    private static final String MODEL_PATH = "optimized_graph.lite";
    private static final boolean QUANT = false;
    private static final String LABEL_PATH = "labels.txt";
    private static final int INPUT_SIZE = 224;
    String disease;

    private Executor executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis_p);

        initTensorFlowAndLoadModel();
        ivImageToUpload = findViewById(R.id.ivImageToUpload);
        btnCamera = findViewById(R.id.btnCamera);
        btnGallery = findViewById(R.id.btnGallery);
        //mProgressBar = findViewById(R.id.progress_bar);
        btnSend = findViewById(R.id.btnSend);
        tvPatientName=findViewById(R.id.tvPatientName);
        tvPatientAge=findViewById(R.id.tvPatientAge);
        tvWeight=findViewById(R.id.tvWeight);
        tvCondition=findViewById(R.id.tvCondition);
        tvDescription=findViewById(R.id.tvDescription);
        tvPatientGender=findViewById(R.id.tvPatientGender);
        etPatientName=findViewById(R.id.etPatientName);
        etPatientAge=findViewById(R.id.etPatientAge);
        etWeight=findViewById(R.id.etWeight);
        etDescription=findViewById(R.id.etDescription);

        rgPatientGender=findViewById(R.id.rgPatientGender);
        rgCondition=findViewById(R.id.rgCondition);

        auth = FirebaseAuth.getInstance();

        mStorageRef = FirebaseStorage.getInstance().getReference("uploads");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = ((BitmapDrawable)ivImageToUpload.getDrawable()).getBitmap();
                if(bitmap==null){
                    Toast.makeText(getApplicationContext(),"no image",Toast.LENGTH_LONG).show();
                }
                else{
//                    bitmap = Bitmap.createScaledBitmap(bitmap, INPUT_SIZE, INPUT_SIZE, false);
//                    Log.d("////////////",bitmap.toString());
//                    final List<Classifier.Recognition> results = classifier.recognizeImage(bitmap);
//                    String s=results.get(0).toString();
//                    disease=results.get(0).toString().substring(0,s.indexOf('(')).substring(3);
//                    Toast.makeText(getApplicationContext(),disease,Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(i, 456);
                }
            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 2);
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = ((BitmapDrawable)ivImageToUpload.getDrawable()).getBitmap();
                if(bitmap==null){
                    Toast.makeText(getApplicationContext(),"no image",Toast.LENGTH_LONG).show();
                }
                else{
                    bitmap = Bitmap.createScaledBitmap(bitmap, INPUT_SIZE, INPUT_SIZE, false);
                    Log.d("////////////",bitmap.toString());
                    final List<Classifier.Recognition> results = classifier.recognizeImage(bitmap);
                    String s=results.get(0).toString();
                    disease=results.get(0).toString().substring(0,s.indexOf('(')).substring(3);

                    Intent i= new Intent(getApplicationContext(),QuestionsActivity.class);
                    i.putExtra("disease",disease);
                    startActivity(i);

                }

                    uploadFile();
                    Toast.makeText(DiagnosisActivityP.this, mImageUri.toString(), Toast.LENGTH_SHORT).show();
                    int SelectGender=rgPatientGender.getCheckedRadioButtonId();
                    int SelectCondition=rgCondition.getCheckedRadioButtonId();
                    String PatientName=etPatientName.getText().toString();
                    String PatientAge=etPatientAge.getText().toString();
                    String PatientWeight=etWeight.getText().toString();
                    String PatientDescription=etDescription.getText().toString();
                    RadioButton radioGender=(RadioButton)findViewById(SelectGender);
                    String Gender=radioGender.getText().toString();
                    RadioButton radioCondition=(RadioButton)findViewById(SelectCondition);
                    String Condition=radioCondition.getText().toString();
                    auth = FirebaseAuth.getInstance();
                    FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
                        @Override
                        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                            if (firebaseUser != null) {
                                userId = firebaseUser.getUid();
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "nahi aya", Toast.LENGTH_LONG).show();
                            }
                        }
                    };
//                    Queries query = new Queries(PatientName,PatientAge,PatientWeight,PatientDescription,Gender,Condition,solution,doctorName,urlf);
//                    Intent i=new Intent(DiagnosisActivityP.this,QuestionsActivity.class);
//                    startActivity(i);

            }
        });

    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void uploadFile() {
        if (mImageUri != null) {
            StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(mImageUri));

            mUploadTask = fileReference.putFile(mImageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // mProgressBar.setProgress(0);
                                }
                            }, 500);


                            taskSnapshot.getMetadata().getReference().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    Upload imageUpload = new Upload(uri.toString());
//                                   urlf = "N/A";
                                    urlf=uri.toString();
                                    int SelectGender=rgPatientGender.getCheckedRadioButtonId();
                                    int SelectCondition=rgCondition.getCheckedRadioButtonId();
                                    String PatientName=etPatientName.getText().toString();
                                    String PatientAge=etPatientAge.getText().toString();
                                    String PatientWeight=etWeight.getText().toString();
                                    String PatientDescription=etDescription.getText().toString();
                                    RadioButton radioGender=(RadioButton)findViewById(SelectGender);
                                    String Gender=radioGender.getText().toString();
                                    RadioButton radioCondition=(RadioButton)findViewById(SelectCondition);
                                    String Condition=radioCondition.getText().toString();
                                    auth = FirebaseAuth.getInstance();
                                    FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
                                        @Override
                                        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                                            if (firebaseUser != null) {
                                                userId = firebaseUser.getUid();
                                            }
                                            else {
                                                Toast.makeText(getApplicationContext(), "nahi aya", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    };
                                    Queries query = new Queries(PatientName,PatientAge,PatientWeight,PatientDescription,Gender,Condition,solution,doctorName,urlf
                                    );
                                    Intent i=new Intent(DiagnosisActivityP.this,QuestionsActivity.class);
                                    startActivity(i);

                                    // Wrap with Uri.parse() when retrieving
                                    Toast.makeText(getApplicationContext(), uri.toString(), Toast.LENGTH_LONG).show();

                                    String uploadId = mDatabaseRef.push().getKey();


                                    mDatabaseRef.child(uploadId).setValue(imageUpload);
                                }
                            });

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            // mProgressBar.setProgress((int) progress);
                        }
                    });
        } else {
            Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
//            mImageUri = data.getData();
//            Toast.makeText(getApplicationContext(), "" + mImageUri, Toast.LENGTH_SHORT).show();
//            Picasso.get().load(mImageUri).into(ivImageToUpload);
//        }
//        else
            if (requestCode == 456 && resultCode == RESULT_OK) {
//            photo = (Bitmap) data.getExtras().get("data");
//            ivImageToUpload.setImageBitmap(photo);
//            mImageUri = getImageUri(getApplicationContext(), photo);
//            mImageUri = ivImageToUpload;
            photo=(Bitmap)data.getExtras().get("data");
            ivImageToUpload.setImageBitmap(photo);
            mProgress.setMessage("Uploading After Clicking");
            mProgress.show();
            ivImageToUpload.setDrawingCacheEnabled(true);
            ivImageToUpload.buildDrawingCache();
            Bitmap bitmap = ((BitmapDrawable) ivImageToUpload.getDrawable()).getBitmap();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] datap = baos.toByteArray();
            final StorageReference filepath_of_clicking_upload = mStorageRef.child("Images After Clicking").child("HELLO");
            final UploadTask uploadTask = filepath_of_clicking_upload.putBytes(datap);
            uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    mProgress.dismiss();
                    Toast.makeText(getApplicationContext(), "Successfully Uploaded", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    mProgress.dismiss();
                    Toast.makeText(getApplicationContext(), "Failure  Can't Upload", Toast.LENGTH_LONG).show();
                }
            }).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    Toast.makeText(getApplicationContext(),filepath_of_clicking_upload.getDownloadUrl().toString(),Toast.LENGTH_LONG).show();
                }
            });

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