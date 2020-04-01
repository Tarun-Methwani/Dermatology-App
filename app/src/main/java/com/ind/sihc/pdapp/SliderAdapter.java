package com.ind.sihc.pdapp;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ind.sihc.pdapp.R;
import com.ind.sihc.pdapp.MainActivity;

public class SliderAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

//    private TextView slideHeading, slideDescription;
//    private ImageView slide_imageView;


    public SliderAdapter(Context context) {

        this.context = context;
    }

    // img Array
    public int[] image_slide ={
            R.drawable.error,
            R.drawable.error,
            R.drawable.ethics
    };

    // heading Array
    public String[] heading_slide ={
            "DISCLAIMER\n",
            "DISCLAIMER",
            "ETHICS AND RESPONISBLITIES"
    };

    // description Array
    public String[] description_slide ={
            "In order to maintain a healthy patient doctor relationship, it is advisable that you should abide by the following rules.\n\n\n1. Misuse of images is strictly prohibited \n\n" +
                    "2. The information and materials provided on or accessed through this app are intended solely for individuals seeking general information about medical procedures and are not intended for on members of the app. are intended solely for individuals seeking general information about .edical procedures  and  are not intended for non-members of the app.\n",
            "3. Users of this app should never disregard professional .medical  advice or delay in seeking treatment based on the information contained on or accessed through this app.\n\n" +
                    "4.The users of this app does not create a patient- physician relationship such as to obligate or followup personally within themselves.",
            "1.Patient has to abide by the rules and conditions\n\n"+"2.In any conditions doctor cannot see the personal details of the patient\n\n"+"3.Patient cannot see the details of the doctor"
    };

    @Override
    public int getCount() {

        return heading_slide.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container,false);
        container.addView(view);

        ImageView slide_imageView = view.findViewById(R.id.imageView1);
        TextView slideHeading = view.findViewById(R.id.tvHeading);
        TextView  slideDescription = view.findViewById(R.id.tvDescription);

        slide_imageView.setImageResource(image_slide[position]);
        slideHeading.setText(heading_slide[position]);
        slideDescription.setText(description_slide[position]);

        return view;
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }

//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        View view = (View) object;
//        container.removeView(view);
//    }

}


