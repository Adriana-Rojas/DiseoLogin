package com.ytheekshana.deviceinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuEvaluador extends AppCompatActivity {
    Button evaluaraplicacion,verresultados,evitarevaluacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_evaluador);
        evaluaraplicacion = findViewById(R.id.evaluaraplicacion);
        verresultados = findViewById(R.id.verresultados);
        evitarevaluacion = findViewById(R.id.evitarevaluacion);

        evaluaraplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuEvaluador.this, Select_Apk.class));//Select_Apk
                finish();
            }
        });
        verresultados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuEvaluador.this, Select_Apk.class));//ojo
                finish();
            }
        });
        evitarevaluacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuEvaluador.this, Select_Apk.class));//ojo
                finish();
            }
        });

    }
}

