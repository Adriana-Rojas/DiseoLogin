package com.ytheekshana.deviceinfo;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;


public class Graficados extends AppCompatActivity {

    private RadarChart radarChart;
    private HorizontalBarChart horizontalBarChart;

    private String[]months=new String[]{"Enero","Febrero","Marzo","Abril","Mayo"};
    int bandera=0;
    //Eje Y
    private Float[]sale=new Float[] {Float.parseFloat(Usabilidad.scalcularusabilidad)};
    private  int [] colors=new int[]{Color.rgb(21, 184, 175)};
    private String[]factores=new String[]{"Eficiencia","Eficacia","Memorabilidad","Productividad","Satisfaccion","Seguridad","Universabilidad","Carga cognitiva"};
    private String[]usabilidad=new String[]{"Usabilidad"};
    private Float [] valuefactores=new Float[] {Float.parseFloat(Usabilidad.seficiencia),Float.parseFloat(Usabilidad.seficacia),Float.parseFloat(Usabilidad.smemorabilidad),Float.parseFloat(Usabilidad.sproductividad),Float.parseFloat(Usabilidad.ssatisfaccion),Float.parseFloat(Usabilidad.sseguridad),Float.parseFloat(Usabilidad.suniversabilidad),Float.parseFloat(Usabilidad.scargacognitiva)};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficados);

        radarChart = (RadarChart) findViewById(R.id.radarChart);
        horizontalBarChart= (HorizontalBarChart) findViewById(R.id.horizontalBarChart);
        createCharts();

    }
    //Carasteristicas comunes en las graficas
    private Chart getSameChart(Chart chart, String description, int textColor, int background, int animateY, boolean leyenda){
        chart.getDescription().setText(description);
        chart.getDescription().setTextColor(textColor);
        chart.getDescription().setTextSize(15);
        chart.setBackgroundColor(background);
        chart.animateY(animateY);

        return chart;
    }

    private ArrayList<RadarEntry> getRadarEntriesChevrolet() {
        ArrayList<RadarEntry> entries = new ArrayList<>();
        for (int i = 0; i < valuefactores.length; i++)
            entries.add(new RadarEntry(valuefactores[i]));
        return entries;
    }

    private ArrayList<String> getVariable() {
        ArrayList<String> entries = new ArrayList<>();
        entries.addAll(Arrays.asList(factores));
        return entries;
    }
    private ArrayList<BarEntry>getBarEntries(){
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < sale.length; i++)
            entries.add(new BarEntry(i,sale[i]));
        return entries;
    }

    //Eje horizontal o eje X
    private void axisX(XAxis axis){
        axis.setGranularityEnabled(true);
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        if(bandera==1){
            axis.setValueFormatter(new IndexAxisValueFormatter(usabilidad));
        }else {
            axis.setValueFormatter(new IndexAxisValueFormatter(factores));
        }

    }
    //Eje Vertical o eje Y lado izquierdo
    private void axisLeft(YAxis axis){
            axis.setSpaceTop(1);
            axis.setAxisMinimum(0);
            axis.setAxisMaximum(100);
    }
    //Eje Vertical o eje Y lado Derecho
    private void axisRight(YAxis axis){
        axis.setEnabled(false);
    }

    //Crear graficas
    public void createCharts(){
        //RadarChart

        //En radar se valido la leyenda porque no podemos perzonalizarlo la leyenda se crea de acuerdo a los datos que se tienen dentro de la grafica.
        radarChart = (RadarChart) getSameChart(radarChart, "", Color.GREEN, Color.WHITE, 3000,false);
        radarChart.setData(getRadarData());
        radarChart.invalidate();
        bandera=0;
        axisX(radarChart.getXAxis());
        bandera=1;
        //BarChart
        horizontalBarChart=(HorizontalBarChart)getSameChart(horizontalBarChart," ",Color.YELLOW,Color.WHITE,3000,true);
        //barChart.setDrawGridBackground(true);
        horizontalBarChart.setDrawBarShadow(true);
        horizontalBarChart.setData(getBarData());
        horizontalBarChart.invalidate();
        //barChart.getLegend().setEnabled(false);
        axisX(horizontalBarChart.getXAxis());
        axisLeft(horizontalBarChart.getAxisLeft());
        axisRight(horizontalBarChart.getAxisRight());

    }

    //Carasteristicas comunes en dataset
    private DataSet getDataSame(DataSet dataSet){
        dataSet.setColors(colors);
        dataSet.setValueTextColor(Color.rgb(21, 184, 175));
        dataSet.setValueTextSize(10);
        return dataSet;
    }
    private BarData getBarData(){
        BarDataSet barDataSet=(BarDataSet)getDataSame(new BarDataSet(getBarEntries(),"% de usabilidad"));
        barDataSet.setBarShadowColor(Color.WHITE);
        BarData barData=new BarData(barDataSet);
        barData.setBarWidth(0.45f);
        return barData;
    }

    private RadarData getRadarData() {

        RadarDataSet chevrolet = (RadarDataSet) getDataSame(new RadarDataSet(getRadarEntriesChevrolet(), "Usabilidad"));
        //Definimos un color especial para chevrolet para no cargar el arreglo de colores
        chevrolet.setColor(Color.rgb(21, 184, 175));

        ArrayList<IRadarDataSet> dataSets = new ArrayList<IRadarDataSet>();
        dataSets.add(chevrolet);

        RadarData data = new RadarData(dataSets);
        data.setLabels(getVariable());
        return data;
    }

}
