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

public class Memorabilidad extends AppCompatActivity {
    Button siguiente;
    private Spinner  rapidez,dificultad,aprendizaje,facilidad;

    String   srapidez,sdificultad,saprendizaje,sfacilidad;


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
                insertData();
            }
        });
    }

    private void insertData() {
        srapidez=rapidez.getSelectedItem().toString();
        sdificultad=  dificultad.getSelectedItem().toString();
        saprendizaje=aprendizaje.getSelectedItem().toString();
        sfacilidad =facilidad.getSelectedItem().toString();

       /* Login login=new Login();
        idadministrador=login.tipoid;*/

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

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Memorabilidad.this);
        requestQueue.add(request);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}