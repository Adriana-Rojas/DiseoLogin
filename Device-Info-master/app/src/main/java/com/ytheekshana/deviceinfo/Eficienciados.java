package com.ytheekshana.deviceinfo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
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

import androidx.appcompat.app.AppCompatActivity;

public class Eficienciados extends AppCompatActivity {

    Button siguiente;
    Long uptime;
    int minutos=5;
    EditText  enumerodeevaluaciones;

    private Spinner  tiempoinicio,tiemporespuesta,numerodeevaluaciones,calculartiemporespuesta,consumoram,
            consumomedram,consumomaxram,consumocpu,consumomedcpu,consumomaxcpu,canticonsumida,
            consumomedbateria,esfuerzo,efectividadrelativatarea,costototal;
    String  stiempoinicio,stiemporespuesta,snumerodeevaluaciones,scalculartiemporespuesta,sconsumoram,
            sconsumomedram,sconsumomaxram,scalculoram,sconsumocpu,sconsumomedcpu,sconsumomaxcpu,scalculocpu,siniciobateria,
            sfinalbateria,scalculobateria,sesfuerzo,sefectividadrelativatarea,scostototal,scalculocostoeconomico;
    static String  idficiencia,tiempoinicios,calculartiemporespuestas,calculorams,calculocpus,calculobaterias,esfuerzos,calculocostoeconomicos,sumaTotals,scalculoderelevancia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_eficiencia_dos);
        TextView chronometro = this.findViewById(R.id.chronometro);
        chronometro.setText(tabDashboard.chronometro.getText());
        stiemporespuesta="00:"+tabDashboard.chronometro.getText();

        siguiente = findViewById(R.id.eficiencia);
        tiempoinicio=(Spinner) findViewById(R.id.spinner1);//preguntar
        tiemporespuesta=(Spinner) findViewById(R.id.spinner3);
        //ram
        sconsumoram=Integer.toString(tabDashboard.sconsumoramtotal);
        sconsumomedram=Integer.toString(tabDashboard.scalculoram);//aplicacion
        sconsumomaxram=Integer.toString(tabDashboard.sconsumorammax);//aplicacion
        if(Integer.parseInt(Integer.toString(tabDashboard.scalculoram))<68){
            scalculoram="10";
        }else  if(Integer.parseInt(Integer.toString(tabDashboard.scalculoram))<71){
            scalculoram="7.5";
        }else if(Integer.parseInt(Integer.toString(tabDashboard.scalculoram))<76){
            scalculoram="5";
        }else {
            scalculoram="2.5";
        }

        //cpu
        sconsumocpu=Integer.toString(tabDashboard.sconsumocputotal);
        sconsumomedcpu=Integer.toString(tabDashboard.scalculocpu);
        sconsumomaxcpu=Integer.toString(tabDashboard.sconsumocpumax);
        if(Integer.parseInt(Integer.toString(tabDashboard.scalculocpu))<56){
            scalculocpu="10";
        }else  if(Integer.parseInt(Integer.toString(tabDashboard.scalculocpu))<69){
            scalculocpu="7.5";
        }else if(Integer.parseInt(Integer.toString(tabDashboard.scalculocpu))<82){
            scalculocpu="5";
        }else {
            scalculocpu="2.5";
        }

        //bateria
        siniciobateria=Integer.toString(tabDashboard.siniciobateria);
        sfinalbateria=Integer.toString(tabDashboard.sfinalbateria);
        int scalculobateria2=Integer.parseInt(Integer.toString((tabDashboard.siniciobateria-tabDashboard.sfinalbateria)));
        if(scalculobateria2<2){
            scalculobateria="10";
        }else  if(scalculobateria2<4){
            scalculobateria="7.5";
        }else if(scalculobateria2<6){
            scalculobateria="5";
        }else {
            scalculobateria="2.5";
        }


        esfuerzo=(Spinner) findViewById(R.id.spinner6);//preguntar
        costototal=(Spinner) findViewById(R.id.spinner7);




        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relevancia();
            }
        });

    }


    private void insertData() {
        if(Integer.parseInt(tiempoinicio.getSelectedItem().toString())<3){
            stiempoinicio="10";
        }else  if(Integer.parseInt(tiempoinicio.getSelectedItem().toString())<5){
            stiempoinicio="7.5";
        }else if(Integer.parseInt(tiempoinicio.getSelectedItem().toString())<7){
            stiempoinicio="5";
        }else {
            stiempoinicio="2.5";
        }
        scalculartiemporespuesta= tiemporespuesta.getSelectedItem().toString();
        sesfuerzo= esfuerzo.getSelectedItem().toString();
        scostototal= costototal.getSelectedItem().toString();

        enumerodeevaluaciones=(EditText)findViewById(R.id.textevaluaciones);//preguntar
        snumerodeevaluaciones = enumerodeevaluaciones.getText().toString();

        String a=Float.toString((Float.parseFloat(tiempoinicios)/Float.parseFloat(sumaTotals))*Float.parseFloat(stiempoinicio));
        String b=Float.toString((Float.parseFloat(calculartiemporespuestas)/Float.parseFloat(sumaTotals))*Float.parseFloat(scalculartiemporespuesta));
        String c=Float.toString((Float.parseFloat(calculorams)/Float.parseFloat(sumaTotals))*Float.parseFloat(scalculoram));
        String d=Float.toString((Float.parseFloat(calculocpus)/Float.parseFloat(sumaTotals))*Float.parseFloat(scalculocpu));
        String e=Float.toString((Float.parseFloat(calculobaterias)/Float.parseFloat(sumaTotals))*Float.parseFloat(scalculobateria));
        String f=Float.toString((Float.parseFloat(esfuerzos)/Float.parseFloat(sumaTotals))*Float.parseFloat(sesfuerzo));
        String g=Float.toString((Float.parseFloat(calculocostoeconomicos)/Float.parseFloat(sumaTotals))*Float.parseFloat(scostototal));
        scalculoderelevancia=Float.toString(Float.parseFloat(a)+Float.parseFloat(b)+Float.parseFloat(c)+Float.parseFloat(d)+Float.parseFloat(e)+Float.parseFloat(f)+Float.parseFloat(g));



        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.41/proyecto/insertareficiencia.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        idficiencia= response.substring(response.lastIndexOf(' ') + 1);
                        Toast.makeText(Eficienciados.this, "Eficiencia Guardada", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Eficacia.class));
                        finish();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Eficienciados.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();

                params.put("tiempoinicio", stiempoinicio);
                params.put("tiemporespuesta", stiemporespuesta);
                params.put("numerodeevaluaciones", snumerodeevaluaciones);//
                params.put("calculartiemporespuesta", scalculartiemporespuesta);//
                params.put("consumoram", sconsumoram);
                params.put("consumomedram", sconsumomedram);
                params.put("consumomaxram", sconsumomaxram);
                params.put("calculoram", scalculoram);
                params.put("consumocpu", sconsumocpu);
                params.put("consumomedcpu", sconsumomedcpu);
                params.put("consumomaxcpu", sconsumomaxcpu);
                params.put("calculocpu", scalculocpu);
                params.put("iniciobateria", siniciobateria);
                params.put("finalbateria", sfinalbateria);
                params.put("calculobateria", scalculobateria);
                params.put("esfuerzo", sesfuerzo);
               //params.put("efectividadrelativatarea", sefectividadrelativatarea);
                params.put("costototal", scostototal);
                //params.put("calculocostoeconomico", scalculocostoeconomico);
                params.put("calculoderelevancia", scalculoderelevancia);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Eficienciados.this);
        requestQueue.add(request);
    }

    private void relevancia() {
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.41/proyecto/buscarrelevancia.php",
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
                Toast.makeText(Eficienciados.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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