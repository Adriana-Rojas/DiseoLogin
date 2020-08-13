package com.example.juliocesar.diseologin;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class GraficaEvaluados extends AppCompatActivity {
    ListView listView;
    public static ArrayList<Employeevaluados> employeeArrayList = new ArrayList<>();
    String url = "http://192.168.1.112/proyecto/retrieveevaluados.php";
    static String idaplicacion;
   static  Float fcalcularusabilidad=0.f,feficiencia=0.f,feficacia=0.f,fmemorabilidad=0.f,fproductividad=0.f,fsatisfaccion=0.f,fseguridad=0.f,funiversabilidad=0.f,fcargacognitiva=0.f;

    private BarChart barChart;
    //Eje X
    private String[]factores=new String[]{"Eficiencia","Eficacia","Memorabilidad","Productividad","Satisfaccion","Seguridad","Universabilidad","Carga cognitiva"};
    //Eje Y
    private Float [] sale=new Float[] {feficiencia,feficacia,fmemorabilidad,fproductividad,fsatisfaccion,fseguridad,funiversabilidad,fcargacognitiva};

    //Colors
    private  int [] colors=new int[]{
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
        retrieveData();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafica);

        barChart = (BarChart) findViewById(R.id.barChart);
        listView = findViewById(R.id.myListView);
        createCharts();

        Button btn = (Button) findViewById(R.id.siguiente);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), GraficadosEvaluados.class);
                startActivityForResult(intent, 0);
            }
        });

    }

        public void retrieveData(){

            final String id = Login.tipoid;
            final String idaplicativo = Select_Evaluados.idaplicacion;
            StringRequest request = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            employeeArrayList.clear();
                            try{

                                JSONObject jsonObject = new JSONObject(response);
                                String sucess = jsonObject.getString("success");
                                JSONArray jsonArray = jsonObject.getJSONArray("usabilidad");

                                if(sucess.equals("1")){
                                    int cantidad=0;
                                    for(int i=0;i<jsonArray.length();i++){

                                        JSONObject object = jsonArray.getJSONObject(i);
                                        cantidad=cantidad+1;
                                        String id = object.getString("id");
                                        String aplicativo = object.getString("aplicativo");
                                        String nombre = object.getString("nombre");
                                        String calcularusabilidad = object.getString("calcularusabilidad");
                                        fcalcularusabilidad= fcalcularusabilidad+Float.parseFloat (calcularusabilidad);
                                        String eficiencia = object.getString("eficiencia");
                                        feficiencia= feficiencia+Float.parseFloat (eficiencia);
                                        String eficacia = object.getString("eficacia");
                                        feficacia= feficacia+Float.parseFloat (eficacia);
                                        String memorabilidad = object.getString("memorabilidad");
                                        fmemorabilidad=fmemorabilidad+ Float.parseFloat (memorabilidad);
                                        String productividad = object.getString("productividad");
                                        fproductividad= fproductividad+Float.parseFloat (productividad);
                                        String satisfaccion = object.getString("satisfaccion");
                                        fsatisfaccion= fsatisfaccion+Float.parseFloat (satisfaccion);
                                        String seguridad = object.getString("seguridad");
                                        fseguridad=fseguridad+ Float.parseFloat (seguridad);
                                        String universabilidad = object.getString("universabilidad");
                                        funiversabilidad= funiversabilidad+Float.parseFloat (universabilidad);
                                        String cargacognitiva = object.getString("cargacognitiva");
                                        fcargacognitiva= fcargacognitiva+Float.parseFloat (cargacognitiva);
                                    }
                                    fcalcularusabilidad= fcalcularusabilidad/cantidad;
                                    feficiencia= feficiencia*10/cantidad;
                                    feficacia= feficacia*10/cantidad;
                                    fmemorabilidad=fmemorabilidad*10/cantidad;
                                    fproductividad= fproductividad*10/cantidad;
                                    fsatisfaccion= fsatisfaccion*10/cantidad;
                                    fseguridad=fseguridad*10/cantidad;
                                    funiversabilidad= funiversabilidad*10/cantidad;
                                    fcargacognitiva= fcargacognitiva*10/cantidad;
                                   
                                }
                            }
                            catch (JSONException e){
                                e.printStackTrace();
                            }
                        }

                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(GraficaEvaluados.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

                    params.put("id",id);
                    params.put("idaplicativo",idaplicativo);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(request);

        }

    //Carasteristicas comunes en las graficas
    private Chart getSameChart(Chart chart,String description,int textColor,int background,int animateY,boolean leyenda){
        chart.getDescription().setText(description);
        chart.getDescription().setTextColor(textColor);
        chart.getDescription().setTextSize(15);
        chart.setBackgroundColor(background);
        chart.animateY(animateY);


        if(leyenda)
            legend(chart);
        return chart;
    }

    private void legend(Chart chart) {
        Legend legend = chart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.CENTER); // set vertical alignment for legend
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT); // set horizontal alignment for legend
        legend.setOrientation(Legend.LegendOrientation.VERTICAL); // set orientation for legend
        legend.setDrawInside(false);

        ArrayList<LegendEntry> entries = new ArrayList<>();
        for (int i = 0; i < factores.length; i++) {
            LegendEntry entry = new LegendEntry();
            entry.formColor = colors[i];
            entry.label = factores[i];
            entries.add(entry);
        }
        legend.setCustom(entries);
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
        axis.setLabelRotationAngle(270);
        axis.setValueFormatter(new IndexAxisValueFormatter(factores));
    }
    //Eje Vertical o eje Y lado izquierdo
    private void axisLeft(YAxis axis){
        axis.setSpaceTop(1);
        axis.setAxisMinimum(0);
        axis.setAxisMaximum(50);
    }
    //Eje Vertical o eje Y lado Derecho
    private void axisRight(YAxis axis){
        axis.setEnabled(false);
    }

    //Crear graficas
    public void createCharts(){
        //BarChart
        barChart=(BarChart)getSameChart(barChart," ",Color.WHITE,Color.WHITE,3000,true);
        //barChart.setDrawGridBackground(true);
        barChart.setDrawBarShadow(true);
        barChart.setData(getBarData());
        barChart.invalidate();
        //barChart.getLegend().setEnabled(false);
        axisX(barChart.getXAxis());
        axisLeft(barChart.getAxisLeft());
        axisRight(barChart.getAxisRight());
    }

    //Carasteristicas comunes en dataset
    private DataSet getDataSame(DataSet dataSet){
        dataSet.setColors(colors);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(10);
        return dataSet;
    }

    private BarData getBarData(){
        BarDataSet barDataSet=(BarDataSet)getDataSame(new BarDataSet(getBarEntries(),""));
        barDataSet.setBarShadowColor(Color.WHITE);
        BarData barData=new BarData(barDataSet);
        barData.setBarWidth(0.45f);
        return barData;
    }

}
