package com.example.juliocesar.diseologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class Login extends AppCompatActivity {

    EditText edtUsuario, edtPassword;
    Button btnLogin;
    String usuario,password,usuario1="incorrecto",password1="incorrecto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUsuario = findViewById(R.id.et_correo);
        edtPassword = findViewById(R.id.et_contrasena);
        btnLogin = findViewById(R.id.iniciar_sesion);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario=edtUsuario.getText().toString();
                password=edtPassword.getText().toString();
                if(edtUsuario.length()== 0  ){
                    edtUsuario.setError("Correo es obligatorio");
                    edtUsuario.requestFocus();
                    usuario1=usuario;
                }else  if( edtPassword.length()== 0 ){
                    edtPassword.setError("Contraseña es obligatorio");
                    edtPassword.requestFocus();
                    password1=password;
                }else  if(!validarEmail(usuario)){
                    edtUsuario.setError("Email no válido");
                    usuario1=usuario;
                }/*else  if(!validarContraseña(password)){
                    edtPassword.setError("Contraseña insegura A2a%");
                    password1=password;
                }*/
                if(!usuario1.isEmpty()&&!password1.isEmpty()){
                    /*
                    importante tiene que tener  el mismo wifiy ver en el cmd la direccion ipv4
                    */
                    validarUsuario("http://192.168.1.113/proyecto/validar_usuario.php");
                }
            }
        });
    }
    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
    public boolean validarContraseña(String pwd){
        boolean rtn = true;
        int seguidos = 0;
        char ultimo = 0xFF;

        int minuscula = 0;
        int mayuscula = 0;
        int numero = 0;
        int especial = 0;
        boolean espacio = false;
        if(pwd.length() < 8 || pwd.length() > 16) return false; // tamaño
        for(int i=0;i<pwd.length(); i++){
            char c = pwd.charAt(i);
            if(c <= ' ' || c > '~' ){
                rtn = false; //Espacio o fuera de rango
                break;
            }
            if( (c > ' ' && c < '0') || (c >= ':' && c < 'A') || (c >= '[' && c < 'a') || (c >= '{' && c < 127) ){
                especial++;
            }
            if(c >= '0' && c < ':') numero++;
            if(c >= 'A' && c < '[') mayuscula++;
            if(c >= 'a' && c < '{') minuscula++;

            seguidos = (c==ultimo) ? seguidos + 1 : 0;
            if(seguidos >= 2){
                rtn = false; // 3 seguidos
                break;
            }
            ultimo = c;
        }
        rtn = rtn && especial > 0 && numero > 0 && minuscula > 0 && mayuscula > 0;
        return rtn;
    }

    private void validarUsuario(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()){
                    Intent intent = new Intent(getApplicationContext(),MenuUsuario.class);
                    startActivity(intent);
                } else {
                    validarEvaluador("http://192.168.1.113/proyecto/validar_evaluador.php");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("correo", edtUsuario.getText().toString());
                parametros.put("contraseña", edtPassword.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    private void validarEvaluador(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()){
                    Intent intent = new Intent(getApplicationContext(),MenuEvaluador.class);
                    startActivity(intent);
                } else {
                    validarAdministrador("http://192.168.1.113/proyecto/validar_administrador.php");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("correo", edtUsuario.getText().toString());
                parametros.put("contraseña", edtPassword.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    private void validarAdministrador(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()){
                    Intent intent = new Intent(getApplicationContext(),MenuAdmin.class);
                    startActivity(intent);
                } else {
                    /// no me quiere funcionar el mensaje
                    Toast.makeText(Login.this, "Usuario o Contraseña incorecto", Toast.LENGTH_LONG).show();
                    // toco con este
                    edtUsuario.setError("Usuario o Contraseña incorecto");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("correo", edtUsuario.getText().toString());
                parametros.put("contraseña", edtPassword.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
