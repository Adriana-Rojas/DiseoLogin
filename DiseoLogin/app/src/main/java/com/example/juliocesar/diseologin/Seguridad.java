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

public class Seguridad extends AppCompatActivity {
    Button siguiente;
    private Spinner  seguridad,playstore,numeroserrores,tiempotarea,mensajes,prevencion,
            redundancia,enlaces;

    static String  idseguridad,seguridads,playstores,calculofrecuenciaerroress,mensajess,prevencions,redundancias,enlacess,sumaTotals,scalculoderelevancia;
    String   sseguridad,splaystore,scalculofrecuenciaerrores,snumeroserrores,stiempotarea,smensajes,sprevencion,
            sredundancia,senlaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad);
        siguiente = findViewById(R.id.seguridad);
        seguridad=(Spinner) findViewById(R.id.spinner1);
        playstore=(Spinner) findViewById(R.id.spinner2);
        numeroserrores=(Spinner) findViewById(R.id.spinner3);
        tiempotarea=(Spinner) findViewById(R.id.spinner4);
        mensajes=(Spinner) findViewById(R.id.spinner5);
        prevencion=(Spinner) findViewById(R.id.spinner6);
        redundancia=(Spinner) findViewById(R.id.spinner7);
        enlaces=(Spinner) findViewById(R.id.spinner8);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relevancia();
            }
        });
    }

    private void insertData() {
        sseguridad=seguridad.getSelectedItem().toString();
        splaystore=playstore.getSelectedItem().toString();
        snumeroserrores=numeroserrores.getSelectedItem().toString();
        stiempotarea=tiempotarea.getSelectedItem().toString();
        scalculofrecuenciaerrores=Integer.toString(Integer.parseInt(snumeroserrores)/Integer.parseInt(stiempotarea));
        smensajes=mensajes.getSelectedItem().toString();
        sprevencion=prevencion.getSelectedItem().toString();
        sredundancia=redundancia.getSelectedItem().toString();
        senlaces=enlaces.getSelectedItem().toString();

        String a=Float.toString((Float.parseFloat(seguridads)/Float.parseFloat(sumaTotals))*Float.parseFloat(sseguridad));
        String b=Float.toString((Float.parseFloat(playstores)/Float.parseFloat(sumaTotals))*Float.parseFloat(splaystore));
        String c=Float.toString((Float.parseFloat(calculofrecuenciaerroress)/Float.parseFloat(sumaTotals))*Float.parseFloat(scalculofrecuenciaerrores));
        String d=Float.toString((Float.parseFloat(mensajess)/Float.parseFloat(sumaTotals))*Float.parseFloat(smensajes));
        String e=Float.toString((Float.parseFloat(prevencions)/Float.parseFloat(sumaTotals))*Float.parseFloat(sprevencion));
        String f=Float.toString((Float.parseFloat(redundancias)/Float.parseFloat(sumaTotals))*Float.parseFloat(sredundancia));
        String g=Float.toString((Float.parseFloat(enlacess)/Float.parseFloat(sumaTotals))*Float.parseFloat(senlaces));
        String h=Float.toString((Float.parseFloat(redundancias)/Float.parseFloat(sumaTotals))*Float.parseFloat(sredundancia));
        scalculoderelevancia=Float.toString(Float.parseFloat(a)+Float.parseFloat(b)+Float.parseFloat(c)+Float.parseFloat(d)+Float.parseFloat(e)+Float.parseFloat(f));


        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.101.2/proyecto/insertarseguridad.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        idseguridad= response.substring(response.lastIndexOf(' ') + 1);
                        Toast.makeText(Seguridad.this, "Seguridad Guardada", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Universabilidad.class));
                        finish();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Seguridad.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();

                params.put("seguridad", sseguridad);
                params.put("playstore", splaystore);
                params.put("numeroserrores", snumeroserrores);
                params.put("tiempotarea", stiempotarea);
                params.put("calculofrecuenciaerrores", scalculofrecuenciaerrores);
                params.put("mensajes", smensajes);
                params.put("prevencion", sprevencion);
                params.put("redundancia", sredundancia);
                params.put("enlaces", senlaces);
                params.put("calculoderelevancia", scalculoderelevancia);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Seguridad.this);
        requestQueue.add(request);
    }
    private void relevancia() {
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.101.2/proyecto/buscarrelevancia.php",
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

                                    String  seguridad= object.getString("seguridad");
                                    seguridads=seguridad;
                                    String  playstore= object.getString("playstore");
                                    playstores=playstore;
                                    String  calculofrecuenciaerrores= object.getString("calculofrecuenciaerrores");
                                    calculofrecuenciaerroress=calculofrecuenciaerrores;
                                    String  mensajes= object.getString("mensajes");
                                    mensajess=mensajes;
                                    String  prevencion= object.getString("prevencion");
                                    prevencions=prevencion;
                                    String  redundancia= object.getString("redundancia");
                                    redundancias=redundancia;
                                    String  enlaces= object.getString("enlaces");
                                    enlacess=enlaces;
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
                Toast.makeText(Seguridad.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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