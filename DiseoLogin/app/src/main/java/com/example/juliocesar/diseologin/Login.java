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
    EditText et_correo,et_constraseña;
    String bdcorreo,bdcontraseña,correooo,Constraseñaaa;
    DataHelper dataHelper;
    protected Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dataHelper = new DataHelper(this);

        btn_ir_crearCuenta=findViewById(R.id.btn_ir_crearCuenta);
        iniciar_sesion=(Button) findViewById(R.id.iniciar_sesion);
        et_correo=(EditText) findViewById(R.id.et_correo);
        et_constraseña=(EditText) findViewById(R.id.et_contrasena);

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
                if(et_correo.length()== 0  ){
                    et_correo.setError("Correo es obligatorio");
                    et_correo.requestFocus();
                }if( et_constraseña.length()== 0 ){
                    et_constraseña.setError("Contraseña es obligatorio");
                    et_constraseña.requestFocus();
                }else {
                    correooo=et_correo.getText().toString();
                    Constraseñaaa=et_constraseña.getText().toString();

                    et_correo = (EditText) findViewById(R.id.et_correo);
                    String name = et_correo.getText().toString();

                    Intent mIntent = getIntent();
                    et_correo.setText(mIntent.getStringExtra("correo"));

                    SQLiteDatabase db = dataHelper.getReadableDatabase();
                    Bundle bundle = getIntent().getExtras();
                    cursor = db.rawQuery("SELECT * FROM tb_evaluador WHERE correo = '"+name+"'", null);
                    cursor.moveToFirst();
                    if(cursor.moveToFirst()==true) {
                        bdcorreo = (cursor.getString(3).toString());
                        bdcontraseña = (cursor.getString(4).toString());
                        if (correooo.equals(bdcorreo) && Constraseñaaa.equals(bdcontraseña)) {
                            startActivity(new Intent(Login.this, MenuAdmin.class));
                            finish();
                        } else{
                            Toast.makeText(Login.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(Login.this, "Correo no existe", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
