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

public class Usabilidad extends AppCompatActivity {
    Button siguiente;

    String  aplicativo,eficiencia,eficacia,memorabilidad,productividad,satisfaccion,seguridad,universabilidad,cargacognitiva,calcularusabilidad;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usabilidad);
        siguiente = findViewById(R.id.resultado);
         insertData();
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });
    }

    public void insertData() {

        aplicativo="819";
        eficiencia=Eficiencia.scalculoderelevancia;
        eficacia=Eficacia.scalculoderelevancia;
        memorabilidad=Memorabilidad.scalculoderelevancia;
        productividad=Productividad.scalculoderelevancia;
        satisfaccion=Satisfaccion.scalculoderelevancia;
        seguridad=Seguridad.scalculoderelevancia;
        universabilidad=Universabilidad.scalculoderelevancia;
        cargacognitiva=Carga_Cognitiva.scalculoderelevancia;
        calcularusabilidad=Float.toString((Float.parseFloat(eficiencia)+Float.parseFloat(eficacia)+Float.parseFloat(memorabilidad)+Float.parseFloat(productividad)+Float.parseFloat(satisfaccion)+Float.parseFloat(seguridad)+Float.parseFloat(universabilidad)+Float.parseFloat(cargacognitiva))/10*100);

        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.112/proyecto/insertarusabilidad.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Usabilidad.this, "REsultados Guardada", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Eficacia.class));
                        finish();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Usabilidad.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();

                params.put("aplicativo", aplicativo);
                params.put("eficiencia", Eficiencia.idficiencia);
                params.put("eficacia", Eficacia.ideficacia);
                params.put("memorabilidad", Memorabilidad.idmemorabilidad);
                params.put("productividad",Productividad.idproductividad);
                params.put("satisfaccion", Satisfaccion.idsatisfaccion);
                params.put("seguridad", Seguridad.idseguridad);
                params.put("universabilidad", Universabilidad.iduniversabilidad);
                params.put("cargacognitiva", Carga_Cognitiva.idcargacognitiva);
                params.put("calcularusabilidad", calcularusabilidad);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Usabilidad.this);
        requestQueue.add(request);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}