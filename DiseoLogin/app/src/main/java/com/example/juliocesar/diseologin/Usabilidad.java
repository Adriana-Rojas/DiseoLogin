package com.example.juliocesar.diseologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
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

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Usabilidad extends AppCompatActivity {
    Button siguiente;
    private TextView eficienciat,eficaciat,memorabilidadt,productividadt,satisfacciont,seguridadt,universabilidadt,cargacognitivat,calcularusabilidadt;
    static String seficiencia,seficacia,smemorabilidad,sproductividad,ssatisfaccion,sseguridad,suniversabilidad,scargacognitiva,scalcularusabilidad;
    String  aplicativo,eficiencia,eficacia,memorabilidad,productividad,satisfaccion,seguridad,universabilidad,cargacognitiva,calcularusabilidad;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usabilidad);
        siguiente = findViewById(R.id.resultado);
         insertData();
        eficienciat=findViewById(R.id.spinner1);
        eficaciat=findViewById(R.id.spinner2);
        memorabilidadt=findViewById(R.id.spinner3);
        productividadt=findViewById(R.id.spinner4);
        satisfacciont=findViewById(R.id.spinner5);
        seguridadt=findViewById(R.id.spinner6);
        universabilidadt=findViewById(R.id.spinner7);
        cargacognitivat=findViewById(R.id.spinner8);
        calcularusabilidadt=findViewById(R.id.spinner9);

        eficienciat.setText(seficiencia+"%");
        eficaciat.setText(seficacia+"%");
        memorabilidadt.setText(smemorabilidad+"%");
        productividadt.setText(sproductividad+"%");
        satisfacciont.setText(ssatisfaccion+"%");
        seguridadt.setText(sseguridad+"%");
        universabilidadt.setText(suniversabilidad+"%");
        cargacognitivat.setText(scargacognitiva+"%");
        calcularusabilidadt.setText(scalcularusabilidad+"%");

         siguiente.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 graficas();
             }
         });
    }

    private void graficas() {
        startActivity(new Intent(getApplicationContext(), Grafica.class));
    }

    public void insertData() {
        DecimalFormat df = new DecimalFormat("#.00");
        aplicativo=Select_Apk.idaplicacion;
       // eficiencia=Eficiencia.scalculoderelevancia;
        seficiencia=df.format(Float.parseFloat(eficiencia)*10);
        eficacia=Eficacia.scalculoderelevancia;
        seficacia=df.format(Float.parseFloat(eficacia)*10);
        memorabilidad=Memorabilidad.scalculoderelevancia;
        smemorabilidad=df.format(Float.parseFloat(memorabilidad)*10);
        productividad=Productividad.scalculoderelevancia;
        sproductividad=df.format(Float.parseFloat(productividad)*10);
        satisfaccion=Satisfaccion.scalculoderelevancia;
        ssatisfaccion=df.format(Float.parseFloat(satisfaccion)*10);
        seguridad=Seguridad.scalculoderelevancia;
        sseguridad=df.format(Float.parseFloat(seguridad)*10);
        universabilidad=Universabilidad.scalculoderelevancia;
        suniversabilidad=df.format(Float.parseFloat(universabilidad)*10);
        cargacognitiva=Carga_Cognitiva.scalculoderelevancia;
        scargacognitiva=df.format(Float.parseFloat(cargacognitiva)*10);
        calcularusabilidad=Float.toString((Float.parseFloat(eficiencia)+Float.parseFloat(eficacia)+Float.parseFloat(memorabilidad)+Float.parseFloat(productividad)+Float.parseFloat(satisfaccion)+Float.parseFloat(seguridad)+Float.parseFloat(universabilidad)+Float.parseFloat(cargacognitiva))/10*100);
        scalcularusabilidad=df.format(Float.parseFloat(calcularusabilidad));


        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.101.2/proyecto/insertarusabilidad.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       // Toast.makeText(Usabilidad.this, "Resultados Guardada", Toast.LENGTH_SHORT).show();
                       // finish();
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
              //  params.put("eficiencia", Eficiencia.idficiencia);
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