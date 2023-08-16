package com.example.tallerapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Modulo_textoActivity extends AppCompatActivity {

    private EditText editTextTexto;
    private CheckBox checkBoxNegrita, checkBoxCursiva;
    private Button botonAumentar, botonDisminuir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulo_texto);

        editTextTexto = findViewById(R.id.textoMod);
        checkBoxNegrita = findViewById(R.id.negrilla);
        checkBoxCursiva = findViewById(R.id.cursiva);
        botonAumentar = findViewById(R.id.aumentar);
        botonDisminuir = findViewById(R.id.disminuir);

        botonAumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aumentarTamanoTexto();
            }
        });

        botonDisminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disminuirTamanoTexto();
            }
        });
        checkBoxNegrita.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                aplicarFormato();
            }
        });
        checkBoxCursiva.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                aplicarFormato();
            }
        });
    }

    private void aumentarTamanoTexto() {
        float actualSize = editTextTexto.getTextSize();
        editTextTexto.setTextSize(actualSize + 2);
    }

    private void disminuirTamanoTexto() {
        float actualSize = editTextTexto.getTextSize();
        editTextTexto.setTextSize(actualSize - 2);
    }

    private void aplicarFormato() {
        String textoOriginal = editTextTexto.getText().toString();

        SpannableStringBuilder builder = new SpannableStringBuilder(textoOriginal);

        if (checkBoxNegrita.isChecked()) {
            builder.setSpan(new TextAppearanceSpan(null, Typeface.BOLD, -1, null, null), 0, builder.length(), 0);
        }

        if (checkBoxCursiva.isChecked()) {
            builder.setSpan(new TextAppearanceSpan(null, Typeface.ITALIC, -1, null, null), 0, builder.length(), 0);
        }
        editTextTexto.setText(builder);
    }
}