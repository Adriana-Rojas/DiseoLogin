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

public class Universabilidad extends AppCompatActivity {
    Button siguiente;
    private Spinner  resolucion, lenguaje, fuente, contraste,idioma,uso;
    String  sresolucion, slenguaje, sfuente, scontraste,sidioma,suso;
    static String iduniversabilidad,resolucions,lenguaje_clarols,fuentes,contrastes,idiomas,usos,sumaTotals,scalculoderelevancia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universabilidad);
        siguiente = findViewById(R.id.universabilidad);
        resolucion=(Spinner) findViewById(R.id.spinner1);
        lenguaje=(Spinner) findViewById(R.id.spinner2);
        fuente=(Spinner) findViewById(R.id.spinner3);
        contraste=(Spinner) findViewById(R.id.spinner4);
        idioma=(Spinner) findViewById(R.id.spinner5);
        uso=(Spinner) findViewById(R.id.spinner6);


        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relevancia();
            }
        });



    }

    private void insertData() {
        sresolucion= resolucion.getSelectedItem().toString();
        slenguaje= lenguaje.getSelectedItem().toString();
        sfuente= fuente.getSelectedItem().toString();
        scontraste= contraste.getSelectedItem().toString();
        sidioma= idioma.getSelectedItem().toString();
        suso= uso.getSelectedItem().toString();

        String a=Float.toString((Float.parseFloat(resolucions)/Float.parseFloat(sumaTotals))*Float.parseFloat(sresolucion));
        String b=Float.toString((Float.parseFloat(lenguaje_clarols)/Float.parseFloat(sumaTotals))*Float.parseFloat(slenguaje));
        String c=Float.toString((Float.parseFloat(fuentes)/Float.parseFloat(sumaTotals))*Float.parseFloat(sfuente));
        String d=Float.toString((Float.parseFloat(contrastes)/Float.parseFloat(sumaTotals))*Float.parseFloat(scontraste));
        String e=Float.toString((Float.parseFloat(idiomas)/Float.parseFloat(sumaTotals))*Float.parseFloat(sidioma));
        String f=Float.toString((Float.parseFloat(usos)/Float.parseFloat(sumaTotals))*Float.parseFloat(suso));
        scalculoderelevancia=Float.toString(Float.parseFloat(a)+Float.parseFloat(b)+Float.parseFloat(c)+Float.parseFloat(d)+Float.parseFloat(e)+Float.parseFloat(f));



        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.101.2/proyecto/insertaruniversabilidad.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        iduniversabilidad= response.substring(response.lastIndexOf(' ') + 1);
                        Toast.makeText(Universabilidad.this, "Universabilidad Guardada", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Carga_Cognitiva.class));
                        finish();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Universabilidad.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();

                params.put("resolucion", sresolucion);
                params.put("lenguaje", slenguaje);
                params.put("fuente", sfuente);
                params.put("contraste", scontraste);
                params.put("idioma", sidioma);
                params.put("uso", suso);
                params.put("calculoderelevancia", scalculoderelevancia);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Universabilidad.this);
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


                                    String resolucion= object.getString("resolucion");
                                    resolucions=resolucion;
                                    String lenguaje_clarol= object.getString("lenguaje_clarol");
                                    lenguaje_clarols=lenguaje_clarol;
                                    String  fuente= object.getString("fuente");
                                    fuentes=fuente;
                                    String  contraste= object.getString("contraste");
                                    contrastes=contraste;
                                    String  idioma= object.getString("idioma");
                                    idiomas=idioma;    String  uso= object.getString("uso");
                                    usos=uso;
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
                Toast.makeText(Universabilidad.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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