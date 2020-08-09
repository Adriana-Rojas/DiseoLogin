package com.example.juliocesar.diseologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.security.PrivateKey;
import java.util.ArrayList;

public class Grafica extends AppCompatActivity {
    Button siguiente;
    private BarChart barChart;
    private String [] factores=new  String[]{"Eficiencia","Eficacia","Memorabilidad","Productividad","Satisfaccion","Seguridad","Universabilidad","Carga cognitiva"};
    // private Float [] valores=new Float[] {Float.parseFloat(Usabilidad.seficiencia),Float.parseFloat(Usabilidad.seficacia),Float.parseFloat(Usabilidad.smemorabilidad),Float.parseFloat(Usabilidad.sproductividad),Float.parseFloat(Usabilidad.ssatisfaccion),Float.parseFloat(Usabilidad.sseguridad),Float.parseFloat(Usabilidad.suniversabilidad),Float.parseFloat(Usabilidad.scargacognitiva)};

    private int [] valores=new int[] {4,6,3,8,5,2,4,8};
    private  int [] color=new int[]{
            Color.rgb(0, 104, 98),
            Color.rgb(18, 178, 226),
            Color.rgb(92, 182, 138),
            Color.rgb(21, 184, 175),
            Color.rgb(230, 142, 121),
            Color.rgb(234, 136, 155),
            Color.rgb(183, 151, 221),
            Color.rgb(129, 165, 236)};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafica);
        barChart=(BarChart)findViewById(R.id.barChart);
        createCharts();
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Graficados.class));
                finish();
            }
        });
    }
    private Chart getSaneChart(Chart chart,String descripcion,int textColor,int background,int animateY){
        chart.getDescription().setText(descripcion);
        chart.getDescription().setTextSize(45);
        chart.setBackgroundColor(background);
        chart.animateY(animateY);
        legend(chart);
        return chart;
    }
    private  void legend (Chart chart){

        Legend legend=chart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);

        ArrayList<LegendEntry>entries=new ArrayList<>();
        for (int i=8;i<factores.length;i++){
            LegendEntry entry=new LegendEntry();
            entry.formColor=color[i];
            entry.label=factores[i];
            entries.add(entry);
        }
        legend.setCustom(entries);
    }
    private ArrayList<BarEntry>getBarEntries(){
        ArrayList<BarEntry> entries=new ArrayList<>();
        for (int i=0;i<valores.length;i++)
            entries.add(new BarEntry(i,valores[i]));
        return entries;
    }
    private  void axisX(XAxis axis){
        axis.setGranularityEnabled(true);//cada cuanto
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setLabelRotationAngle(270);
        axis.setValueFormatter(new IndexAxisValueFormatter(factores));
        //axis.setEnabled(false);

    }
    private void  axisLeft(YAxis axis){
        axis.setSpaceTop(100);
        axis.setAxisMaximum(10);
    }
    private void axisRight(YAxis axis){
        axis.setEnabled(false);
    }
    public void createCharts(){
        barChart=(BarChart)getSaneChart(barChart,"",Color.WHITE,Color.WHITE,3000);
        barChart.setDrawBarShadow(true);
        barChart.setData(getBarData());
        barChart.invalidate();
        axisX(barChart.getXAxis());
        axisLeft(barChart.getAxisLeft());
        axisRight(barChart.getAxisRight());
        barChart.getLegend().setEnabled(true);//clores cuadros pequeos
    }
    private DataSet getData(DataSet dataSet){
        dataSet.setColors(color);
        dataSet.setValueTextSize(Color.rgb(104, 241, 175));
        dataSet.setValueTextSize(10);
        return dataSet;
    }
    private BarData getBarData(){
        BarDataSet barDataSet=(BarDataSet)getData(new BarDataSet(getBarEntries(),""));
        barDataSet.setBarShadowColor(Color.WHITE);
        BarData barData=new BarData(barDataSet);
        barData.setBarWidth(0.45f);
        return barData;

    }

}

