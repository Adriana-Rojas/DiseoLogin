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

public class Select_Apk extends AppCompatActivity {

    ListView listView;
    MyAdapterApk adapterApk;
    public static ArrayList<Employeepk> employeeArrayList = new ArrayList<>();
    String url = "http://192.168.1.112/proyecto/retrieveevaluadorapk.php";
    Employeepk employeepk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__apk);

        listView = findViewById(R.id.myListView);
        adapterApk = new MyAdapterApk(this,employeeArrayList);
        listView.setAdapter(adapterApk);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, final long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogItem = {"Ver","Editar","Eliminar"};
                builder.setTitle(employeeArrayList.get(position).getNombre());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        switch (i){

                            case 0:
                                startActivity(new Intent(getApplicationContext(),Eficiencia.class)
                                        .putExtra("position",position));
                                break;

                            case 1:
                              /*  startActivity(new Intent(getApplicationContext(),EditEvaluador.class)
                                        .putExtra("position",position));*/
                                break;

                            case 2:
                                /*deleteData(employeeArrayList.get(position).getId());*/
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });

        retrieveData();
    }
    private void deleteData(final String id) {

        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.112/proyecto/deleteevaluador.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.equalsIgnoreCase("Data Deleted")){
                            Toast.makeText(Select_Apk.this, "Eliminado", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),CrudEvaluador.class));
                            finish();
                        }
                        else{
                            Toast.makeText(Select_Apk.this, "No Fue Eliminado", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Select_Apk.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
                params.put("id", id);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }
    public void retrieveData(){
        final String id = Login.tipoid;
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        employeeArrayList.clear();
                        try{

                            JSONObject jsonObject = new JSONObject(response);
                            String sucess = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("evaluador");

                            if(sucess.equals("1")){

                                for(int i=0;i<jsonArray.length();i++){

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String id = object.getString("id");
                                    String usuario = object.getString("usuario");
                                    String nombre = object.getString("nombre");
                                    String tipoaplicativo = object.getString("tipoaplicativo");
                                    String subirapk = object.getString("subirapk");
                                    String subirmanual = object.getString("subirmanual");
                                    String evaluador = object.getString("evaluador");
                                    String listaaplicaciones = object.getString("listaaplicaciones");
                                    String administrador = object.getString("administrador");


                                    employeepk = new Employeepk(id,usuario,nombre,tipoaplicativo,subirapk,subirmanual,evaluador,listaaplicaciones,administrador);
                                    employeeArrayList.add(employeepk);
                                    adapterApk.notifyDataSetChanged();
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
                Toast.makeText(Select_Apk.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
    public void btn_add_activity(View view) {
        startActivity(new Intent(getApplicationContext(),AddEvaluador.class));
    }
}
