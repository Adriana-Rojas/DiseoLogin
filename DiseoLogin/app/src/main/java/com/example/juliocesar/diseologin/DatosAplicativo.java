package com.example.juliocesar.diseologin;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.gson.JsonArray;
import com.loopj.android.http.*;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class DatosAplicativo extends AppCompatActivity {
    private AsyncHttpClient cliente;
    private Spinner spProductos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_aplicativo);

        cliente=new AsyncHttpClient();
        spProductos=(Spinner) findViewById(R.id.spinner);
        llenarSpinner();

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
                p.setNombre(jsonArreglo.getJSONObject(i).getString("nombre"));
                lista.add(p);
            }
            ArrayAdapter<Producto> a=new ArrayAdapter<Producto>(this,android.R.layout.simple_dropdown_item_1line,lista);
            spProductos.setAdapter(a);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
