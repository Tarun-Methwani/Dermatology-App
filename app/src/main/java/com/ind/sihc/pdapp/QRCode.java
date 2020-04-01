package com.ind.sihc.pdapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.WriterException;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public class QRCode extends AppCompatActivity {
    public final static int QRcodeWidth = 500 ;

    String email;
    ImageView iv;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    TextView tvS;
    Bitmap bitmap ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        Intent i = getIntent();
        email = i.getStringExtra("email");
        iv = findViewById(R.id.iv);
        tvS = findViewById(R.id.tvS);

        firebaseDatabase  = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users/Doctors");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot k : dataSnapshot.getChildren())
                {
                    Doctor s = k.getValue(Doctor.class);
                    if(s.email.equals(email))
                    {
                        tvS.setText(k.getKey());
                        tvS.setVisibility(View.INVISIBLE);
                    }


                }
                try {
                    String Qrtext = (String) tvS.getText();
                    bitmap = TextToImageEncode(Qrtext);
                    iv.setImageBitmap(bitmap);
//                    String path = saveImage(bitmap);  //give read write permission
//                    Toast.makeText(QRCode.this, "QRCode saved to -> "+path, Toast.LENGTH_SHORT).show();
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }

            private Bitmap TextToImageEncode(String Value) throws WriterException {
                BitMatrix bitMatrix;
                try {
                    bitMatrix = new MultiFormatWriter().encode(
                            Value,
                            BarcodeFormat.DATA_MATRIX.QR_CODE,
                            QRcodeWidth, QRcodeWidth, null
                    );

                } catch (IllegalArgumentException Illegalargumentexception) {

                    return null;
                }
                int bitMatrixWidth = bitMatrix.getWidth();

                int bitMatrixHeight = bitMatrix.getHeight();

                int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

                for (int y = 0; y < bitMatrixHeight; y++) {
                    int offset = y * bitMatrixWidth;

                    for (int x = 0; x < bitMatrixWidth; x++) {

                        pixels[offset + x] = bitMatrix.get(x, y) ?
                                getResources().getColor(R.color.black):getResources().getColor(R.color.White);
                    }
                }
                Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

                bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
                return bitmap;


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
