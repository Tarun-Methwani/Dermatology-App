package com.ind.sihc.pdapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {
    BarChart idBharchart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_graph);

            idBharchart = (BarChart) findViewById(R.id.idBarchart);
            idBharchart.getDescription().setEnabled(false);
            idBharchart.setDrawBarShadow(false);
            idBharchart.setPinchZoom(false);
            idBharchart.setMaxVisibleValueCount(50);
            idBharchart.setDrawGridBackground(true);

            ArrayList<BarEntry> barEntries = new ArrayList<>();

            barEntries.add(new BarEntry(1, 40f));
            barEntries.add(new BarEntry(2, 50f));
            barEntries.add(new BarEntry(3, 43f));
            barEntries.add(new BarEntry(4, 80f));
            barEntries.add(new BarEntry(5, 65f));
            BarDataSet barDataSet = new BarDataSet(barEntries, "Data set");
            barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

            BarData data = new BarData(barDataSet);
            data.setBarWidth(0.9f);


            idBharchart.setData(data);
            idBharchart.setFitBars(true);

            String[] Disease = new String[]{"RingWorm", "Dart", "Fifth Dis", "Chicken Pox", " Dermatis"};
            XAxis xAxis = idBharchart.getXAxis();
            xAxis.setValueFormatter(new MyXAxisValueFormater(Disease));
            xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }


    }

    public class MyXAxisValueFormater implements IAxisValueFormatter
    {




            private String[] mValues;
        public MyXAxisValueFormater(String[]values)
            {
                this.mValues = values;
            }

            @Override
            public String getFormattedValue ( float value, AxisBase axis){
            return mValues[(int) value - 1];
        }


    }
}
