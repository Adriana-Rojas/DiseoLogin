package com.example.juliocesar.diseologin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuAdmin extends AppCompatActivity {


    Button crudusuario,crudevaluador,asignarreportes,verreportes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);

        crudusuario=findViewById(R.id.crudusuario);
        crudevaluador=findViewById(R.id.crudevaluador);
        asignarreportes=findViewById(R.id.asignarreportes);
        verreportes=findViewById(R.id.verreportes);



        crudusuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuAdmin.this,CrudUsuario.class));
                finish();
            }
        });


        crudevaluador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuAdmin.this,CrudEvaluador.class));
                finish();
            }
        });

        asignarreportes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuAdmin.this,AsignarReportes.class));
                finish();
            }
        });

        verreportes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuAdmin.this,VerReporte.class));
                finish();
            }
        });

    }
}
