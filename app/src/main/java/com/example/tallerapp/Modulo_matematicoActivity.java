package com.example.tallerapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Modulo_matematicoActivity extends AppCompatActivity {

    private EditText editTextA, editTextB, editTextC;
    private Button botonCalcular;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulo_matematico);

        editTextA = findViewById(R.id.a);
        editTextB = findViewById(R.id.b);
        editTextC = findViewById(R.id.c);
        botonCalcular = findViewById(R.id.button);
        textViewResultado = findViewById(R.id.resultado);

        botonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateRoots(v);
            }
        });
    }

    public void calculateRoots(View view) {
        try {
            double a = Double.parseDouble(editTextA.getText().toString());
            double b = Double.parseDouble(editTextB.getText().toString());
            double c = Double.parseDouble(editTextC.getText().toString());

            double discriminant = b * b - 4 * a * c;

            if (discriminant >= 0) {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

                String result = "Raíz 1: " + root1 + "\nRaíz 2: " + root2;
                textViewResultado.setText(result);
            } else {
                textViewResultado.setText( "El discriminante es negativo. No existen raíces reales.");
            }
        } catch (NumberFormatException e) {
            textViewResultado.setText("Ingrese coeficientes válidos.");
        }
    }
}
