package com.example.juliocesar.diseologin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailAdminActivity extends AppCompatActivity {

    TextView tvid,tvnombre,tvtelefono,tvcorreo,tvcontraseña;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_evaluador);


        //Initializing Views
        tvid = findViewById(R.id.txtid);
        tvnombre = findViewById(R.id.txtnombre);
        tvtelefono = findViewById(R.id.txttelefono);
        tvcorreo = findViewById(R.id.txtcorreo);
        tvcontraseña = findViewById(R.id.txtcontraseña);

        Intent intent =getIntent();
        position = intent.getExtras().getInt("position");

        tvid.setText("ID: "+CrudEvaluador.employeeArrayList.get(position).getId());
        tvnombre.setText("Nombre: "+CrudEvaluador.employeeArrayList.get(position).getNombre());
        tvtelefono.setText("Telefono "+CrudEvaluador.employeeArrayList.get(position).getTelefono());
        tvcorreo.setText("Correo: "+CrudEvaluador.employeeArrayList.get(position).getCorreo());
        tvcontraseña.setText("Contraseña: "+CrudEvaluador.employeeArrayList.get(position).getContraseña());



    }
}
