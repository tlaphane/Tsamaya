package com.example.testcharts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ArrayList<Integer> Statistics;
    //Intent currentIntent;
    TextView OnSchedeule;
    TextView BehindSchedule;
    TextView SlightlyBehind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pie pie = AnyChart.pie();
        pie.title("Statistics for the day");
        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Pending", 10));
        // data.add(new ValueDataEntry("Jake", 12000));
        data.add(new ValueDataEntry("Completed", 20));

        pie.data(data);
        pie.labels().position("outside");
        pie.legend().title().enabled(true);
        pie.legend().title()
                .text("")
                .padding(0d, 0d, 10d, 0d);

        pie.legend()
                .position("center-bottom")
                .itemsLayout(LegendLayout.HORIZONTAL)
                .align(Align.CENTER);

        AnyChartView anyChartView = (AnyChartView) findViewById(R.id.piechart);
        anyChartView.setChart(pie);
    }
}
