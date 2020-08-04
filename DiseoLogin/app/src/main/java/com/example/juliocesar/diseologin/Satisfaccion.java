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

public class Satisfaccion extends AppCompatActivity {

    Button siguiente;
    private Spinner estetica_general, comodidad_visual, informacion, iconos, eleccion, busqueda, videos, recomendacion, organizacion, interfaz, gusto, herramientas, satisfaccion, lenguaje, sobrecarga, interfaz_limpia, espacio, longitud, texto;

    String   sestetica_general, scomodidad_visual, sinformacion, siconos, seleccion, sbusqueda, svideos, srecomendacion, scalculo_satisfaccion, sorganizacion, sinterfaz, sgusto, sherramientas, ssatisfaccion, slenguaje, ssobrecarga, sinterfaz_limpia, sespacio, slongitud, stexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satisfaccion);
        siguiente = findViewById(R.id.satisfaccion);

        estetica_general=(Spinner) findViewById(R.id.spinner1);
        comodidad_visual=(Spinner) findViewById(R.id.spinner2);
        informacion=(Spinner) findViewById(R.id.spinner3);
        iconos=(Spinner) findViewById(R.id.spinner4);
        eleccion=(Spinner) findViewById(R.id.spinner5);
        busqueda=(Spinner) findViewById(R.id.spinner6);
        videos=(Spinner) findViewById(R.id.spinner7);
        recomendacion=(Spinner) findViewById(R.id.spinner8);
        organizacion=(Spinner) findViewById(R.id.spinner9);
        interfaz=(Spinner) findViewById(R.id.spinner10);
        gusto=(Spinner) findViewById(R.id.spinner11);
        herramientas=(Spinner) findViewById(R.id.spinner12);
        satisfaccion=(Spinner) findViewById(R.id.spinner13);
        lenguaje=(Spinner) findViewById(R.id.spinner14);
        sobrecarga=(Spinner) findViewById(R.id.spinner15);
        interfaz_limpia=(Spinner) findViewById(R.id.spinner16);
        espacio=(Spinner) findViewById(R.id.spinner17);
        longitud=(Spinner) findViewById(R.id.spinner18);
        texto=(Spinner) findViewById(R.id.spinner19);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });
    }

    private void insertData() {
        sestetica_general=estetica_general.getSelectedItem().toString();
        scomodidad_visual=comodidad_visual.getSelectedItem().toString();
        sinformacion=informacion.getSelectedItem().toString();
        siconos=iconos.getSelectedItem().toString();
        seleccion=eleccion.getSelectedItem().toString();
        sbusqueda=busqueda.getSelectedItem().toString();
        svideos=videos.getSelectedItem().toString();
        srecomendacion=recomendacion.getSelectedItem().toString();
      //  Integer a=Integer.parseInt(sestetica_general+scomodidad_visual+sinformacion+siconos+seleccion+sbusqueda+svideos+srecomendacion);
        Integer a=Integer.parseInt(sestetica_general);
        Integer b=Integer.parseInt(scomodidad_visual);
        Integer c=Integer.parseInt(sinformacion);
        Integer d=Integer.parseInt(siconos);
        Integer e=Integer.parseInt(seleccion);
        Integer f=Integer.parseInt(sbusqueda);
        Integer g=Integer.parseInt(svideos);
        Integer h=Integer.parseInt(srecomendacion);
        Integer sumatoria=a+b+c+d+e+f+g+h;
        scalculo_satisfaccion=Integer.toString(sumatoria/2);//dividido sobre la poblacion
        sorganizacion=organizacion.getSelectedItem().toString();
        sinterfaz=interfaz.getSelectedItem().toString();
        sgusto=gusto.getSelectedItem().toString();
        sherramientas=herramientas.getSelectedItem().toString();
        ssatisfaccion=satisfaccion.getSelectedItem().toString();
        slenguaje=lenguaje.getSelectedItem().toString();
        ssobrecarga=sobrecarga.getSelectedItem().toString();
        sinterfaz_limpia=interfaz_limpia.getSelectedItem().toString();
        sespacio=espacio.getSelectedItem().toString();
        slongitud=longitud.getSelectedItem().toString();
        stexto=texto.getSelectedItem().toString();

       /* Login login=new Login();
        idadministrador=login.tipoid;*/

        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.112/proyecto/insertarsatisfaccion.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Satisfaccion.this, "Satisfaccion Guardada", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Seguridad.class));
                        finish();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Satisfaccion.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();

                params.put("estetica_general", sestetica_general);
                params.put("comodidad_visual", scomodidad_visual);
                params.put("informacion", sinformacion);
                params.put("iconos", siconos);
                params.put("eleccion", seleccion);
                params.put("busqueda", sbusqueda);
                params.put("videos", svideos);
                params.put("recomendacion", srecomendacion);
                params.put("calculo_satisfaccion", scalculo_satisfaccion);
                params.put("organizacion", sorganizacion);
                params.put("interfaz", sinterfaz);
                params.put("gusto", sgusto);
                params.put("herramientas", sherramientas);
                params.put("satisfaccion", ssatisfaccion);
                params.put("lenguaje", slenguaje);
                params.put("sobrecarga", ssobrecarga);
                params.put("interfaz_limpia", sinterfaz_limpia);
                params.put("espacio", sespacio);
                params.put("longitud", slongitud);
                params.put("texto", stexto);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Satisfaccion.this);
        requestQueue.add(request);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}