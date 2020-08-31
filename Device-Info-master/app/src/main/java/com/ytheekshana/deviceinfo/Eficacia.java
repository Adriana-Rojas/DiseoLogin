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

public class Eficacia extends AppCompatActivity {

    Button siguiente;
    int bandera=1,banderaa=1;
    private Spinner  tareascompletadas,totaltareas,calculoterminaciontarea, calculoefectividad,numerofaltas,
            calculotiempo,calculoextensibilidad,calculoreusabilidad, calculoescalabilidad;

    String   stareascompletadas,stotaltareas,scalculoterminaciontarea, scalculoefectividad,snumerofaltas,
            scalculotiempo,scalculoextensibilidad,scalculoreusabilidad, scalculoescalabilidad;
    static String  ideficacia, calculoterminaciontareas,calculoefectividads,calculotiempos,calculoextensibilidads,calculoreusabilidads,calculoescalabilidads,sumaTotals,scalculoderelevancia;
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
                relevancia();
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

        String a=Float.toString((Float.parseFloat(calculoterminaciontareas)/Float.parseFloat(sumaTotals))*Float.parseFloat(scalculoterminaciontarea));
        String b=Float.toString((Float.parseFloat(calculoefectividads)/Float.parseFloat(sumaTotals))*Float.parseFloat(scalculoefectividad));
        String c=Float.toString((Float.parseFloat(calculotiempos)/Float.parseFloat(sumaTotals))*Float.parseFloat(scalculotiempo));
        String d=Float.toString((Float.parseFloat(calculoextensibilidads)/Float.parseFloat(sumaTotals))*Float.parseFloat(scalculoextensibilidad));
        String e=Float.toString((Float.parseFloat(calculoreusabilidads)/Float.parseFloat(sumaTotals))*Float.parseFloat(scalculoreusabilidad));
        String f=Float.toString((Float.parseFloat(calculoescalabilidads)/Float.parseFloat(sumaTotals))*Float.parseFloat(scalculoescalabilidad));
        scalculoderelevancia=Float.toString(Float.parseFloat(a)+Float.parseFloat(b)+Float.parseFloat(c)+Float.parseFloat(d)+Float.parseFloat(e)+Float.parseFloat(f));



        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.101.2/proyecto/insertareficacia.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ideficacia= response.substring(response.lastIndexOf(' ') + 1);
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
                params.put("calculoderelevancia", scalculoderelevancia);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Eficacia.this);
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

                                    String id = object.getString("id");
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
                Toast.makeText(Eficacia.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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