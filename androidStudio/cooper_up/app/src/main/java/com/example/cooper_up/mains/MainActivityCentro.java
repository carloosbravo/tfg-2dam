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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_centro);



        CentroModelo centro = new CentroModelo();

        if (getIntent() != null && getIntent().hasExtra("centro")) {
            centro = (CentroModelo) getIntent().getSerializableExtra("centro");
        }

        TextView nombreCentro = findViewById(R.id.TVnombreEmpresa);
        TextView correoCentro = findViewById(R.id.correoCentro);
        TextView direccionCentro = findViewById(R.id.direccionCentro);
        TextView telefonoCentro = findViewById(R.id.telefonoEmpresa);
        TextView contrasenaCentro = findViewById(R.id.contraCentro);

        Button btnAdd = findViewById(R.id.btnAddAlumno);
        Button btnShow = findViewById(R.id.btnVerAlumnos);



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityCentro.this, RegistrarAlumno.class);
                startActivity(intent);

            }
        });


        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityCentro.this, VerAlumnos.class);
                startActivity(intent);
            }
        });

        nombreCentro.setText(centro.getNombre().toString());
        correoCentro.setText(centro.getEmail().toString());
        direccionCentro.setText(centro.getDireccion().toString());
        telefonoCentro.setText(centro.getTelefono().toString());
        contrasenaCentro.setText(centro.getContraseña().toString());




    }

}