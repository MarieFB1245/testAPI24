package com.example.testapi24

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.size
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import java.util.ArrayList

class MainActivity : AppCompatActivity() {


    private val test = 40
    private val test2 = 60
    private val TAG = "testgraphview"
    private val peercenData = intArrayOf(test, test2)
    private val pnameFood = arrayOf("Food", "Workout")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupPieChart()
    }
    private fun setupPieChart() {
        val pieEntries = ArrayList<PieEntry>()
        for (i in peercenData.indices) {
            pieEntries.add(
                PieEntry(
                    peercenData[i].toFloat(),
                    pnameFood[i]
                )
            )//ค่าที่เก็บจะต้องเป็น array
        }
        val dataSet = PieDataSet(pieEntries, "test")
        val colors = ArrayList<Int>()
        colors.add(Color.RED)
        colors.add(Color.BLUE)
        dataSet.colors = colors
        val data = PieData(dataSet)

        val chart = findViewById(R.id.chart) as PieChart
        chart.data = data
        chart.setCenterTextSizePixels(500f)
        data.setValueTextSize(30f);
        chart.animateY(500)
        chart.invalidate()
    }

    fun insert (v:View){
        val intent = Intent(this, insert_data::class.java)
        startActivity(intent)


    }


}
