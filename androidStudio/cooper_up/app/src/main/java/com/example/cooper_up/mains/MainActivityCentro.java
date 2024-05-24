package com.example.cooper_up.mains;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cooper_up.R;
import com.example.cooper_up.RegistrarAlumno;
import com.example.cooper_up.VerAlumnos;
import com.example.cooper_up.models.CentroModelo;

public class MainActivityCentro extends AppCompatActivity {

    private CentroModelo centro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_centro);




        centro = (CentroModelo) getIntent().getSerializableExtra("centro");


        TextView nombreCentro = findViewById(R.id.TVnombreEmpresa);
        TextView correoCentro = findViewById(R.id.correoCentro);
        TextView direccionCentro = findViewById(R.id.direccionCentro);
        TextView telefonoCentro = findViewById(R.id.telefonoEmpresa);
        TextView contrasenaCentro = findViewById(R.id.contraCentro);

        Button btnAdd = findViewById(R.id.btnAddAlumno);
        Button btnShow = findViewById(R.id.btnVerAlumnos);

        // Set the text for TextViews
        nombreCentro.setText(centro.getNombre());
        correoCentro.setText(centro.getEmail());
        direccionCentro.setText(centro.getDireccion());
        telefonoCentro.setText(centro.getTelefono());
        contrasenaCentro.setText(centro.getContraseña());

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityCentro.this, RegistrarAlumno.class);
                intent.putExtra("centro", centro); // Add the CentroModelo object to the Intent
                startActivity(intent);
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityCentro.this, VerAlumnos.class);
                intent.putExtra("centro", centro); // Add the CentroModelo object to the Intent
                startActivity(intent);
            }
        });
    }
}
