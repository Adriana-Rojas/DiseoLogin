package com.ytheekshana.deviceinfo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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


public class EditUsuario extends AppCompatActivity {

        EditText edId,edNombre,edTelefono,edCorreo,edContraseña;
        private int position;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_edit_usuario);

            edId = findViewById(R.id.id_blog);
            edNombre = findViewById(R.id.edt_nombre);
            edTelefono = findViewById(R.id.edt_telefono);
            edCorreo = findViewById(R.id.edt_correo);
            edContraseña = findViewById(R.id.edt_contraseña);
            Intent intent = getIntent();
            position = intent.getExtras().getInt("position");

            edId.setText(CrudUsuario.employeeArrayList.get(position).getId());
            edNombre.setText(CrudUsuario.employeeArrayList.get(position).getNombre());
            edTelefono.setText(CrudUsuario.employeeArrayList.get(position).getTelefono());
            edCorreo.setText(CrudUsuario.employeeArrayList.get(position).getCorreo());
            edContraseña.setText(CrudUsuario.employeeArrayList.get(position).getContraseña());
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

            StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.101.5/proyecto/updateusuario.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(EditUsuario.this, response, Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),CrudUsuario.class));
                            finish();
                            progressDialog.dismiss();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(EditUsuario.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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

            RequestQueue requestQueue = Volley.newRequestQueue(EditUsuario.this);
            requestQueue.add(request);
        }
    }
