package com.example.cooper_up.pulsables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cooper_up.R;
import com.example.cooper_up.mains.MainActivity;
import com.example.cooper_up.models.AlumnoModel;
import com.example.cooper_up.models.OfertaModel;
import com.example.cooper_up.models.PracticaModel;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PracticaPulsar extends AppCompatActivity {

    // Declarar los TextViews y el Button
    private TextView nombrePracticaPulsarTV;
    private TextView nombreEmpresaPulsarTV;
    private TextView descripcionPracticaPulsarTV;
    private Button aplicarPracticaButton;
    private PracticaModel practica;
    private AlumnoModel alumno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica_pulsar);


        // Inicializar los TextViews y el Button
        nombrePracticaPulsarTV = findViewById(R.id.nombrePracticaPulsarTV);
        nombreEmpresaPulsarTV = findViewById(R.id.nombreEmpresaPulsarTV);
        descripcionPracticaPulsarTV = findViewById(R.id.descripcionPracticaPulsarTV);
        aplicarPracticaButton = findViewById(R.id.aplicarPracticaButton);

        //retrofit
        ApiAdapter apiAdapter = ApiAdapter.getInstance();

        ApiService apiService = apiAdapter.getApiService();

        OfertaModel oferta = new OfertaModel();
        //ahora hay uqe crear la oferta que le vas a pasar al Call


        // Obtener el objeto PracticaModel del Intent
        if (getIntent() != null && getIntent().hasExtra("practica")) {
            practica = (PracticaModel) getIntent().getSerializableExtra("practica");

            // Usar los valores de PracticaModel para actualizar los TextViews
            if (practica != null) {
                nombrePracticaPulsarTV.setText(practica.getTitulo_practica());
                descripcionPracticaPulsarTV.setText(practica.getDescripcion());
            }
        }

        SharedPreferences sharedPref = this.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
        int idAlumno = sharedPref.getInt("idAlumno", 1);
        // Inicializar el ImageButton
        ImageButton volverHomeButton = findViewById(R.id.volverHomeTV);

        // Aquí puedes añadir los listeners y cualquier otra lógica que necesites
        volverHomeButton.setOnClickListener(v -> {
            // Lógica para volver al Home (puede ser finish() para cerrar la actividad actual)
            Intent intent = new Intent(PracticaPulsar.this, MainActivity.class);
            //finish();
        });

        oferta.setId_practica(practica.getId());
        oferta.setId_estudiante(idAlumno);

        aplicarPracticaButton.setOnClickListener(v -> {

            Call<OfertaModel> call = apiService.solicitarPractica(oferta);

            call.enqueue(new Callback<OfertaModel>() {
                @Override
                public void onResponse(Call<OfertaModel> call, Response<OfertaModel> response) {
                    Toast.makeText(PracticaPulsar.this, "Práctica solicitada correctamente", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<OfertaModel> call, Throwable t) {
                    Toast.makeText(PracticaPulsar.this, "Error al solicitar", Toast.LENGTH_SHORT).show();

                }
            });
        });
    }
}
