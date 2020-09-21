package com.ytheekshana.deviceinfo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import androidx.appcompat.app.AppCompatActivity;

public class AddUsuario extends AppCompatActivity {

            Button btnSave;
            EditText edt_nombre,edt_telefono,edt_correo,edt_contraseña;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_add_usuario);

                edt_nombre = (EditText)findViewById(R.id.edt_nombre);
                edt_telefono = (EditText)findViewById(R.id.edt_telefono);
                edt_correo = (EditText)findViewById(R.id.edt_correo);
                edt_contraseña = (EditText)findViewById(R.id.edt_contraseña);
                btnSave = (Button)findViewById(R.id.btnSave);

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        insertData();
                    }
                });
            }

            private void insertData() {

                final String nombre = edt_nombre.getText().toString().trim();
                final String telefono = edt_telefono.getText().toString().trim();
                final String correo = edt_correo.getText().toString().trim();
                final String contraseña = edt_contraseña.getText().toString().trim();

                if(nombre.isEmpty()){
                    Toast.makeText(this, "Enter Nombre", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(telefono.isEmpty()){
                    Toast.makeText(this, "Enter Telefono", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(correo.isEmpty()){
                    Toast.makeText(this, "Enter Correo", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(contraseña.isEmpty()){
                    Toast.makeText(this, "Enter Contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }

                else{
                    final ProgressDialog progressDialog = new ProgressDialog(this);
                    progressDialog.setMessage("Loading...");
                    progressDialog.show();

                    StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.71/proyecto/insertarusuario.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                        Toast.makeText(AddUsuario.this, "Usuario Guardado", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(),CrudUsuario.class));
                                        finish();
                                        progressDialog.dismiss();
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(AddUsuario.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }
                    ){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {

                            Map<String,String> params = new HashMap<String,String>();

                            params.put("nombre",nombre);
                            params.put("telefono",telefono);
                            params.put("correo",correo);
                            params.put("contraseña",contraseña);
                            return params;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(AddUsuario.this);
                    requestQueue.add(request);
                }
            }

            @Override
            public void onBackPressed() {
                super.onBackPressed();
                finish();
            }
        }
