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

public class Memorabilidad extends AppCompatActivity {
    Button siguiente;
    private Spinner  rapidez,dificultad,aprendizaje,facilidad;

    String   srapidez,sdificultad,saprendizaje,sfacilidad,scalculoderelevancia;
    static String rapidezs,dificultads,aprendizajes,facilidads,sumaTotals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorabilidad);
        siguiente = findViewById(R.id.memorabilidad);

        rapidez=(Spinner) findViewById(R.id.spinner1);
        dificultad=(Spinner) findViewById(R.id.spinner2);
        aprendizaje=(Spinner) findViewById(R.id.spinner3);
        facilidad=(Spinner) findViewById(R.id.spinner4);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relevancia();
            }
        });
    }

    private void insertData() {
        srapidez=rapidez.getSelectedItem().toString();
        sdificultad=  dificultad.getSelectedItem().toString();
        saprendizaje=aprendizaje.getSelectedItem().toString();
        sfacilidad =facilidad.getSelectedItem().toString();

        String a=Float.toString((Float.parseFloat(rapidezs)/Float.parseFloat(sumaTotals))*Float.parseFloat(srapidez));
        String b=Float.toString((Float.parseFloat(dificultads)/Float.parseFloat(sumaTotals))*Float.parseFloat(sdificultad));
        String c=Float.toString((Float.parseFloat(aprendizajes)/Float.parseFloat(sumaTotals))*Float.parseFloat(saprendizaje));
        String d=Float.toString((Float.parseFloat(facilidads)/Float.parseFloat(sumaTotals))*Float.parseFloat(sfacilidad));
        scalculoderelevancia=Float.toString(Float.parseFloat(a)+Float.parseFloat(b)+Float.parseFloat(c)+Float.parseFloat(d));


        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.112/proyecto/insertarmemorabilidad.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Memorabilidad.this, "Memorabilidad Guardada", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Productividad.class));
                        finish();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Memorabilidad.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();


                params.put("rapidez", srapidez);
                params.put("dificultad", sdificultad);
                params.put("aprendizaje", saprendizaje);
                params.put("facilidad", sfacilidad);
                params.put("calculoderelevancia", scalculoderelevancia);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Memorabilidad.this);
        requestQueue.add(request);
    }
    private void relevancia() {
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.112/proyecto/buscarrelevancia.php",
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

                                    String rapidez= object.getString("rapidez");
                                    rapidezs=rapidez;
                                    String   dificultad= object.getString("dificultad");
                                    dificultads=dificultad;
                                    String aprendizaje= object.getString("aprendizaje");
                                    aprendizajes=aprendizaje;
                                    String  facilidad= object.getString("facilidad");
                                    facilidads=facilidad;
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
                Toast.makeText(Memorabilidad.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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