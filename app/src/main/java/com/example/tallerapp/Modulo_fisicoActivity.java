package com.example.tallerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Modulo_fisicoActivity extends AppCompatActivity {

    private EditText editTextVelocidad, editTextTiempo;
    private Button botonCalcularDistancia;
    private TextView textViewResultadoDistancia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulo_fisico);

        editTextVelocidad = findViewById(R.id.velocidad);
        editTextTiempo = findViewById(R.id.tiempo);
        botonCalcularDistancia = findViewById(R.id.boton);
        textViewResultadoDistancia = findViewById(R.id.resultadoFisica);

        botonCalcularDistancia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularDistancia();
            }
        });
    }

    private void calcularDistancia() {
        double velocidad = Double.parseDouble(editTextVelocidad.getText().toString());
        double tiempo = Double.parseDouble(editTextTiempo.getText().toString());

        double distancia = velocidad * tiempo;
        textViewResultadoDistancia.setText("Distancia: " + distancia);
    }
}
