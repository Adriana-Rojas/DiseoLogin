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

public class Seguridad extends AppCompatActivity {
    Button siguiente;
    private Spinner  seguridad,playstore,numeroserrores,tiempotarea,mensajes,prevencion,
            redundancia,enlaces;

    String   sseguridad,splaystore,scalculofrecuenciaerrores,snumeroserrores,stiempotarea,sfrecuenciaerrores,smensajes,sprevencion,
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
                insertData();
            }
        });
    }

    private void insertData() {
        sseguridad=seguridad.getSelectedItem().toString();
        splaystore=playstore.getSelectedItem().toString();
        snumeroserrores=numeroserrores.getSelectedItem().toString();
        stiempotarea=tiempotarea.getSelectedItem().toString();
        scalculofrecuenciaerrores=Integer.toString(Integer.parseInt(snumeroserrores)/Integer.parseInt(stiempotarea));
        sfrecuenciaerrores="1";// ojo aca es la id de la tabla frecuencia error
        smensajes=mensajes.getSelectedItem().toString();
        sprevencion=prevencion.getSelectedItem().toString();
        sredundancia=redundancia.getSelectedItem().toString();
        senlaces=enlaces.getSelectedItem().toString();

       /* Login login=new Login();
        idadministrador=login.tipoid;*/

        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.112/proyecto/insertarseguridad.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
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
                params.put("frecuenciaerrores", sfrecuenciaerrores);
                params.put("mensajes", smensajes);
                params.put("prevencion", sprevencion);
                params.put("redundancia", sredundancia);
                params.put("enlaces", senlaces);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Seguridad.this);
        requestQueue.add(request);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}