package com.ind.sihc.pdapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FAQ extends AppCompatActivity {

    TextView tvFaq1,tvFaq2,tvFaq3,tvFaq4,tvFaq5,tvFaq6,tvFaq7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        tvFaq1 = findViewById(R.id.tvFaq1);
        tvFaq2 = findViewById(R.id.tvFaq2);
        tvFaq3 = findViewById(R.id.tvFaq3);
        tvFaq4 = findViewById(R.id.tvFaq4);
        tvFaq5 = findViewById(R.id.tvFaq5);
        tvFaq6 = findViewById(R.id.tvFaq6);
        tvFaq7 = findViewById(R.id.tvFaq7);

        tvFaq1.setText("Q.What is IndiaNeoDesign?");
        tvFaq2.setText("Q.How do I use IndiaNeoDesign?");
        tvFaq3.setText("Q.Can I get prescription from the doctor?");
        tvFaq4.setText("Q.Can I contact the doctor?");
        tvFaq5.setText("Q.Will my case be stored?");
        tvFaq6.setText("Q.What do i do if I want to tell that my problem is solved or not?");
        tvFaq7.setText("Q.Can I receive a copy of my processed case?");

        tvFaq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),FAQpANS.class);
                i.putExtra("faq1","Q.What is IndiaNeoDesign?");
                i.putExtra("ans1","IndiaNeoDessign offers a professional input about your skin condition based on your uploaded images and text from a dermatologist.\n\n"+"Our service bridges the gap between an internet search and in-person dermatologist consulation.\n\n"+"Our team of dermatalogist is here around the clock to provide you an expert input on your skin concerns.");
                startActivity(i);
            }
        });
        tvFaq2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),FAQpANS.class);
                i.putExtra("faq2","Q.How do I use IndiaNeoDesign?");
                i.putExtra("ans2","Parent is going to do the registration first for his child. Parent is going to fill put his necessary details. Which requires his/her valid email Id and mobile number of the parent. Then parent is going to go for diagnosis where he is going to click photo of the skin area from top of the skin area where there is skin problem. Then along with the image parent fills details of his child. Parent has to fill out necessary details asked by the application for further processing. After sending the details doctor sends the remedy to the parent. ");
                startActivity(i);
            }
        });
        tvFaq3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),FAQpANS.class);
                i.putExtra("faq3","Q.Can I get prescription from the doctor?");
                i.putExtra("ans3","Yes, Doctors write prescriptions. Doctor gets notification that a patient wants to get diagnosed he looks at the image and the details sent by the parent, he sends list of instructions to follow and any medicines to take.");
                startActivity(i);
            }
        });
        tvFaq4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),FAQpANS.class);
                i.putExtra("faq4","Q.Can I contact the doctor?");
                i.putExtra("ans4","To protect the users anonimity, we do not disclose contact information of our users or our doctors. Please contact info@indianeodesign.com if you have any questions, comments or concerns regarding your case.");
                startActivity(i);
            }
        });
        tvFaq5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),FAQpANS.class);
                i.putExtra("faq5","Q.Will my case be stored?");
                i.putExtra("ans5","Your case will be kept on record for 10 years: Case number, dates, time, picture, text, the response from our doctor and which doctor replied. Some cases that are not identifiable may be used ini research literature or conference, but is not sold to third parties.\n");
                startActivity(i);
            }
        });
        tvFaq6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),FAQpANS.class);
                i.putExtra("faq6","Q.What do i do if I want to tell that my problem is solved or not?");
                i.putExtra("ans6","Patient will be asked after 6 hours that how is the baby. The parent has to send the answer in the form of yes or no. If Yes then the casee details will be saved in the patient account along with doctors prescriotion. If problem is still present then the follow with the doctor will be there.");
                startActivity(i);
            }
        });
        tvFaq7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),FAQpANS.class);
                i.putExtra("faq7","Q.Can I receive a copy of my processed case?");
                i.putExtra("ans7","Yes. Parent will receive a soft copy of the processed case.");
                startActivity(i);
            }
        });
    }
}
