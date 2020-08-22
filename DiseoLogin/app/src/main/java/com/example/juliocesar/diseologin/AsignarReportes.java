package com.example.juliocesar.diseologin;

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
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;


public class AsignarReportes extends AppCompatActivity {
    private AsyncHttpClient cliente;
    private Spinner spAplicacion,spEvaluador;
    Button bnasignar;
    int bandera=1,banderaa=1;
    String idadministrador,idaplicacion,idevaluador,tipoadmin,tipoaplicacion,tipoevaluador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignar_reportes);
        cliente=new AsyncHttpClient();
        spAplicacion=(Spinner) findViewById(R.id.spinneraplicacion);
        spEvaluador=(Spinner) findViewById(R.id.spinnerevaluador);
        bnasignar = (Button)findViewById(R.id.bnasignar);
        llenarSpinnerAplicacion();
        llenarSpinnerEvaluador();
        bnasignar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

    }

    private void llenarSpinnerEvaluador() {
        String url="http://192.168.101.5/proyecto/retrievevaluadorr.php";
        cliente.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode==200){
                    cargarSpinnerEvaluador(new  String(responseBody));
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            }
        });
    }

    private void cargarSpinnerEvaluador(String respuesta) {
        ArrayList<Producto> lista=new ArrayList<Producto>();
        try {
            JSONArray jsonArreglo=new JSONArray(respuesta);
            for (int i=0;i<jsonArreglo.length();i++){
                Producto p=new Producto();
                p.setTipoaplicativo(jsonArreglo.getJSONObject(i).getString("nombre"));
                lista.add(p);
            }
            ArrayAdapter<Producto> a=new ArrayAdapter<Producto>(this,android.R.layout.simple_dropdown_item_1line,lista);
            spEvaluador.setAdapter(a);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void llenarSpinnerAplicacion() {
        String url="http://192.168.101.5/proyecto/retrieveaplicacionn.php";
        cliente.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode==200){
                    cargarSpinnerAplicacion(new  String(responseBody));
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    private void cargarSpinnerAplicacion(String respuesta) {
        ArrayList<Producto> lista=new ArrayList<Producto>();
        try {
            JSONArray jsonArreglo=new JSONArray(respuesta);
            for (int i=0;i<jsonArreglo.length();i++){
                Producto p=new Producto();
                p.setTipoaplicativo(jsonArreglo.getJSONObject(i).getString("nombre"));
                lista.add(p);
            }
            ArrayAdapter<Producto> a=new ArrayAdapter<Producto>(this,android.R.layout.simple_dropdown_item_1line,lista);
            spAplicacion.setAdapter(a);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertData() {
        tipoaplicacion = spAplicacion.getSelectedItem().toString();
        tipoevaluador = spEvaluador.getSelectedItem().toString();
        Login login=new Login();
        idadministrador=login.tipoid;

        BuscarIdSpinner("http://192.168.101.5/proyecto/buscaraplicacionn.php?nombre="+tipoaplicacion);
        BuscarIdSpinnerEvaluador(" http://192.168.101.5/proyecto/buscarevaluador.php?nombre="+tipoevaluador);
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.101.5/proyecto/insertarAsignarReportes.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(AsignarReportes.this, "Asignacion Guardada", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MenuAdmin.class));
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
                params.put("evaluador", idevaluador);
                params.put("listaaplicaciones", idaplicacion);
                params.put("administrador", idadministrador);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(AsignarReportes.this);
        requestQueue.add(request);

        if (idaplicacion == null && bandera==1 && banderaa==1) {
            bandera++;
            banderaa++;
            BuscarIdSpinner("http://192.168.101.5/proyecto/buscaraplicacionn.php?nombre=" + tipoaplicacion);
            BuscarIdSpinnerEvaluador(" http://192.168.101.5/proyecto/buscarevaluador.php?nombre="+tipoevaluador);
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
                        JSONObject jsonObject = response.getJSONObject(i);
                       idaplicacion = jsonObject.getString("id");
                        if(idaplicacion!=null && bandera==2){
                            bandera++;
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

    private void BuscarIdSpinnerEvaluador(String URL) {
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        idevaluador = jsonObject.getString("id");
                        if(idevaluador!=null && banderaa==2){
                            banderaa++;
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
