package com.example.juliocesar.diseologin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.juliocesar.diseologin.database.DataHelper;


public class EditEvaluador extends AppCompatActivity {

    DataHelper dataHelper;
    protected Cursor cursor;
    DataHelper dbHelper;
    EditText id_blog,edt_nombre,edt_telefono,edt_correo,edt_contraseña;
    Button updateData,deleteData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_evaluador);

        //datos detallados
        dataHelper = new DataHelper(this);
        id_blog = (EditText) findViewById(R.id.id_blog);
        Intent mIntent = getIntent();
        id_blog.setText(mIntent.getStringExtra("id"));

        SQLiteDatabase db = dataHelper.getReadableDatabase();
        Bundle bundle = getIntent().getExtras();
        cursor = db.rawQuery("SELECT id," +
                "nombre," +
                "telefono," +
                "correo," +
                "contraseña FROM tb_evaluador " +
                "WHERE id = '" +
                mIntent.getStringExtra("id") + "'",null);
        cursor.moveToFirst();

        id_blog = (EditText)findViewById(R.id.id_blog);
        id_blog.setText(cursor.getString(0).toString());

        edt_nombre = (EditText)findViewById(R.id.edt_nombre);
        edt_nombre.setText(cursor.getString(1).toString());

        edt_telefono = (EditText)findViewById(R.id.edt_telefono);
        edt_telefono.setText(cursor.getString(2).toString());

        edt_correo = (EditText)findViewById(R.id.edt_correo);
        edt_correo.setText(cursor.getString(3).toString());

        edt_contraseña = (EditText)findViewById(R.id.edt_contraseña);
        edt_contraseña.setText(cursor.getString(4).toString());

        //actualizar datos
        dbHelper = new DataHelper(this);
        updateData = (Button) findViewById(R.id.updateData);
        updateData.setOnClickListener(new View.OnClickListener() {
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
                    db.execSQL("update tb_evaluador set nombre='" +
                            edt_nombre.getText().toString() + "', telefono='" +
                            edt_telefono.getText().toString() + "', correo='" +
                            edt_correo.getText().toString() + "', contraseña='" +
                            edt_contraseña.getText().toString() + "' where id='" +
                            id_blog.getText().toString() + "'");
                    Toast.makeText(getApplicationContext(), "Update Data", Toast.LENGTH_LONG).show();
                    CrudEvaluador.ma.getBlog();
                    finish();
                }
            }
        });

        //Eliminar datos
        deleteData = (Button) findViewById(R.id.deleteData);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("DELETE FROM tb_evaluador WHERE id ='"+id_blog.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Delete Data", Toast.LENGTH_LONG).show();
                CrudEvaluador.ma.getBlog();
                finish();
            }
        });
    }
}
