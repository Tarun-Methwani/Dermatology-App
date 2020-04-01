package com.ind.sihc.pdapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class FAQpANS extends AppCompatActivity {

    TextView tvQuestion,tvAnswer;

    String ans = null;
    String faq =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqp_ans);

        tvQuestion = findViewById(R.id.tvQuestion);
        tvAnswer = findViewById(R.id.tvAnswer);

        Intent i = getIntent();
        faq = i.getStringExtra("faq1");
        ans = i.getStringExtra("ans1");
        if(!(faq==null))
        {
            tvQuestion.setText(faq);
            tvAnswer.setText(ans);
        }
        if(ans == null)
        {
            faq = i.getStringExtra("faq2");
            ans = i.getStringExtra("ans2");
            tvQuestion.setText(faq);
            tvAnswer.setText(ans);
        }
        if(ans==null)
        {
            faq = i.getStringExtra("faq3");
            ans = i.getStringExtra("ans3");
            tvQuestion.setText(faq);
            tvAnswer.setText(ans);
        }
        if(ans==null)
        {
            faq = i.getStringExtra("faq4");
            ans = i.getStringExtra("ans4");
            tvQuestion.setText(faq);
            tvAnswer.setText(ans);
        }
        if(ans==null)
        {
            faq = i.getStringExtra("faq5");
            ans = i.getStringExtra("ans5");
            tvQuestion.setText(faq);
            tvAnswer.setText(ans);
        }
        if(ans==null) {
            faq = i.getStringExtra("faq6");
            ans = i.getStringExtra("ans6");
            tvQuestion.setText(faq);
            tvAnswer.setText(ans);
        }
        if(ans==null)
        {
            faq = i.getStringExtra("faq7");
            ans = i.getStringExtra("ans7");
            tvQuestion.setText(faq);
            tvAnswer.setText(ans);
        }
    }
}
