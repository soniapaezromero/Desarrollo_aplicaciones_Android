package com.example.desarrollo_aplicaciones_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button ejercicio1;
    Button ejercicio2;
    Button ejercicio3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ejercicio1=(Button)findViewById(R.id.ejercicio1);
        ejercicio2= (Button)findViewById(R.id.ejercicio2);
        ejercicio3= (Button)findViewById(R.id.ejercicio3);
        ejercicio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento =new Intent(v.getContext(),Ejercicio1.class);
                startActivityForResult(intento,0);
            }
        });
        ejercicio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento =new Intent(v.getContext(),Ejercicio2.class);
                startActivityForResult(intento,0);
            }
        });
        ejercicio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento =new Intent(v.getContext(),Ejercicio3.class);
                startActivityForResult(intento,0);
            }
        });
    }
}