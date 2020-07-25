package com.example.juliocesar.diseologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class Eficiencia extends AppCompatActivity {
    Button siguiente;
    private Spinner  tiempoinicio,tiemporespuesta,numerodeevaluaciones,calculartiemporespuesta,consumoram,
            consumomedram,consumomaxram,calculoram,consumocpu,consumomedcpu,consumomaxcpu,calculocpu,canticonsumida,
            consumomedbateria,calculobateria,esfuerzo,completartarea,calculoesfuerzo,efectividadrelativatarea,costototal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eficiencia);
        siguiente = findViewById(R.id.eficiencia);
        tiempoinicio=(Spinner) findViewById(R.id.spinneraplicacion);
        tiemporespuesta=(Spinner) findViewById(R.id.spinneraplicacion);
        numerodeevaluaciones=(Spinner) findViewById(R.id.spinneraplicacion);
        calculartiemporespuesta=(Spinner) findViewById(R.id.spinneraplicacion);
        consumoram=(Spinner) findViewById(R.id.spinneraplicacion);
        consumomedram=(Spinner) findViewById(R.id.spinneraplicacion);
        consumomaxram=(Spinner) findViewById(R.id.spinneraplicacion);
        calculoram=(Spinner) findViewById(R.id.spinneraplicacion);
        consumocpu=(Spinner) findViewById(R.id.spinneraplicacion);
        consumomedcpu=(Spinner) findViewById(R.id.spinneraplicacion);
        consumomaxcpu=(Spinner) findViewById(R.id.spinneraplicacion);
        calculocpu=(Spinner) findViewById(R.id.spinneraplicacion);
        canticonsumida=(Spinner) findViewById(R.id.spinneraplicacion);
        consumomedbateria=(Spinner) findViewById(R.id.spinneraplicacion);
        calculobateria=(Spinner) findViewById(R.id.spinneraplicacion);
        esfuerzo=(Spinner) findViewById(R.id.spinneraplicacion);
        completartarea=(Spinner) findViewById(R.id.spinneraplicacion);
        calculoesfuerzo=(Spinner) findViewById(R.id.spinneraplicacion);
        efectividadrelativatarea=(Spinner) findViewById(R.id.spinneraplicacion);
        costototal=(Spinner) findViewById(R.id.spinneraplicacion);


        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Eficiencia.this, Eficacia.class));
                finish();
            }
        });

    }
}