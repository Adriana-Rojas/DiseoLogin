package com.example.juliocesar.diseologin;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.juliocesar.diseologin.database.DataHelper;

public class AddUsuario extends AppCompatActivity {


    protected Cursor cursor;
    DataHelper dbHelper;
    Button btnSave;
    EditText edt_nombre,edt_telefono,edt_correo,edt_contraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_usuario);

        dbHelper = new DataHelper(this);
        edt_nombre = (EditText) findViewById (R.id.edt_nombre);
        edt_telefono = (EditText) findViewById(R.id.edt_telefono);
        edt_correo = (EditText) findViewById(R.id.edt_correo);
        edt_contraseña = (EditText) findViewById(R.id.edt_contraseña);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                //valiadciones
                if(edt_nombre.length()== 0  ){
                    edt_nombre.setError("Nombre es obligatorio");
                    edt_nombre.requestFocus();
                }if( edt_telefono.length()== 0 ){
                    edt_telefono.setError("Telefono es obligatorio");
                    edt_telefono.requestFocus();
                } if(edt_correo.length()== 0  ){
                    edt_correo.setError("Correo es obligatorio");
                    edt_correo.requestFocus();
                } if( edt_contraseña.length()== 0 ){
                    edt_contraseña.setError("Contraseña es obligatorio");
                    edt_contraseña.requestFocus();
                }
//todo correcto
                else {
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL("insert into tb_blog(nombre,telefono,correo,contraseña) values('" + edt_nombre.getText().toString() + "','" + edt_telefono.getText().toString() + "','" + edt_correo.getText().toString() + "','" + edt_contraseña.getText().toString() + "')");
                    Toast.makeText(getApplicationContext(), "Insert Data", Toast.LENGTH_LONG).show();
                    CrudUsuario.ma.getBlog();
                    finish();
                }

            }
        });
    }
}

