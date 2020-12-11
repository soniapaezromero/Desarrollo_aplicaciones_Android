package com.example.desarrollo_aplicaciones_android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.desarrollo_aplicaciones_android.databinding.ActivityEjercicio2Binding;

public class Ejercicio2 extends AppCompatActivity  implements  View.OnClickListener{
    private ActivityEjercicio2Binding binding;
    private Web pagina;
    private String direccion;
    Button navegador;
    Button actividad;
    EditText direccionWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);
        navegador=(Button)findViewById(R.id.botonNavegador);
        actividad= (Button)findViewById(R.id.botonActividad);
        direccionWeb=(EditText)findViewById(R.id.direccion);
        navegador.setOnClickListener(this);
        actividad .setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if ( view == navegador) {
            String url = direccionWeb.getText().toString();
            if (url != null && !url.isEmpty()) {
                Intent intentWeb = new Intent();
                intentWeb.setAction(Intent.ACTION_VIEW);
                intentWeb.setData(Uri.parse("http://" + url));
                startActivity(intentWeb);
            } else {
                Toast.makeText(this, "Error al lanzar el intent", Toast.LENGTH_SHORT).show();
            }
        }
        if( view == actividad){
            String url = direccionWeb.getText().toString();
            Intent intento= new Intent(this,MiWebView.class);
            intento.putExtra("direccion",url);
            startActivity(intento);
        }

    }

    }

