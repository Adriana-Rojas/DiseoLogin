package com.ytheekshana.deviceinfo;

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

import androidx.appcompat.app.AppCompatActivity;

public class Carga_Cognitiva extends AppCompatActivity {
    Button siguiente;
    private Spinner  multitareas, actividad_mental, dificultad_tarea, actividad_fisica, exigencia, inseguro;
    String  smultitareas, sactividad_mental, sdificultad_tarea, sactividad_fisica, sexigencia, sinseguro;
    static String idcargacognitiva,multitareass,actividad_mentals,dificultad_tareas,actividad_fisicas,exigencias,inseguros,sumaTotals,scalculoderelevancia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga__cognitiva);
        siguiente = findViewById(R.id.carga_cognitiva);
        multitareas=(Spinner) findViewById(R.id.spinner1);
        actividad_mental=(Spinner) findViewById(R.id.spinner2);
        dificultad_tarea=(Spinner) findViewById(R.id.spinner3);
        actividad_fisica=(Spinner) findViewById(R.id.spinner4);
        exigencia=(Spinner) findViewById(R.id.spinner5);
        inseguro=(Spinner) findViewById(R.id.spinner6);


        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relevancia();
            }
        });



    }

    private void insertData() {
        smultitareas= multitareas.getSelectedItem().toString();
        sactividad_mental= actividad_mental.getSelectedItem().toString();
        sdificultad_tarea= dificultad_tarea.getSelectedItem().toString();
        sactividad_fisica= actividad_fisica.getSelectedItem().toString();
        sexigencia= exigencia.getSelectedItem().toString();
        sinseguro= inseguro.getSelectedItem().toString();

        String a=Float.toString((Float.parseFloat(multitareass)/Float.parseFloat(sumaTotals))*Float.parseFloat(smultitareas));
        String b=Float.toString((Float.parseFloat(actividad_mentals)/Float.parseFloat(sumaTotals))*Float.parseFloat(sactividad_mental));
        String c=Float.toString((Float.parseFloat(dificultad_tareas)/Float.parseFloat(sumaTotals))*Float.parseFloat(sdificultad_tarea));
        String d=Float.toString((Float.parseFloat(actividad_fisicas)/Float.parseFloat(sumaTotals))*Float.parseFloat(sactividad_fisica));
        String e=Float.toString((Float.parseFloat(exigencias)/Float.parseFloat(sumaTotals))*Float.parseFloat(sexigencia));
        String f=Float.toString((Float.parseFloat(inseguros)/Float.parseFloat(sumaTotals))*Float.parseFloat(sinseguro));
        scalculoderelevancia=Float.toString(Float.parseFloat(a)+Float.parseFloat(b)+Float.parseFloat(c)+Float.parseFloat(d)+Float.parseFloat(e)+Float.parseFloat(f));



        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.41/proyecto/insertarcargacognitiva.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        idcargacognitiva= response.substring(response.lastIndexOf(' ') + 1);
                        Toast.makeText(Carga_Cognitiva.this, "Carga_cognitiva Guardada", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Usabilidad.class));
                        finish();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Carga_Cognitiva.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();

                params.put("multitareas", smultitareas);
                params.put("actividad_mental", sactividad_mental);
                params.put("dificultad_tarea", sdificultad_tarea);
                params.put("actividad_fisica", sactividad_fisica);
                params.put("exigencia", sexigencia);
                params.put("inseguro", sinseguro);
                params.put("calculoderelevancia", scalculoderelevancia);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Carga_Cognitiva.this);
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

                                    String multitareas= object.getString("multitareas");
                                    multitareass=multitareas;
                                    String   actividad_mental= object.getString("actividad_mental");
                                    actividad_mentals=actividad_mental;
                                    String  dificultad_tarea= object.getString("dificultad_tarea");
                                    dificultad_tareas=dificultad_tarea;
                                    String  actividad_fisica= object.getString("actividad_fisica");
                                    actividad_fisicas=actividad_fisica;
                                    String   exigencia= object.getString("exigencia");
                                    exigencias=exigencia;
                                    String  inseguro= object.getString("inseguro");
                                    inseguros=inseguro;
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
                Toast.makeText(Carga_Cognitiva.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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