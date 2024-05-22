package com.example.cooper_up;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cooper_up.adapters.RValumnos;
import com.example.cooper_up.models.AlumnoModel;
import com.example.cooper_up.models.PracticaModel;

import java.util.ArrayList;

public class AlumnosPracticaPulsar extends AppCompatActivity {
    private PracticaModel practica;
    private RecyclerView recyclerView;
    private ArrayList<AlumnoModel>itemList = new ArrayList<>();
    private RValumnos adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos_practica_pulsar);

        // Obtener el objeto PracticaModel del Intent
        if (getIntent() != null && getIntent().hasExtra("practica")) {
            practica = (PracticaModel) getIntent().getSerializableExtra("practica");

        }
    }
}