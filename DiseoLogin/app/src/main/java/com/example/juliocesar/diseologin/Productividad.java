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

import java.util.HashMap;
import java.util.Map;

public class Productividad extends AppCompatActivity {
    Button siguiente;
    private Spinner  productividad_inexperto;

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
                insertData();
            }
        });
    }

    private void insertData() {
        sproductividad_inexperto=productividad_inexperto.getSelectedItem().toString();

       /* Login login=new Login();
        idadministrador=login.tipoid;*/

        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.112/proyecto/insertarproductividad.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
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

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Productividad.this);
        requestQueue.add(request);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}