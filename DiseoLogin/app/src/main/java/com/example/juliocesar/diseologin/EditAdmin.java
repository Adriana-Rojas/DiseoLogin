package com.example.juliocesar.diseologin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class EditAdmin extends AppCompatActivity {

        EditText edId,edNombre,edTelefono,edCorreo,edContraseña;
        private int position;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_edit_admin);

            edId = findViewById(R.id.id_blog);
            edNombre = findViewById(R.id.edt_nombre);
            edTelefono = findViewById(R.id.edt_telefono);
            edCorreo = findViewById(R.id.edt_correo);
            edContraseña = findViewById(R.id.edt_contraseña);

            Intent intent = getIntent();
            position = intent.getExtras().getInt("position");

            edId.setText(CrudAdmin.employeeArrayList.get(position).getId());
            edNombre.setText(CrudAdmin.employeeArrayList.get(position).getNombre());
            edTelefono.setText(CrudAdmin.employeeArrayList.get(position).getTelefono());
            edCorreo.setText(CrudAdmin.employeeArrayList.get(position).getCorreo());
            edContraseña.setText(CrudAdmin.employeeArrayList.get(position).getContraseña());
        }

        public void btn_updateData(View view) {

            final String nombre = edNombre.getText().toString();
            final String telefono = edTelefono.getText().toString();
            final String correo = edCorreo.getText().toString();
            final String contraseña = edContraseña.getText().toString();
            final String id = edId.getText().toString();

            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Updating....");
            progressDialog.show();

            StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.112/proyecto/updateadmin.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(EditAdmin.this, response, Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),CrudAdmin.class));
                            finish();
                            progressDialog.dismiss();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(EditAdmin.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }){

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

                    params.put("id",id);
                    params.put("nombre",nombre);
                    params.put("telefono",telefono);
                    params.put("correo",correo);
                    params.put("contraseña",contraseña);

                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(EditAdmin.this);
            requestQueue.add(request);
        }
    }
