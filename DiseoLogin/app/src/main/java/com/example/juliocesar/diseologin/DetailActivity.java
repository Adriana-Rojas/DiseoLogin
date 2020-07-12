package com.example.juliocesar.diseologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tvid,tvnombre,tvtelefono,tvcorreo,tvcontraseña;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        //Initializing Views
        tvid = findViewById(R.id.txtid);
        tvnombre = findViewById(R.id.txtnombre);
        tvtelefono = findViewById(R.id.txttelefono);
        tvcorreo = findViewById(R.id.txtcorreo);
        tvcontraseña = findViewById(R.id.txtcontraseña);

        Intent intent =getIntent();
        position = intent.getExtras().getInt("position");

        tvid.setText("ID: "+CrudUsuario.employeeArrayList.get(position).getId());
        tvnombre.setText("Nombre: "+CrudUsuario.employeeArrayList.get(position).getNombre());
        tvtelefono.setText("Telefono "+CrudUsuario.employeeArrayList.get(position).getTelefono());
        tvcorreo.setText("Correo: "+CrudUsuario.employeeArrayList.get(position).getCorreo());
        tvcontraseña.setText("Contraseña: "+CrudUsuario.employeeArrayList.get(position).getContraseña());



    }
}
