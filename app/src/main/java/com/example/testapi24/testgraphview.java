package com.example.testapi24;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import java.util.ArrayList;
import java.util.List;

public class testgraphview extends AppCompatActivity {


    private int test = 50;
    private int test2 = 50;
    private static String TAG = "testgraphview";
    private int[] peercenData = {test,test2};
    private  String[] pnameFood = {"Food" ,"Workout"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testgraphview);

setupPieChart();


    }
private void setupPieChart (){
    List<PieEntry>pieEntries = new ArrayList<>();
    for (int i = 0 ; i<peercenData.length;i++){
        pieEntries.add(new PieEntry(peercenData[i],pnameFood[i]));//ค่าที่เก็บจะต้องเป็น aarray
    }
    PieDataSet dataSet = new PieDataSet(pieEntries,"test");
    ArrayList<Integer>colors = new ArrayList<>();
    colors.add(Color.RED);
    colors.add(Color.BLUE);
    dataSet.setColors(colors);
    PieData data = new PieData(dataSet);
    PieChart chart = (PieChart) findViewById(R.id.chart);
    chart.setData(data);
chart.setDrawHoleEnabled(false);
    chart.animateY(500);
    chart.invalidate();
}


}
