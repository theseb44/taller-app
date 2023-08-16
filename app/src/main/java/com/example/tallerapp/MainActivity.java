package com.example.tallerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public EditText user;
    public EditText password;
    public Button ingresar;
    public Button cancelar;
    public CheckBox terminos;
    public ProgressBar barraDeCarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.usuario);
        password = findViewById(R.id.contraseña);
        ingresar = (Button) findViewById(R.id.ingresar);
        cancelar = (Button) findViewById(R.id.cancelar);
        terminos = (CheckBox) findViewById(R.id.checkTerminos);
        barraDeCarga = (ProgressBar) findViewById(R.id.barra);
        ingresar.setEnabled(false);
        cancelar.setEnabled(false);
        barraDeCarga.setVisibility(View.INVISIBLE);


        terminos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ingresar.setEnabled(true);
                    cancelar.setEnabled(true);
                    ingresar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(userPasswordValidator(user.getText().toString(), password.getText().toString())){
                                progressBar(barraDeCarga, v);
                            }else{
                                Toast.makeText(getApplicationContext(), "el usuario o la contraseña son incorrectos", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                    cancelar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            user.setText("");
                            password.setText("");
                        }
                    });
                } else {
                    ingresar.setEnabled(false);
                    cancelar.setEnabled(false);
                }
            }
        });
    }

    public void progressBar( ProgressBar barra, View v){


        barra.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goToMenu(v);
            }
        }, 2000);
    }

    public void goToMenu(View view) {
        Intent menu = new Intent(MainActivity.this, MenuActivity.class);
        startActivity(menu);
    }
    public boolean userPasswordValidator(String user , String password){
        if(user.equals("Admin") && password.equals("admin123")){
            return true;
        }
        return false;
    }


}