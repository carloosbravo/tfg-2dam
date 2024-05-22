package com.example.cooper_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cooper_up.models.AlumnoModel;

public class AlumnoPulsar extends AppCompatActivity {

    AlumnoModel alumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_pulsar);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("alumno")) {
            alumno = (AlumnoModel) intent.getSerializableExtra("alumno");
        }

        TextView nombreAlumno = findViewById(R.id.nombreAlumnoPulsarTV);
        TextView correoAlumno = findViewById(R.id.correoAlumnoPulsarTV);
        TextView telefonoAlumno = findViewById(R.id.telefonoAlumnoPulsarTV);

        nombreAlumno.setText(alumno.getNombre().toString());
        correoAlumno.setText(alumno.getEmail().toString());
        telefonoAlumno.setText(alumno.getTelefono().toString());

    }
}