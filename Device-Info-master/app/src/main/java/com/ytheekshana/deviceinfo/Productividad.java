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

public class Productividad extends AppCompatActivity {
    Button siguiente;
    private Spinner  productividad_inexperto;
    static String  idproductividad, productividad_inexpertos,sumaTotals,scalculoderelevancia;
    String   sproductividad_inexperto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productividad);
        siguiente = findViewById(R.id.productividad);

        productividad_inexperto=(Spinner) findViewById(R.id.spinner1);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relevancia();
            }
        });
    }

    private void insertData() {
        sproductividad_inexperto=productividad_inexperto.getSelectedItem().toString();

        String a=Float.toString((Float.parseFloat(productividad_inexpertos)/Float.parseFloat(sumaTotals))*Float.parseFloat(sproductividad_inexperto));
        scalculoderelevancia=Float.toString(Float.parseFloat(a));


        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.101.2/proyecto/insertarproductividad.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        idproductividad= response.substring(response.lastIndexOf(' ') + 1);
                        Toast.makeText(Productividad.this, "Productividad Guardada", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Satisfaccion.class));
                        finish();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Productividad.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();

                params.put("productividad_inexperto", sproductividad_inexperto);
                params.put("calculoderelevancia", scalculoderelevancia);


                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Productividad.this);
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

                                    String  productividad_inexperto= object.getString("productividad_inexperto");
                                    productividad_inexpertos=productividad_inexperto;
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
                Toast.makeText(Productividad.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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