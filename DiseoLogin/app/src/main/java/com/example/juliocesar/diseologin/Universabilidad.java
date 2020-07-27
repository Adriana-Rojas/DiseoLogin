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

public class Universabilidad extends AppCompatActivity {
    Button siguiente;
    private Spinner  resolucion, lenguaje, fuente, contraste,idioma,uso;
    String  sresolucion, slenguaje, sfuente, scontraste,sidioma,suso;
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
                insertData();
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

       /* Login login=new Login();
        idadministrador=login.tipoid;*/

        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.112/proyecto/insertaruniversabilidad.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
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

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Universabilidad.this);
        requestQueue.add(request);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}