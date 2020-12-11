package com.example.desarrollo_aplicaciones_android;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.desarrollo_aplicaciones_android.databinding.ActivityEjercicio1Binding;

public class Ejercicio1 extends AppCompatActivity implements View.OnClickListener {
    private ActivityEjercicio1Binding binding;
    private Contador contador;
    private static final int  BREAK = 5;
    private ContadorDescendiente contadorMenos;
    private static MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
        binding =ActivityEjercicio1Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        contador= new Contador(0,BREAK);
        binding.tiempo.setText(BREAK +":00");
        binding.botonMenosTiempo.setOnClickListener(this);
        binding.botonMastiempo.setOnClickListener(this);
        binding.botonComenzar.setOnClickListener(this);
        binding.botonReiniciar.setOnClickListener(this);
        mediaPlayer = MediaPlayer.create(this, R.raw.cuckoo_clock);





    }

    @Override
    public void onClick(View view) {
        if(view == binding.botonMenosTiempo){
        binding.tiempo.setText(contador.reducirTiempo());
        }
        if(view == binding.botonMastiempo){
            binding.tiempo.setText(contador.aumentarTiempo());
        }
        if (view == binding.botonReiniciar) {
            binding.cafesTomar.setText(contador.contadorCero());
            binding.botonMenosTiempo.setEnabled(true);
            binding.botonMastiempo.setEnabled(true);
            binding.botonComenzar.setEnabled(true);
            binding.botonReiniciar.setEnabled(false);
        }
        if (view == binding.botonComenzar) {
            int cafesTomados= Integer.parseInt(String.valueOf(binding.cafesTomar.getText()));
            if( cafesTomados >=10){
                AlertDialog.Builder popup=new AlertDialog.Builder(this);
                popup.setTitle("Fin");
                popup.setMessage("Has superado el número de cafes diarios");
                popup.setPositiveButton("Ok", null);
                popup.show();
                binding.tiempo.setEnabled(false);
                binding.botonMenosTiempo.setEnabled(false);
                binding.botonMastiempo.setEnabled(false);
                binding.botonComenzar.setEnabled(false);
                binding .botonReiniciar.setEnabled(true);
            }else{
                contadorMenos = new ContadorDescendiente(contador.getTiempo() * 60 * 1000, 1000);
                contadorMenos.start();
                binding.botonMenosTiempo.setEnabled(false);
                binding.botonMastiempo.setEnabled(false);
                binding.botonComenzar.setEnabled(false);
                binding.botonReiniciar.setEnabled(false);

            }
        }

        }
        public class ContadorDescendiente extends CountDownTimer {
            public ContadorDescendiente(long startTime, long interval) {
                super(startTime, interval);
            }

            @Override
            public void onTick(long millisUntilFinished) {
                long min, seg;
                min = (millisUntilFinished / 1000) / 60;
                seg = (millisUntilFinished / 1000) % 60;
                binding.tiempo.setText(min + ":" + String.format("%02d", seg));
                if (seg == 5){
                    mediaPlayer.start();
                }
            }
            @Override
            public void onFinish() {
                mediaPlayer.stop();
                Toast.makeText(Ejercicio1.this, "Pausa terminada", Toast.LENGTH_SHORT).show();
                binding.tiempo.setText(contador.getTiempo() + ":00");
                binding.cafesTomar.setText(contador.aumentarCafes());
                binding.botonMenosTiempo.setEnabled(true);
                binding.botonMastiempo.setEnabled(true);
                binding.botonComenzar.setEnabled(true);
            }
        }

    }





