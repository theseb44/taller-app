package com.example.tallerapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {


    public Button salirR;
    public Button matematicaR;
    public Button fisicaR;
    public Button textoR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        salirR = findViewById(R.id.salir);
        matematicaR = findViewById(R.id.matematica);
        fisicaR = findViewById(R.id.fisico);
        textoR = findViewById(R.id.texto);

        salirR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(menu);
            }
        });

        matematicaR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MenuActivity.this, Modulo_matematicoActivity.class);
                startActivity(menu);
            }
        });

        fisicaR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MenuActivity.this, Modulo_fisicoActivity.class);
                startActivity(menu);
            }
        });

        textoR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MenuActivity.this, Modulo_textoActivity.class);
                startActivity(menu);
            }
        });
    }
}