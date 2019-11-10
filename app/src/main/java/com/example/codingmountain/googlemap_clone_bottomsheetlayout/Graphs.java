package com.example.codingmountain.googlemap_clone_bottomsheetlayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static com.example.codingmountain.googlemap_clone_bottomsheetlayout.R.*;

public class Graphs extends AppCompatActivity implements GraphsSelectedButton {

     BarChart barChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.graphs);
        barChart =(BarChart) findViewById(id.barChart);

//        Spinner spinner = findViewById(id.times);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, array.names, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        String [] timeSchedule = new String[]{"3-5am","6-9am","10-12pm","13-16pm","17-19pm","19-21pm","21-23pm"};
        ArrayList<String>test=new ArrayList<>(Arrays.asList(timeSchedule));

        Spinner spinner = (Spinner) findViewById(id.times);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, array.times, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String travel_type = String.valueOf(adapterView.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        BarDataSet barDataSet1 = new BarDataSet(barEntries1(),"Less than 30mins");
        barDataSet1.setColors(Color.RED);
        BarDataSet barDataSet2 = new BarDataSet(barEntries2(),"Within an hour");
        barDataSet2.setColors(Color.GREEN);
        BarDataSet barDataSet3 = new BarDataSet(barEntries3(),"Above an hour");
        barDataSet3.setColors(Color.MAGENTA);

        ArrayList<BarEntry>yValues = new ArrayList<>();

        BarData data = new BarData(barDataSet1,barDataSet2,barDataSet3);
        barChart.setData(data);

        String[] days= new String[]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};


        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(days));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setVisibleXRangeMaximum(3);

        float barSpace=0.08f;
        float groupSpace=0.44f;

        data.setBarWidth(0.10f);

        barChart.getXAxis().setAxisMinimum(0);
        barChart.getXAxis().setAxisMaximum(0+barChart.getBarData().getGroupWidth(groupSpace,barSpace)*7);
        barChart.getAxisLeft().setAxisMinimum(0);
        barChart.groupBars(0,groupSpace,barSpace);
        barChart.invalidate();

    }

    @Override
    public void onItemSelected(AdapterView<?>parent, View view, int position){
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();


    }

    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)


        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }

    }


    private ArrayList<BarEntry>barEntries1(){
        ArrayList<BarEntry>barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(1,20));
        barEntries.add(new BarEntry(2,15));
        barEntries.add(new BarEntry(3,20));
        barEntries.add(new BarEntry(4,8));
        barEntries.add(new BarEntry(5,4));
        barEntries.add(new BarEntry(6,10));
        barEntries.add(new BarEntry(7,3));

        return barEntries;
    }

    private ArrayList<BarEntry>barEntries2(){
        ArrayList<BarEntry>barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(1,9));
        barEntries.add(new BarEntry(2,7));
        barEntries.add(new BarEntry(3,16));
        barEntries.add(new BarEntry(4,8));
        barEntries.add(new BarEntry(5,4));
        barEntries.add(new BarEntry(6,15));
        barEntries.add(new BarEntry(7,3));

        return barEntries;
    }

    private ArrayList<BarEntry>barEntries3(){
        ArrayList<BarEntry>barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(1,9));
        barEntries.add(new BarEntry(2,7));
        barEntries.add(new BarEntry(3,16));
        barEntries.add(new BarEntry(4,8));
        barEntries.add(new BarEntry(5,14));
        barEntries.add(new BarEntry(6,15));
        barEntries.add(new BarEntry(7,20));

        return barEntries;
    }


}
