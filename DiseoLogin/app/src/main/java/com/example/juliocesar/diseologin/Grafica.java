package com.example.juliocesar.diseologin;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

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
    private BarChart barChart;
    private String [] factores=new  String[]{"Eficiencia","Eficacia","Memorabilidad","Productividad","Satisfaccion","Seguridad","Universabilidad","Carga cognitiva"};
   // private Float [] valores=new Float[] {Float.parseFloat(Usabilidad.seficiencia),Float.parseFloat(Usabilidad.seficacia),Float.parseFloat(Usabilidad.smemorabilidad),Float.parseFloat(Usabilidad.sproductividad),Float.parseFloat(Usabilidad.ssatisfaccion),Float.parseFloat(Usabilidad.sseguridad),Float.parseFloat(Usabilidad.suniversabilidad),Float.parseFloat(Usabilidad.scargacognitiva)};

    private int [] valores=new int[] {4,6,3,8,5,2,4,8};
    private  int [] color=new int[]{Color.BLACK,Color.BLUE,Color.GRAY,Color.GREEN,Color.CYAN,Color.RED,Color.YELLOW,Color.MAGENTA};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafica);
        barChart=(BarChart)findViewById(R.id.barChart);
        createCharts();
    }
    private Chart getSaneChart(Chart chart,String descripcion,int textColor,int background,int animateY){
        chart.getDescription().setText(descripcion);
        chart.getDescription().setTextSize(45);
        chart.setBackgroundColor(background);
        chart.animateY(animateY);
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
        for (int i=0;i<valores.length;i++){
            entries.add(new BarEntry(i,valores[i]));
        }
        return entries;
    }
    private  void axisX(XAxis axis){
        axis.setGranularityEnabled(true);
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setValueFormatter(new IndexAxisValueFormatter(factores));
    }
    private void  axisLeft(YAxis axis){
        axis.setSpaceTop(30);
        axis.setAxisMaximum(30);
    }
    private void axisRight(YAxis axis){
        axis.setEnabled(false);
    }
    public void createCharts(){
        barChart=(BarChart)getSaneChart(barChart,"Usabilidad",Color.DKGRAY,Color.LTGRAY,3000);
        barChart.setDrawBarShadow(true);
        barChart.setDrawBarShadow(true);
        barChart.setData(getBarData());
        barChart.invalidate();
        axisX(barChart.getXAxis());
        axisLeft(barChart.getAxisLeft());
        axisRight(barChart.getAxisRight());
    }
    private DataSet getData(DataSet dataSet){
        dataSet.setColors(color);
        dataSet.setValueTextSize(Color.WHITE);
        dataSet.setValueTextSize(10);
        return dataSet;
    }
    private BarData getBarData(){
        BarDataSet barDataSet=(BarDataSet)getData(new BarDataSet(getBarEntries(),""));
        barDataSet.setBarShadowColor(Color.CYAN);
        BarData barData=new BarData(barDataSet);
        barData.setBarWidth(0.45f);
        return barData;

    }

}

