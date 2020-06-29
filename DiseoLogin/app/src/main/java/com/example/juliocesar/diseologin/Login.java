package com.example.juliocesar.diseologin;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.juliocesar.diseologin.database.DataHelper;

public class Login extends AppCompatActivity {

    Button btn_ir_crearCuenta,iniciar_sesion;
     EditText correod,contraseñad;
     String bdcorreo,bdcontraseña;
    DataHelper dataHelper;
    protected Cursor cursor;
    DataHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_ir_crearCuenta=findViewById(R.id.btn_ir_crearCuenta);
        iniciar_sesion=(Button) findViewById(R.id.iniciar_sesion);
        correod=(EditText) findViewById(R.id.et_correo);
        contraseñad=(EditText) findViewById(R.id.et_contrasena);
        DataHelper admin = new DataHelper(this);
        final SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();


        btn_ir_crearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,AddUsuario.class));
                finish();
            }
        });


        iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                // if(!codigo.isEmpty()){
                Cursor fila = BaseDeDatabase.rawQuery
                        ("select * from tb_evaluador WHERE correo = correo", null);

                if(fila.moveToFirst()){
                    bdcorreo=(fila.getString(3));
                    bdcontraseña=(fila.getString(4));
                    // correod.setText(fila.getString(0));
                    //contraseñad.setText(fila.getString(1));
                    BaseDeDatabase.close();
                } else {
                 //   Toast.makeText(this,"No existe el artículo", Toast.LENGTH_SHORT).show();
                    BaseDeDatabase.close();
                }

                if(correod.length()== 0 & contraseñad.length()== 0 ){
                    Toast.makeText(Login.this, "no puede haber campos vacios", Toast.LENGTH_SHORT).show();
                }
                String correooo=correod.getText().toString();
                String Constraseñaaa=contraseñad.getText().toString();
               if(correooo.equals(bdcorreo) && Constraseñaaa.equals(bdcontraseña) ){
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
