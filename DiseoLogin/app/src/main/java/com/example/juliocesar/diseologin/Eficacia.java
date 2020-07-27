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

public class Eficacia extends AppCompatActivity {
    Button siguiente;
    private Spinner  tareascompletadas,totaltareas,calculoterminaciontarea, calculoefectividad,numerofaltas,
            calculotiempo,calculoextensibilidad,calculoreusabilidad, calculoescalabilidad;

    String   stareascompletadas,stotaltareas,scalculoterminaciontarea, scalculoefectividad,snumerofaltas,
            scalculotiempo,scalculoextensibilidad,scalculoreusabilidad, scalculoescalabilidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eficacia);
        siguiente = findViewById(R.id.eficacia);

        tareascompletadas=(Spinner) findViewById(R.id.spinner1);
        totaltareas=(Spinner) findViewById(R.id.spinner2);

        numerofaltas=(Spinner) findViewById(R.id.spinner3);

        calculotiempo=(Spinner) findViewById(R.id.spinner4);
        calculoextensibilidad=(Spinner) findViewById(R.id.spinner5);
        calculoreusabilidad =(Spinner) findViewById(R.id.spinner6);
        calculoescalabilidad=(Spinner) findViewById(R.id.spinner7);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });
    }

    private void insertData() {
        stareascompletadas=tareascompletadas.getSelectedItem().toString();
        stotaltareas=totaltareas.getSelectedItem().toString();
        scalculoterminaciontarea=Integer.toString(Integer.parseInt(stareascompletadas)/Integer.parseInt(stotaltareas));

        snumerofaltas=numerofaltas.getSelectedItem().toString();
        scalculoefectividad=Integer.toString(Math.abs(1-Integer.parseInt(snumerofaltas)));

        scalculotiempo=calculotiempo.getSelectedItem().toString();
        scalculoextensibilidad=calculoextensibilidad.getSelectedItem().toString();
        scalculoreusabilidad =calculoreusabilidad.getSelectedItem().toString();
        scalculoescalabilidad=calculoescalabilidad.getSelectedItem().toString();

       /* Login login=new Login();
        idadministrador=login.tipoid;*/

        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.112/proyecto/insertareficacia.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Eficacia.this, "Eficacia Guardada", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Memorabilidad.class));
                        finish();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Eficacia.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();

                params.put("tareascompletadas", stareascompletadas);
                params.put("totaltareas", stotaltareas);
                params.put("calculoterminaciontarea", scalculoterminaciontarea);
                params.put("calculoefectividad", scalculoefectividad);
                params.put("numerofaltas", snumerofaltas);
                params.put("calculotiempo", scalculotiempo);
                params.put("calculoextensibilidad", scalculoextensibilidad);
                params.put("calculoreusabilidad", scalculoreusabilidad);
                params.put("calculoescalabilidad", scalculoescalabilidad);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Eficacia.this);
        requestQueue.add(request);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}