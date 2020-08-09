package com.example.juliocesar.diseologin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.Arrays;



public class Graficados extends AppCompatActivity {

    private RadarChart radarChart;

    //Eje X
    private String[]months=new String[]{"Eficiencia","Eficacia","Memorabilidad","Productividad","Satisfaccion","Seguridad","Universabilidad","Carga cognitiva"};

    //Grafica de Radar(Radar)
    //Los criterios que se evaluaran el la grafica
    private String[]variable=new String[]{"Eficiencia","Eficacia","Memorabilidad","Productividad","Satisfaccion","Seguridad","Universabilidad","Carga cognitiva"};
    //Valor para los criterios en un auto Chevrolet
    private int[]valueChevrolet=new int[]{4,6,3,8,5,2,4,8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficados);

        radarChart = (RadarChart) findViewById(R.id.radarChart);
        createCharts();

    }
    //Carasteristicas comunes en las graficas
    private Chart getSameChart(Chart chart,String description,int textColor,int background,int animateY,boolean leyenda){
        chart.getDescription().setText(description);
        chart.getDescription().setTextColor(textColor);
        chart.getDescription().setTextSize(15);
        chart.setBackgroundColor(background);
        chart.animateY(animateY);

        return chart;
    }




    private ArrayList<RadarEntry> getRadarEntriesChevrolet() {
        ArrayList<RadarEntry> entries = new ArrayList<>();
        for (int i = 0; i < valueChevrolet.length; i++)
            entries.add(new RadarEntry(valueChevrolet[i]));
        return entries;
    }

    private ArrayList<String> getVariable() {
        ArrayList<String> entries = new ArrayList<>();
        entries.addAll(Arrays.asList(variable));
        return entries;
    }


    //Eje horizontal o eje X
    private void axisX(XAxis axis){
        axis.setGranularityEnabled(true);
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setValueFormatter(new IndexAxisValueFormatter(months));
    }
    //Eje Vertical o eje Y lado izquierdo
    private void axisLeft(YAxis axis){
        axis.setSpaceTop(30);
        axis.setAxisMinimum(0);
        axis.setGranularity(20);
    }
    //Eje Vertical o eje Y lado Derecho
    private void axisRight(YAxis axis){
        axis.setEnabled(false);
    }

    //Crear graficas
    public void createCharts(){
        //RadarChart

        //En radar se valido la leyenda porque no podemos perzonalizarlo la leyenda se crea de acuerdo a los datos que se tienen dentro de la grafica.
        radarChart = (RadarChart) getSameChart(radarChart, "", Color.WHITE, Color.WHITE, 3000,false);
        radarChart.setData(getRadarData());
        radarChart.invalidate();
        axisX(radarChart.getXAxis());

    }

    //Carasteristicas comunes en dataset
    private DataSet getDataSame(DataSet dataSet){
        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(10);
        return dataSet;
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
