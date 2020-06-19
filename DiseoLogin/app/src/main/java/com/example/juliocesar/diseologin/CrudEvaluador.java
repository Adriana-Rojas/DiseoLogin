package com.example.juliocesar.diseologin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CrudEvaluador extends AppCompatActivity {
    Button crearevaluador,editarevaluador,eliminarevaluadoro,verevaluadores;
    ImageButton imageView;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_evaluador);

        crearevaluador=findViewById(R.id.crearevaluador);
        editarevaluador=findViewById(R.id.editarevaluador);
        eliminarevaluadoro=findViewById(R.id.eliminarevaluadoro);
        verevaluadores=findViewById(R.id.verevaluadores);
        imageView=findViewById(R.id.imageView);



        crearevaluador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CrudEvaluador.this,CrudEvaluador.class));
                finish();
            }
        });


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CrudEvaluador.this,Login.class));
                finish();
            }
        });


    }
}
