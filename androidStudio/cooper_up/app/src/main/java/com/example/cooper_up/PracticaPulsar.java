package com.example.cooper_up;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.cooper_up.models.PracticaModel;

public class PracticaPulsar extends AppCompatActivity {

    // Declarar los TextViews y el Button
    private TextView nombrePracticaPulsarTV;
    private TextView nombreEmpresaPulsarTV;
    private TextView descripcionPracticaPulsarTV;
    private Button aplicarPracticaButton;
    private PracticaModel practica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica_pulsar);

        // Inicializar los TextViews y el Button
        nombrePracticaPulsarTV = findViewById(R.id.nombrePracticaPulsarTV);
        nombreEmpresaPulsarTV = findViewById(R.id.nombreEmpresaPulsarTV);
        descripcionPracticaPulsarTV = findViewById(R.id.descripcionPracticaPulsarTV);
        aplicarPracticaButton = findViewById(R.id.aplicarPracticaButton);

        // Obtener el objeto PracticaModel del Intent
        if (getIntent() != null && getIntent().hasExtra("practica")) {
            practica = (PracticaModel) getIntent().getSerializableExtra("practica");

            // Usar los valores de PracticaModel para actualizar los TextViews
            if (practica != null) {
                nombrePracticaPulsarTV.setText(practica.getTitulo_practica());
                descripcionPracticaPulsarTV.setText(practica.getDescripcion());
            }
        }

        // Inicializar el ImageButton
        ImageButton volverHomeButton = findViewById(R.id.volverHomeTV);

        // Aquí puedes añadir los listeners y cualquier otra lógica que necesites
        volverHomeButton.setOnClickListener(v -> {
            // Lógica para volver al Home (puede ser finish() para cerrar la actividad actual)
            finish();
        });

        aplicarPracticaButton.setOnClickListener(v -> {
            // Lógica para aplicar a la práctica (puede ser abrir una nueva actividad, enviar datos, etc.)
        });
    }
}
