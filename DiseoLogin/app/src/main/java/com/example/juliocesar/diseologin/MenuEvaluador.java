package com.example.juliocesar.diseologin;

import android.annotation.SuppressLint;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuEvaluador extends AppCompatActivity {
    Button evaluaraplicacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_evaluador);
        evaluaraplicacion = findViewById(R.id.evaluaraplicacion);


        evaluaraplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuEvaluador.this, Eficiencia.class));
                finish();
            }
        });

    }
}

