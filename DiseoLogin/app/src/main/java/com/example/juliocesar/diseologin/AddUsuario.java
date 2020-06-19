package com.example.juliocesar.diseologin;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into tb_blog(nombre,telefono,correo,contraseña) values('" + edt_nombre.getText().toString() + "','" + edt_telefono.getText().toString() + "','" + edt_correo.getText().toString() + "','" + edt_contraseña.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Insert Data", Toast.LENGTH_LONG).show();
                CrudUsuario.ma.getBlog();
                finish();

            }
        });
    }
}

