package com.ytheekshana.deviceinfo;

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

import androidx.appcompat.app.AppCompatActivity;

public class Satisfaccion extends AppCompatActivity {

    Button siguiente;
    private Spinner estetica_general, comodidad_visual, informacion, iconos, eleccion, busqueda, videos, recomendacion, organizacion, interfaz, gusto, herramientas, satisfaccion, lenguaje, sobrecarga, interfaz_limpia, espacio, longitud, texto;

    String   sestetica_general, scomodidad_visual, sinformacion, siconos, seleccion, sbusqueda, svideos, srecomendacion, scalculo_satisfaccion, sorganizacion, sinterfaz, sgusto, sherramientas, ssatisfaccion, slenguaje, ssobrecarga, sinterfaz_limpia, sespacio, slongitud, stexto;
    static String idsatisfaccion,estetica_generals,comodidad_visuals,informacions,iconoss,eleccions,busquedas,videoss,recomendacions,calculo_satisfaccions,organizacions,interfazs,gustos,herramientass,satisfaccions,lenguajes,sobrecargas,interfaz_limpias,espacios,longituds,textos,sumaTotals,scalculoderelevancia;
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
                relevancia();
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

        String a1=Float.toString((Float.parseFloat(estetica_generals)/Float.parseFloat(sumaTotals))*Float.parseFloat(sestetica_general));
        String b1=Float.toString((Float.parseFloat(comodidad_visuals)/Float.parseFloat(sumaTotals))*Float.parseFloat(scomodidad_visual));
        String c1=Float.toString((Float.parseFloat(informacions)/Float.parseFloat(sumaTotals))*Float.parseFloat(sinformacion));
        String d1=Float.toString((Float.parseFloat(iconoss)/Float.parseFloat(sumaTotals))*Float.parseFloat(siconos));
        String e1=Float.toString((Float.parseFloat(eleccions)/Float.parseFloat(sumaTotals))*Float.parseFloat(seleccion));
        String f1=Float.toString((Float.parseFloat(busquedas)/Float.parseFloat(sumaTotals))*Float.parseFloat(sbusqueda));//
        String g1=Float.toString((Float.parseFloat(videoss)/Float.parseFloat(sumaTotals))*Float.parseFloat(svideos));
        String h1=Float.toString((Float.parseFloat(recomendacions)/Float.parseFloat(sumaTotals))*Float.parseFloat(srecomendacion));
        String i1=Float.toString((Float.parseFloat(calculo_satisfaccions)/Float.parseFloat(sumaTotals))*Float.parseFloat(scalculo_satisfaccion));
        String j=Float.toString((Float.parseFloat(organizacions)/Float.parseFloat(sumaTotals))*Float.parseFloat(sorganizacion));
        String k=Float.toString((Float.parseFloat(interfazs)/Float.parseFloat(sumaTotals))*Float.parseFloat(sinterfaz));
        String m=Float.toString((Float.parseFloat(gustos)/Float.parseFloat(sumaTotals))*Float.parseFloat(sgusto));
        String n=Float.toString((Float.parseFloat(herramientass)/Float.parseFloat(sumaTotals))*Float.parseFloat(sherramientas));
        String o=Float.toString((Float.parseFloat(herramientass)/Float.parseFloat(sumaTotals))*Float.parseFloat(sherramientas));
        String p=Float.toString((Float.parseFloat(satisfaccions)/Float.parseFloat(sumaTotals))*Float.parseFloat(ssatisfaccion));
        String q=Float.toString((Float.parseFloat(lenguajes)/Float.parseFloat(sumaTotals))*Float.parseFloat(slenguaje));
        String r=Float.toString((Float.parseFloat(sobrecargas)/Float.parseFloat(sumaTotals))*Float.parseFloat(ssobrecarga));
        String s=Float.toString((Float.parseFloat(interfaz_limpias)/Float.parseFloat(sumaTotals))*Float.parseFloat(sinterfaz_limpia));///
        String t=Float.toString((Float.parseFloat(espacios)/Float.parseFloat(sumaTotals))*Float.parseFloat(sespacio));
        String u=Float.toString((Float.parseFloat(longituds)/Float.parseFloat(sumaTotals))*Float.parseFloat(slongitud));
        String v=Float.toString((Float.parseFloat(textos)/Float.parseFloat(sumaTotals))*Float.parseFloat(stexto));
        scalculoderelevancia=Float.toString(Float.parseFloat(a1)+Float.parseFloat(b1)+Float.parseFloat(c1)+Float.parseFloat(d1)+Float.parseFloat(e1)+Float.parseFloat(f1)+Float.parseFloat(g1)+Float.parseFloat(h1)+Float.parseFloat(i1)+Float.parseFloat(j)+Float.parseFloat(k)+Float.parseFloat(m)+Float.parseFloat(n)+Float.parseFloat(o)+Float.parseFloat(p)+Float.parseFloat(q)+Float.parseFloat(r)+Float.parseFloat(s)+Float.parseFloat(t)+Float.parseFloat(u)+Float.parseFloat(v));


        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.101.2/proyecto/insertarsatisfaccion.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        idsatisfaccion= response.substring(response.lastIndexOf(' ') + 1);
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
                params.put("calculoderelevancia", scalculoderelevancia);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Satisfaccion.this);
        requestQueue.add(request);
    }
    private void relevancia() {
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.101.2/proyecto/buscarrelevancia.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try{

                            JSONObject jsonObject = new JSONObject(response);
                            String sucess = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("relevancia");

                            if(sucess.equals("1")){

                                for(int i=0;i<jsonArray.length();i++){

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String  estetica_general= object.getString("estetica_general");
                                    estetica_generals=estetica_general;
                                    String   comodidad_visual= object.getString("comodidad_visual");
                                    comodidad_visuals=comodidad_visual;
                                    String   informacion= object.getString("informacion");
                                    informacions=informacion;
                                    String   iconos= object.getString("iconos");
                                    iconoss=iconos;
                                    String eleccion= object.getString("eleccion");
                                    eleccions=eleccion;
                                    String  busqueda= object.getString("busqueda");
                                    busquedas=busqueda;
                                    String   videos= object.getString("videos");
                                    videoss=videos;
                                    String recomendacion= object.getString("recomendacion");
                                    recomendacions=recomendacion;
                                    String calculo_satisfaccion= object.getString("calculo_satisfaccion");
                                    calculo_satisfaccions=calculo_satisfaccion;
                                    String organizacion= object.getString("organizacion");
                                    organizacions=organizacion;
                                    String interfaz= object.getString("interfaz");
                                    interfazs=interfaz;
                                    String gusto= object.getString("gusto");
                                    gustos=gusto;
                                    String herramientas= object.getString("herramientas");
                                    herramientass=herramientas;
                                    String satisfaccion= object.getString("satisfaccion");
                                    satisfaccions=satisfaccion;
                                    String lenguaje= object.getString("lenguaje");
                                    lenguajes=lenguaje;
                                    String   sobrecarga= object.getString("sobrecarga");
                                    sobrecargas=sobrecarga;
                                    String interfaz_limpia= object.getString("interfaz_limpia");
                                    interfaz_limpias=interfaz_limpia;
                                    String espacio= object.getString("espacio");
                                    espacios=espacio;
                                    String longitud= object.getString("longitud");
                                    longituds=longitud;
                                    String texto= object.getString("texto");
                                    textos=texto;
                                    String sumaTotal= object.getString("sumaTotal");
                                    sumaTotals=sumaTotal;
                                    insertData();

                                }
                            }
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Satisfaccion.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                //   params.put("id",id);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}