package com.example.cooper_up;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Cuenta extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cuenta);

        Button btnAlumno = findViewById(R.id.btnAlumno);
        Button btnCentro = findViewById(R.id.btnCentro);
        Button btnEmpresa = findViewById(R.id.btnEmpresa);

        btnAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Cuenta.this, LoginAlumno.class);
                startActivity(intent);
            }
        });

        btnCentro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Cuenta.this, LoginCentro.class);
                startActivity(intent);
            }
        });

        btnEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción al hacer clic en Empresa
                Intent intent = new Intent(Cuenta.this, LoginEmpresa.class);
                startActivity(intent);
            }
        });
    }
}
