package com.example.juliocesar.diseologin;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Relevancia extends AppCompatActivity {

   // public static ArrayList<Employeepk> employeeArrayList = new ArrayList<>();
    static String ids,tipoaplicativos,tiempoinicios,calculartiemporespuestas,calculorams,calculocpus,calculobaterias,esfuerzos,calculocostoeconomicos,calculoterminaciontareas,calculoefectividads,calculotiempos,calculoextensibilidads,calculoreusabilidads,calculoescalabilidads,rapidezs,dificultads,aprendizajes,facilidads,productividad_inexpertos,estetica_generals,comodidad_visuals,informacions,iconoss,eleccions,busquedas,videoss,recomendacions,calculo_satisfaccions,organizacions,interfazs,gustos,herramientass,satisfaccions,lenguajes,sobrecargas,interfaz_limpias,espacios,longituds,textos,seguridads,playstores,calculofrecuenciaerroress,mensajess,prevencions,redundancias,enlacess,resolucions,lenguaje_clarols,fuentes,contrastes,idiomas,usos,multitareass,actividad_mentals,dificultad_tareas,actividad_fisicas,exigencias,inseguros,sumaTotals;
   // Employeepki employeepki;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        retrieveData();
    }


    public void retrieveData(){
        final String id = Login.tipoid;
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.101.2/proyecto/buscarrelevancia.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                       // employeeArrayList.clear();
                        try{

                            JSONObject jsonObject = new JSONObject(response);
                            String sucess = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("evaluador");

                            if(sucess.equals("1")){

                                for(int i=0;i<jsonArray.length();i++){

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String id = object.getString("id");
                                    ids=id;
                                    String  tipoaplicativo= object.getString("tipoaplicativo");
                                    tipoaplicativos=tipoaplicativo;
                                    String  tiempoinicio= object.getString("tiempoinicio");
                                    tiempoinicios=tiempoinicio;
                                    String  calculartiemporespuesta= object.getString("calculartiemporespuesta");
                                    calculartiemporespuestas=calculartiemporespuesta;
                                    String calculoram= object.getString("calculoram");
                                    calculorams=calculoram;
                                    String  calculocpu= object.getString("calculocpu");
                                    calculocpus=calculocpu;
                                    String  calculobateria= object.getString("calculobateria");
                                    calculobaterias=calculobateria;
                                    String  esfuerzo= object.getString("esfuerzo");
                                    esfuerzos=esfuerzo;
                                    String   calculocostoeconomico= object.getString("calculocostoeconomico");
                                    calculocostoeconomicos=calculocostoeconomico;
                                    String  calculoterminaciontarea= object.getString("calculoterminaciontarea");
                                    calculoterminaciontareas=calculoterminaciontarea;
                                    String calculoefectividad= object.getString("calculoefectividad");
                                    calculoefectividads=calculoefectividad;
                                    String calculotiempo= object.getString("calculotiempo");
                                    calculotiempos=calculotiempo;
                                    String  calculoextensibilidad= object.getString("calculoextensibilidad");
                                    calculoextensibilidads=calculoextensibilidad;
                                    String  calculoreusabilidad= object.getString("calculoreusabilidad");
                                    calculoreusabilidads=calculoreusabilidad;
                                    String calculoescalabilidad= object.getString("calculoescalabilidad");
                                    calculoescalabilidads=calculoescalabilidad;
                                    String rapidez= object.getString("rapidez");
                                    rapidezs=rapidez;
                                    String   dificultad= object.getString("dificultad");
                                    dificultads=dificultad;
                                    String aprendizaje= object.getString("aprendizaje");
                                    aprendizajes=aprendizaje;
                                    String  facilidad= object.getString("facilidad");
                                    facilidads=facilidad;///////////////////////////////////////////////////////////////////////////////
                                    String  productividad_inexperto= object.getString("productividad_inexperto");
                                    productividad_inexpertos=productividad_inexperto;
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
                                    textos=texto;//////////////////////////////////////////////////////////////////////////
                                    String  seguridad= object.getString("seguridad");
                                    seguridads=seguridad;
                                    String  playstore= object.getString("playstore");
                                    playstores=playstore;
                                    String  calculofrecuenciaerrores= object.getString("calculofrecuenciaerrores");
                                    calculofrecuenciaerroress=calculofrecuenciaerrores;
                                    String  mensajes= object.getString("mensajes");
                                    mensajess=mensajes;
                                    String  prevencion= object.getString("prevencion");
                                    prevencions=prevencion;
                                    String  redundancia= object.getString("redundancia");
                                    redundancias=redundancia;
                                    String  enlaces= object.getString("enlaces");
                                    enlacess=enlaces;//////////////////////////////////////////////////////////
                                    String resolucion= object.getString("resolucion");
                                    resolucions=resolucion;
                                    String lenguaje_clarol= object.getString("lenguaje_clarol");
                                    lenguaje_clarols=lenguaje_clarol;
                                    String  fuente= object.getString("fuente");
                                    fuentes=fuente;
                                    String  contraste= object.getString("contraste");
                                    contrastes=contraste;
                                    String  idioma= object.getString("idioma");
                                    idiomas=idioma;/////////////////////////////////////////////////////
                                    String  uso= object.getString("uso");
                                    usos=uso;///////////////////////////////////////////////////////
                                    String multitareas= object.getString("multitareas");
                                    multitareass=multitareas;
                                    String   actividad_mental= object.getString("actividad_mental");
                                    actividad_mentals=actividad_mental;
                                    String  dificultad_tarea= object.getString("dificultad_tarea");
                                    dificultad_tareas=dificultad_tarea;
                                    String  actividad_fisica= object.getString("actividad_fisica");
                                    actividad_fisicas=actividad_fisica;
                                    String   exigencia= object.getString("exigencia");
                                    exigencias=exigencia;
                                    String  inseguro= object.getString("inseguro");
                                    inseguros=inseguro;
                                    String  sumaTotal= object.getString("sumaTotal");
                                    sumaTotals=sumaTotal;
                                  //  employeepki = new Employeepki(id,tipoaplicativo,tiempoinicio,calculartiemporespuesta,calculoram,calculocpu,calculobateria,esfuerzo,calculocostoeconomico,calculoterminaciontarea,calculoefectividad,calculotiempo,calculoextensibilidad,calculoreusabilidad,calculoescalabilidad,rapidez,dificultad,aprendizaje,facilidad,productividad_inexperto,estetica_general,comodidad_visual,informacion,iconos,eleccion,busqueda,videos,recomendacion,calculo_satisfaccion,organizacion,interfaz,gusto,herramientas,satisfaccion,lenguaje,sobrecarga,interfaz_limpia,espacio,longitud,texto,seguridad,playstore,calculofrecuenciaerrores,mensajes,prevencion,redundancia,enlaces,resolucion,lenguaje_clarol,fuente,contraste,idioma,uso,multitareas,actividad_mental,dificultad_tarea,actividad_fisica,exigencia,inseguro,sumaTotal);

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
                Toast.makeText(Relevancia.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                params.put("id",id);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

}

