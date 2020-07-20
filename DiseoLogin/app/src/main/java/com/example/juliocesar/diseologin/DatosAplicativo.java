package com.example.juliocesar.diseologin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.loopj.android.http.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

public class DatosAplicativo extends AppCompatActivity {
    private AsyncHttpClient cliente;
    private Spinner spProductos;
    Button btnSave;
    int bandera=1;
    String tipoidd, nombre,apk,manual,tipo;
    EditText edt_tipo,edt_nombre,edt_apk,edt_manual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_aplicativo);

        cliente=new AsyncHttpClient();
        spProductos=(Spinner) findViewById(R.id.spinner);
        llenarSpinner();


        edt_nombre = (EditText)findViewById(R.id.edt_nombre);
        edt_apk = (EditText)findViewById(R.id.edt_apk);
        edt_manual = (EditText)findViewById(R.id.edt_manual);
        btnSave = (Button)findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

    }
    private  void llenarSpinner(){
        String url="http://192.168.1.113/proyecto/retrieveaplicacion.php";
        cliente.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode==200){
                    cargarSpinner(new  String(responseBody));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    private void cargarSpinner(String respuesta) {
        ArrayList<Producto>lista=new ArrayList<Producto>();
        try {
            JSONArray jsonArreglo=new JSONArray(respuesta);
            for (int i=0;i<jsonArreglo.length();i++){
                Producto p=new Producto();
                p.setTipoaplicativo(jsonArreglo.getJSONObject(i).getString("tipoaplicativo"));
                lista.add(p);
            }
            ArrayAdapter<Producto> a=new ArrayAdapter<Producto>(this,android.R.layout.simple_dropdown_item_1line,lista);
            spProductos.setAdapter(a);


        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertData() {
        tipo = spProductos.getSelectedItem().toString();
        BuscarIdSpinner("http://192.168.1.113/proyecto/buscaraplicacion.php?tipoaplicativo="+tipo);
           nombre = edt_nombre.getText().toString().trim();
        //   tipoidd=tipoid;
           apk = edt_apk.getText().toString().trim();
           manual = edt_manual.getText().toString().trim();




        if(nombre.isEmpty()){
            Toast.makeText(this, "Enter Nombre", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(apk.isEmpty()){
            Toast.makeText(this, "Enter apk", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(manual.isEmpty()){
            Toast.makeText(this, "Enter manual", Toast.LENGTH_SHORT).show();
            return;
        }

        else {



                StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.113/proyecto/insertardatosaplicacion.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                Toast.makeText(DatosAplicativo.this, "Aplicativo Guardado", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MenuUsuario.class));
                                finish();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       // Toast.makeText(DatosAplicativo.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
                ) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params = new HashMap<String, String>();
                      //  tipoidd=tipoid;
                        params.put("nombre", nombre);
                        params.put("tipoaplicativo", tipoidd);
                        params.put("subirapk", apk);
                        params.put("subirmanual", manual);
                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(DatosAplicativo.this);
                requestQueue.add(request);

                if (tipoidd == null && bandera==1) {
                    bandera++;
                    BuscarIdSpinner("http://192.168.1.113/proyecto/buscaraplicacion.php?tipoaplicativo=" + tipo);
                }


        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void BuscarIdSpinner(String URL) {

           JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
               @Override
               public void onResponse(JSONArray response) {
                   for (int i = 0; i < response.length(); i++) {
                       try {
                           JSONObject  jsonObject = response.getJSONObject(i);
                           tipoidd = jsonObject.getString("id");
                           if(tipoidd!=null && bandera==2){
                               bandera++;
                               insertData();
                           }

                       } catch (JSONException e) {
                           e.printStackTrace();
                       }
                   }
               }
           }, new Response.ErrorListener() {
               @Override
               public void onErrorResponse(VolleyError error) {
                   Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
               }
           });
           RequestQueue requestQueue = Volley.newRequestQueue(this);
           requestQueue.add(jsonArrayRequest);



    }

}
