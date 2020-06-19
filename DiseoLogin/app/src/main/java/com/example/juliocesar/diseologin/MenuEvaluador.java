package com.example.juliocesar.diseologin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuEvaluador extends AppCompatActivity {

    Button listaraplicacion,evaluaraplicacion;
    ImageButton imageView;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_evaluador);

        imageView=findViewById(R.id.imageView);
        listaraplicacion=findViewById(R.id.listaraplicacion);
        evaluaraplicacion=findViewById(R.id.evaluaraplicacion);


        listaraplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuEvaluador.this,ListarAplicaciones.class));
                finish();
            }
        });


        evaluaraplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuEvaluador.this,Eficiencia.class));
                finish();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuEvaluador.this,Login.class));
                finish();
            }
        });

    }
}

