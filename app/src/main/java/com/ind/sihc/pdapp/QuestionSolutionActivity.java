package com.ind.sihc.pdapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class QuestionSolutionActivity extends AppCompatActivity {

    TextView tvDiseasenup, tvRemedies, tvSolution, tvRemediesD, tvSolutionD;

    String CHANNEL_ID = "com.ind.sihc.pdapp";
    String title = "how is baby?";
    String content = "hello";
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_solution);

        tvDiseasenup = findViewById(R.id.tvDiseasenup);
        Intent i = getIntent();
        final String disease = i.getStringExtra("disease");

        tvDiseasenup.setText(disease);
        tvRemedies = findViewById(R.id.tvRemedies);
        tvSolution = findViewById(R.id.tvSolution);
        tvSolutionD = findViewById(R.id.tvSolutionD);
        tvRemediesD = findViewById(R.id.tvRemediesD);

        if (disease.equals("ringworm")) {
            tvRemediesD.setText("Apple Vinegar\n" +
                    "The common salad dressing you use in your kitchen has natural antifungal properties that can treat your ringworm infection. To effectively use this product as a natural remedy, apply undiluted apple vinegar to the infected patch area with a swab or cotton ball several times a day until the patches are gone. The Grupocompostela Health University says the use of apple vinegar will completely eliminate the fungal infection.\n" +
                    "\n" +
                    "Coconut Oil\n" +
                    "The healing properties of coconut oil extend to treating ringworm infections. The oil provides relief to itchy skin while smoothing and softening the infected area. Coconut oil is also effective in treating ringworms on your scalp, says Missclinic.com. The website recommends to apply the oil at night so you can wash your hair the next day to eliminate build-up and residue. For sufferers of scalp ringworm, it is important to talk to your doctor first before considering any alternative natural treatment.\n" +
                    "\n" +
                    "Lavender Oil In Jojoba Oil\n" +
                    "For babies that have ringworm, a concoction made from one drop of lavender oil in jojoba oil provides a safe, soothing remedy. To apply this mixture, you can use a cotton ball or swab on the infected area.\n" +
                    "\n" +
                    "Mustard Seeds\n" +
                    "These tiny seeds can be useful when treating ringworm. Soak the mustard seeds in water for a while and then grind them to form a thick paste. The paste can be applied on the infected skin to provide itching and irritation relief, says Yahoo!.\n" +
                    "\n" +
                    "Tea Tree Oil\n" +
                    "Tea tree oil is known to have antiseptic and antifungal properties to treat various skin conditions. To use as an all-natural treatment for ringworm, use a compress soaked in tea tree oil as you place it between two pieces of clean cloth and apply to the infected area three times a day, says Yahoo! Health. Avoid using plastic as a cover for the compress. The compress should feel warm and be in sync with your body temperature as it begins to aid the skin infection.\n");
            tvSolutionD.setText(" Crucial Do’s\n" +
                    "1. Wear dry loose cotton clothes. Try to find inner garments which are 100 % pure cotton. Make use of fans or air conditioners at night to keep the affected part well ventilated.\n" +
                    "\n" +
                    "2. Take bath twice a day. Always use lukewarm water. Avoid using very hot water. Hot water favors fungal growth on the body. Wash the affected parts with cold water once you are done taking bath. Always use a fresh dry towel to wipe off water from the body. Make sure skin folds are totally dry before wearing clothes.\n" +
                    "\n" +
                    "3. Use antifungal dusting powders for your skin folds such as underarms, thigh folds, below breasts, and between the toes.\n" +
                    "\n" +
                    "4. Wash your clothes, towel, and bedspread in hot water and dry them in good sunlight.\n" +
                    "\n" +
                    "5. Eat healthy food, keep your body weight ideal for your height because being overweight or undernourished leads to reduced immunity which increases the chances of acquiring a fungal infection.\n" +
                    "\n" +
                    "6. If you are diabetic, check your blood sugar level frequently and make sure your blood sugars are within the normal range because uncontrolled blood sugar is a risk factor for fungal infection.\n" +
                    "\n" +
                    "7. Ask if any of your family members have a similar fungal infection. If so, encourage them to take treatment.\n" +
                    "\n" +
                    "8. Check your pet animals for rashes. If there are any, take them to a veterinary doctor for treatment. Dogs and cats are also the sources of infection.\n" +
                    "\n" +
                    "9. Always complete the full course of medications prescribed by your dermatologist. Incomplete treatment results in recurrence of fungal infection which is more resistant to treatment.\n" +
                    "\n" +
                    "Tinea (Ringworm): Crucial Don’Ts\n" +
                    "1. Do not scratch. Scratching makes the rash worse. Ask your dermatologist to prescribe anti-itching medicine.\n" +
                    "\n" +
                    "2. Do not wear synthetic clothes, tight-fitting jeans which do not allow air to flow through them and do not wear wet inner clothes. Do not wear inners while at home, just allow air to flow freely through the affected part.\n" +
                    "\n" +
                    "3. Do not share your personal items such as clothes, towel, soap, or comb with your family members or friends.\n" +
                    "\n" +
                    "4. Do not use over-the-counter (OTC) medications for ringworm. Most of these OTC creams contain steroid in them, which gives faster relief from itching but they make the ringworm spread to a larger area and also make the routine treatment insufficient.\n" +
                    "\n" +
                    "5. Do not use home remedies such as garlic paste to get rid of ringworm. This could burn your skin and leave a permanent scar.\n" +
                    "");

        } else if (disease.equals("chicken pox")) {
            tvRemediesD.setText("Use cool wet compresses or give baths in lukewarm water every 3–4 hours for the first few days. Oatmeal bath products, available at supermarkets and drugstores, can help to relieve itching. (Baths do not spread the rash.)\n" +
                    "Pat (don't rub) the body dry.\n" +
                    "Put calamine lotion on itchy areas (but don't use it on the face, especially near the eyes).\n" +
                    "Ask your doctor or pharmacist about pain-relieving creams to apply to sores in the genital area.\n" +
                    "Ask the doctor about using over-the-counter medicine to take by mouth for itching.\n" +
                    "To prevent scratching:\n" +
                    "\n" +
                    "Put mittens or gloves on your child's hands to avoid scratching during sleep. \n" +
                    "Trim fingernails and keep them clean.\n" +
                    "If your child has blisters in the mouth:\n" +
                    "\n" +
                    "Give cold, soft, bland foods because chickenpox in the mouth can make it hard to drink or eat. Avoid anything acidic or salty, like orange juice or pretzels.\n" +
                    "Give your child acetaminophen to help relieve pain.\n" +
                    "Never give aspirin to kids with chickenpox. It can lead to a serious illness called Reye syndrome.");
            tvSolutionD.setText("Varicella or Chickenpox is a very discomforting disease and causes lot of pain. In order to deal with this, certain measures are suggested below:\n" +
                    "\n" +
                    "\n" +
                    "For the first few days of disease, use hot-cold compresses or give baths lukewarm water every three hours.\n" +
                    "Avoid rubbing the body and pat the body dry.\n" +
                    "Use calamine lotion in the areas which are itchy to control the itching sensation\n" +
                    "Eat a bland diet with no spice or excess salt.\n" +
                    "In case of blisters in the genital areas, applying cream might help.\n" +
                    "One can also use acetaminophen for pain relief.\n" +
                    "If the itching is extremely severe then the treating physician may prescribe some medication orally to control it.\n" +
                    "Never use aspirin products to control fever caused due to Varicella or Chickenpox as it may lead to potentially serious complications.\n" +
                    "Do not scratch the blisters. It may be difficult for the children, so it is best to put some protection in the form of a cloth on their hands so as to prevent them from scratching the blisters");

        } else {
            tvRemediesD.setText("Use cool wet compresses or give baths in lukewarm water every 3–4 hours for the first few days. Oatmeal bath products, available at supermarkets and drugstores, can help to relieve itching. (Baths do not spread the rash.)\n" +
                    "Pat (don't rub) the body dry.\n" +
                    "Put calamine lotion on itchy areas (but don't use it on the face, especially near the eyes).\n" +
                    "Ask your doctor or pharmacist about pain-relieving creams to apply to sores in the genital area.\n" +
                    "Ask the doctor about using over-the-counter medicine to take by mouth for itching.\n" +
                    "To prevent scratching:\n" +
                    "\n" +
                    "Put mittens or gloves on your child's hands to avoid scratching during sleep. \n" +
                    "Trim fingernails and keep them clean.\n" +
                    "If your child has blisters in the mouth:\n" +
                    "\n" +
                    "Give cold, soft, bland foods because chickenpox in the mouth can make it hard to drink or eat. Avoid anything acidic or salty, like orange juice or pretzels.\n" +
                    "Give your child acetaminophen to help relieve pain.\n" +
                    "Never give aspirin to kids with chickenpox. It can lead to a serious illness called Reye syndrome.");
            tvSolutionD.setText("Varicella or Chickenpox is a very discomforting disease and causes lot of pain. In order to deal with this, certain measures are suggested below:\n" +
                    "\n" +
                    "\n" +
                    "For the first few days of disease, use hot-cold compresses or give baths lukewarm water every three hours.\n" +
                    "Avoid rubbing the body and pat the body dry.\n" +
                    "Use calamine lotion in the areas which are itchy to control the itching sensation\n" +
                    "Eat a bland diet with no spice or excess salt.\n" +
                    "In case of blisters in the genital areas, applying cream might help.\n" +
                    "One can also use acetaminophen for pain relief.\n" +
                    "If the itching is extremely severe then the treating physician may prescribe some medication orally to control it.\n" +
                    "Never use aspirin products to control fever caused due to Varicella or Chickenpox as it may lead to potentially serious complications.\n" +
                    "Do not scratch the blisters. It may be difficult for the children, so it is best to put some protection in the form of a cloth on their hands so as to prevent them from scratching the blisters");

        }
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // this code will be executed after 2 seconds
                showNotification("hello", "how is baby");
            }
        }, 2000);


    }


    private void showNotification(String title, String content) {
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default",
                    "YOUR_CHANNEL_NAME",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("YOUR_NOTIFICATION_CHANNEL_DISCRIPTION");
            mNotificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "default")
                .setSmallIcon(R.drawable.download) // notification icon
                .setContentTitle(title) // title for notification
                .setContentText(content)// message for notification
                .setAutoCancel(true); // clear notification after click
        Intent intent = new Intent(getApplicationContext(), DashboardActivityP.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pi);
        mNotificationManager.notify(rand.nextInt(5), mBuilder.build());
//
//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent i=new Intent(getApplicationContext(),DashboardActivityP.class);
////                startActivity(i);
////                finish();
//            }
//        });
    }
}





















