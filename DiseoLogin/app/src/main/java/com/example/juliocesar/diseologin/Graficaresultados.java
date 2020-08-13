package com.example.juliocesar.diseologin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

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


public class Graficaresultados extends AppCompatActivity {
    ListView listView;
    public static ArrayList<Employeevaluados> employeeArrayList = new ArrayList<>();
    String url = "http://192.168.1.112/proyecto/retrieveevaluados.php";
    static String idaplicacion;
   static  Float fcalcularusabilidad=0.f,feficiencia=0.f,feficacia=0.f,fmemorabilidad=0.f,fproductividad=0.f,fsatisfaccion=0.f,fseguridad=0.f,funiversabilidad=0.f,fcargacognitiva=0.f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        retrieveData();
        super.onCreate(savedInstanceState);
        listView = findViewById(R.id.myListView);


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
                    Toast.makeText(Graficaresultados.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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



}
