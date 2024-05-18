package com.example.cooper_up;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class PracticaPulsar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica_pulsar);

        //pulsar para volver al home
        ImageButton volverHomeButton = findViewById(R.id.volverHomeTV);
    }
}