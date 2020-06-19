package com.example.juliocesar.diseologin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button btn_ir_crearCuenta,iniciar_sesion;
     EditText correo,contraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_ir_crearCuenta=findViewById(R.id.btn_ir_crearCuenta);
        iniciar_sesion=(Button) findViewById(R.id.iniciar_sesion);
        correo=(EditText) findViewById(R.id.et_correo);
        contraseña=(EditText) findViewById(R.id.et_contrasena);


        btn_ir_crearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,SignUp.class));
                finish();
            }
        });


        iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(correo.length()== 0 & contraseña.length()== 0 ){
                    Toast.makeText(Login.this, "no puede haber campos vacios", Toast.LENGTH_SHORT).show();
                }
                String correooo=correo.getText().toString();
                String Constraseñaaa=contraseña.getText().toString();
               if(correooo.equals("a") && Constraseñaaa.equals("a") ){
                    startActivity(new Intent(Login.this,MenuAdmin.class));
                    finish();
                                    }
                else {
                   Toast.makeText(Login.this, "a", Toast.LENGTH_SHORT).show();
               }
            }
        });


    }
}
