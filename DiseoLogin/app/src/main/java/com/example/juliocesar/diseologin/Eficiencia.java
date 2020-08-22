package com.example.juliocesar.diseologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Eficiencia extends AppCompatActivity {
    Button siguiente;
    private Spinner  tiempoinicio,tiemporespuesta,numerodeevaluaciones,calculartiemporespuesta,consumoram,
            consumomedram,consumomaxram,calculoram,consumocpu,consumomedcpu,consumomaxcpu,calculocpu,canticonsumida,
            consumomedbateria,calculobateria,esfuerzo,efectividadrelativatarea,costototal;
    String  stiempoinicio,stiemporespuesta,snumerodeevaluaciones,scalculartiemporespuesta,sconsumoram,
            sconsumomedram,sconsumomaxram,scalculoram,sconsumocpu,sconsumomedcpu,sconsumomaxcpu,scalculocpu,scanticonsumida,
            sconsumomedbateria,scalculobateria,sesfuerzo,sefectividadrelativatarea,scostototal,scalculocostoeconomico;
    static String  idficiencia,tiempoinicios,calculartiemporespuestas,calculorams,calculocpus,calculobaterias,esfuerzos,calculocostoeconomicos,sumaTotals,scalculoderelevancia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eficiencia);
        siguiente = findViewById(R.id.eficiencia);
        tiempoinicio=(Spinner) findViewById(R.id.spinner1);
        stiemporespuesta="3";
        snumerodeevaluaciones="3";
        calculartiemporespuesta=(Spinner) findViewById(R.id.spinner2);
        sconsumoram="3";
        sconsumomedram="3";
        sconsumomaxram="3";
        calculoram=(Spinner) findViewById(R.id.spinner3);
        sconsumocpu="3";
        sconsumomedcpu="3";
        sconsumomaxcpu="3";
        calculocpu=(Spinner) findViewById(R.id.spinner4);
        scanticonsumida="3";
        sconsumomedbateria="3";
        calculobateria=(Spinner) findViewById(R.id.spinner5);
        esfuerzo=(Spinner) findViewById(R.id.spinner6);
        sefectividadrelativatarea="3";
        costototal=(Spinner) findViewById(R.id.spinner7);


        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relevancia();
            }
        });



    }

    private void insertData() {
        stiempoinicio = tiempoinicio.getSelectedItem().toString();
        scalculartiemporespuesta = calculartiemporespuesta.getSelectedItem().toString();
        scalculoram= calculoram.getSelectedItem().toString();
        scalculocpu= calculocpu.getSelectedItem().toString();
        scalculobateria= calculobateria.getSelectedItem().toString();
        sesfuerzo= esfuerzo.getSelectedItem().toString();
        scostototal= costototal.getSelectedItem().toString();
        scalculocostoeconomico=Integer.toString((Integer.parseInt(sefectividadrelativatarea))/(Integer.parseInt(scostototal)));

        String a=Float.toString((Float.parseFloat(tiempoinicios)/Float.parseFloat(sumaTotals))*Float.parseFloat(stiempoinicio));
        String b=Float.toString((Float.parseFloat(calculartiemporespuestas)/Float.parseFloat(sumaTotals))*Float.parseFloat(scalculartiemporespuesta));
        String c=Float.toString((Float.parseFloat(calculorams)/Float.parseFloat(sumaTotals))*Float.parseFloat(scalculoram));
        String d=Float.toString((Float.parseFloat(calculocpus)/Float.parseFloat(sumaTotals))*Float.parseFloat(scalculocpu));
        String e=Float.toString((Float.parseFloat(calculobaterias)/Float.parseFloat(sumaTotals))*Float.parseFloat(scalculobateria));
        String f=Float.toString((Float.parseFloat(esfuerzos)/Float.parseFloat(sumaTotals))*Float.parseFloat(sesfuerzo));
        String g=Float.toString((Float.parseFloat(calculocostoeconomicos)/Float.parseFloat(sumaTotals))*Float.parseFloat(scalculocostoeconomico));
        scalculoderelevancia=Float.toString(Float.parseFloat(a)+Float.parseFloat(b)+Float.parseFloat(c)+Float.parseFloat(d)+Float.parseFloat(e)+Float.parseFloat(f)+Float.parseFloat(g));



        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.101.5/proyecto/insertareficiencia.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        idficiencia= response.substring(response.lastIndexOf(' ') + 1);
                        Toast.makeText(Eficiencia.this, "Eficiencia Guardada", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Eficacia.class));
                        finish();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                 Toast.makeText(Eficiencia.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();

                params.put("tiempoinicio", stiempoinicio);
                params.put("tiemporespuesta", stiemporespuesta);
                params.put("numerodeevaluaciones", snumerodeevaluaciones);
                params.put("calculartiemporespuesta", scalculartiemporespuesta);
                params.put("consumoram", sconsumoram);
                params.put("consumomedram", sconsumomedram);
                params.put("consumomaxram", sconsumomaxram);
                params.put("calculoram", scalculoram);
                params.put("consumocpu", sconsumocpu);
                params.put("consumomedcpu", sconsumomedcpu);
                params.put("consumomaxcpu", sconsumomaxcpu);
                params.put("calculocpu", scalculocpu);
                params.put("canticonsumida", scanticonsumida);
                params.put("consumomedbateria", sconsumomedbateria);
                params.put("calculobateria", scalculobateria);
                params.put("esfuerzo", sesfuerzo);
                params.put("efectividadrelativatarea", sefectividadrelativatarea);
                params.put("$costototal", scostototal);
                params.put("calculocostoeconomico", scalculocostoeconomico);
                params.put("calculoderelevancia", scalculoderelevancia);
                params.put("calculoderelevancia", scalculoderelevancia);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Eficiencia.this);
        requestQueue.add(request);
    }
    private void relevancia() {
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.101.5/proyecto/buscarrelevancia.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try{

                            JSONObject jsonObject = new JSONObject(response);
                            String sucess = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("relevancia");

                            if(sucess.equals("1")){

                                for(int i=0;i<jsonArray.length();i++){

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String  tiempoinicio= object.getString("tiempoinicio");
                                    tiempoinicios=tiempoinicio;
                                    String  calculartiemporespuesta= object.getString("calculartiemporespuesta");
                                    calculartiemporespuestas=calculartiemporespuesta;
                                    String calculoram= object.getString("calculoram");
                                    calculorams=calculoram;
                                    String  calculocpu= object.getString("calculocpu");
                                    calculocpus=calculocpu;
                                    String  calculobateria= object.getString("calculobateria");
                                    calculobaterias=calculobateria;
                                    String  esfuerzo= object.getString("esfuerzo");
                                    esfuerzos=esfuerzo;
                                    String   calculocostoeconomico= object.getString("calculocostoeconomico");
                                    calculocostoeconomicos=calculocostoeconomico;
                                    String sumaTotal= object.getString("sumaTotal");
                                    sumaTotals=sumaTotal;
                                    insertData();

                                }
                            }
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Eficiencia.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                //   params.put("id",id);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}