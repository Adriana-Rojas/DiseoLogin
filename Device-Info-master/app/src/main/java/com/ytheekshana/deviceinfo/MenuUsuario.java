package com.ytheekshana.deviceinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuUsuario extends AppCompatActivity {
    Button btnregistrardatos,verinforme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);

        btnregistrardatos = findViewById(R.id.registrardatos);
        verinforme = findViewById(R.id.verinforme);

        btnregistrardatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuUsuario.this,DatosAplicativo.class));
                finish();
            }
        });
        verinforme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuUsuario.this,Select_Evaluados.class));
                finish();
            }
        });
    }
}
