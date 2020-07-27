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

public class Eficiencia extends AppCompatActivity {
    Button siguiente;
    private Spinner  tiempoinicio,tiemporespuesta,numerodeevaluaciones,calculartiemporespuesta,consumoram,
            consumomedram,consumomaxram,calculoram,consumocpu,consumomedcpu,consumomaxcpu,calculocpu,canticonsumida,
            consumomedbateria,calculobateria,esfuerzo,completartarea,calculoesfuerzo,efectividadrelativatarea,costototal;
    String  stiempoinicio,stiemporespuesta,snumerodeevaluaciones,scalculartiemporespuesta,sconsumoram,
            sconsumomedram,sconsumomaxram,scalculoram,sconsumocpu,sconsumomedcpu,sconsumomaxcpu,scalculocpu,scanticonsumida,
            sconsumomedbateria,scalculobateria,sesfuerzo,scompletartarea,scalculoesfuerzo,sefectividadrelativatarea,scostototal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eficiencia);
        siguiente = findViewById(R.id.eficiencia);
        tiempoinicio=(Spinner) findViewById(R.id.spinner1);
        stiemporespuesta="3";
        snumerodeevaluaciones="3";
        calculartiemporespuesta=(Spinner) findViewById(R.id.spinner2);
        sconsumoram="3";
        sconsumomedram="3";
        sconsumomaxram="3";
        calculoram=(Spinner) findViewById(R.id.spinner3);
        sconsumocpu="3";
        sconsumomedcpu="3";
        sconsumomaxcpu="3";
        calculocpu=(Spinner) findViewById(R.id.spinner4);
        scanticonsumida="3";
        sconsumomedbateria="3";
        calculobateria=(Spinner) findViewById(R.id.spinner5);
        esfuerzo=(Spinner) findViewById(R.id.spinner6);
        scompletartarea="3";
        scalculoesfuerzo="3";
        sefectividadrelativatarea="3";
        costototal=(Spinner) findViewById(R.id.spinner7);


        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });



    }

    private void insertData() {
        stiempoinicio = tiempoinicio.getSelectedItem().toString();
        scalculartiemporespuesta = calculartiemporespuesta.getSelectedItem().toString();
        scalculoram= calculoram.getSelectedItem().toString();
        scalculocpu= calculocpu.getSelectedItem().toString();
        scalculobateria= calculobateria.getSelectedItem().toString();
        sesfuerzo= esfuerzo.getSelectedItem().toString();
        scostototal= costototal.getSelectedItem().toString();

       /* Login login=new Login();
        idadministrador=login.tipoid;*/

        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.112/proyecto/insertareficiencia.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Eficiencia.this, "Eficiencia Guardada", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Eficacia.class));
                        finish();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                 Toast.makeText(Eficiencia.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();

                params.put("tiempoinicio", stiempoinicio);
                params.put("tiemporespuesta", stiemporespuesta);
                params.put("numerodeevaluaciones", snumerodeevaluaciones);
                params.put("calculartiemporespuesta", scalculartiemporespuesta);
                params.put("consumoram", sconsumoram);
                params.put("consumomedram", sconsumomedram);
                params.put("consumomaxram", sconsumomaxram);
                params.put("calculoram", scalculoram);
                params.put("consumocpu", sconsumocpu);
                params.put("consumomedcpu", sconsumomedcpu);
                params.put("consumomaxcpu", sconsumomaxcpu);
                params.put("calculocpu", scalculocpu);
                params.put("canticonsumida", scanticonsumida);
                params.put("consumomedbateria", sconsumomedbateria);
                params.put("calculobateria", scalculobateria);
                params.put("esfuerzo", sesfuerzo);
                params.put("completartarea", scompletartarea);
                params.put("calculoesfuerzo", scalculoesfuerzo);
                params.put("efectividadrelativatarea", sefectividadrelativatarea);
                params.put("costototal", scostototal);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Eficiencia.this);
        requestQueue.add(request);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}