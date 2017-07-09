package com.rresto.aleatorio;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Constantes
    final static long delayMillis = 3000; //3 Segundos

    //Variables
    NumberPicker numberPicker;
    ProgressBar progressBar;
    Button button;
    TextView numeroElegido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Conectamos controles
        numberPicker = (NumberPicker) findViewById(R.id.numberPicker);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        numeroElegido = (TextView) findViewById(R.id.textViewNumeroElegido);

        //Ajustamos los controles
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(100);
        numberPicker.setValue(3);

        progressBar.setVisibility(View.INVISIBLE);
        numeroElegido.setVisibility(View.INVISIBLE);


    }

    public void MyClickButton(View target) {

        /*
        //Elijo número aleatorio
        int rangoNumero = numberPicker.getValue();
        int numero = (int) (Math.random() *rangoNumero) + 1;
        */

        //Pongo pausa
        progressBar.setVisibility(View.VISIBLE);
        numeroElegido.setVisibility(View.INVISIBLE);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after long ms

                //Elijo número aleatorio
                int rangoNumero = numberPicker.getValue();
                int numero = (int) (Math.random() *rangoNumero) + 1;
                progressBar.setVisibility(View.INVISIBLE);

                //Activo el texto
                String stringNumeroElegido= getString (R.string.elNumeroElegidoEs) + String.valueOf(numero);
                numeroElegido.setText(stringNumeroElegido);
                numeroElegido.setVisibility(View.VISIBLE);
            }
        }, delayMillis);

        /*
        progressBar.setVisibility(View.INVISIBLE);

        //Activo el texto
        String stringNumeroElegido = "El número elegido es: " + String.valueOf(numero);
        numeroElegido.setText(stringNumeroElegido);
        numeroElegido.setVisibility(View.VISIBLE);
        */
    }
}
