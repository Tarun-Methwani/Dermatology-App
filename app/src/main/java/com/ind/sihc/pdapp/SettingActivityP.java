package com.ind.sihc.pdapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class SettingActivityP extends AppCompatActivity {

    Button btnSaveChanges;
    EditText etName;
    CircleImageView civProfile;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;
    DatabaseReference rootRef;
    String currentUserID;
    String currentUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_p);


        InitializeFields();
        mAuth=FirebaseAuth.getInstance();
        currentUser=mAuth.getCurrentUser();
        rootRef=FirebaseDatabase.getInstance().getReference();
        currentUserID = mAuth.getCurrentUser().getUid();
        currentUserEmail=mAuth.getCurrentUser().getEmail();
        btnSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSetting();
            }
        });
        retrieveUserInfo();
    }

    private void InitializeFields()
    {
        btnSaveChanges=findViewById(R.id.btnSaveChanges);
        etName=findViewById(R.id.etName);
        civProfile=(CircleImageView)findViewById(R.id.civProfile);
    }
    private void updateSetting()
    {
        String name=etName.getText().toString();
        HashMap<String,String> profileMap=new HashMap<>();
        profileMap.put("ParentEmail",currentUserEmail);
        profileMap.put("parentName",name);
        rootRef.child("Users/Patients").child(currentUserID).setValue(profileMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(SettingActivityP.this, "Profile Updated", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String message=task.getException().toString();
                    Toast.makeText(SettingActivityP.this, message, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void retrieveUserInfo()
    {
        rootRef.child("Users/Patients").child(currentUserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if((dataSnapshot.exists()) && (dataSnapshot.hasChild("parentName")))
                {

                    String name=dataSnapshot.child("parentName").getValue().toString();
                    etName.setText(name);
                }
                else
                {
                    Toast.makeText(SettingActivityP.this, "please update", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
