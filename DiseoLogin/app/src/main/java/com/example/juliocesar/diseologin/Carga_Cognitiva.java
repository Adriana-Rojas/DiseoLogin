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

public class Carga_Cognitiva extends AppCompatActivity {
    Button siguiente;
    private Spinner  multitareas, actividad_mental, dificultad_tarea, actividad_fisica, exigencia, inseguro;
    String  smultitareas, sactividad_mental, sdificultad_tarea, sactividad_fisica, sexigencia, sinseguro;
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
                insertData();
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

       /* Login login=new Login();
        idadministrador=login.tipoid;*/

        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.112/proyecto/insertarcargacognitiva.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Carga_Cognitiva.this, "Carga_cognitiva Guardada", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Resultado.class));
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

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Carga_Cognitiva.this);
        requestQueue.add(request);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}