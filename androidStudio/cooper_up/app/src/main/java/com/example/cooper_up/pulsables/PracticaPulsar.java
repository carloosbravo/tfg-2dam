package com.example.cooper_up.pulsables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cooper_up.R;
import com.example.cooper_up.mains.MainActivity;
import com.example.cooper_up.models.AlumnoModel;
import com.example.cooper_up.models.EmpresaModelo;
import com.example.cooper_up.models.OfertaModel;
import com.example.cooper_up.models.PracticaModel;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

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

            Call<EmpresaModelo> call = apiService.getEmpresaId(practica.getId_empresa());

            call.enqueue(new Callback<EmpresaModelo>() {
                @Override
                public void onResponse(Call<EmpresaModelo> call, Response<EmpresaModelo> response) {
                    EmpresaModelo empresaPractica = response.body();
                    nombreEmpresaPulsarTV.setText(empresaPractica.getNombre());
                }

                @Override
                public void onFailure(Call<EmpresaModelo> call, Throwable t) {

                }
            });


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
            startActivity(intent);
        });

        oferta.setId_practica(practica.getId());
        oferta.setId_estudiante(idAlumno);

        Call<List<PracticaModel>> call = apiService.getPracticasByIdAlumno(idAlumno);

        call.enqueue(new Callback<List<PracticaModel>>() {
            @Override
            public void onResponse(Call<List<PracticaModel>> call, Response<List<PracticaModel>> response) {
                List<PracticaModel> listapracticas = response.body();

                for(int i = 0; i<listapracticas.size(); i++){
                    if(listapracticas.get(i).getId().equals(practica.getId())){
                        aplicarPracticaButton.setText("Quitar solicitud");
                        aplicarPracticaButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Call<Void> calldelete = apiService.deleteOferta(practica.getId(), idAlumno);
                                calldelete.enqueue(new Callback() {
                                    @Override
                                    public void onResponse(Call call, Response response) {
                                        Toast.makeText(PracticaPulsar.this, "Has quitado la solicitud", Toast.LENGTH_SHORT).show();
                                        aplicarPracticaButton.setText("Solicitar práctica");
                                        Intent intent = new Intent(PracticaPulsar.this, MainActivity.class);
                                        startActivity(intent);
                                    }

                                    @Override
                                    public void onFailure(Call call, Throwable t) {
                                        Toast.makeText(PracticaPulsar.this, "ADIOS", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }
                        });

                    }else {

                        aplicarPracticaButton.setOnClickListener(v -> {

                            Call<OfertaModel> call1 = apiService.solicitarPractica(oferta);

                            call1.enqueue(new Callback<OfertaModel>() {
                                @Override
                                public void onResponse(Call<OfertaModel> call, Response<OfertaModel> response) {
                                    Toast.makeText(PracticaPulsar.this, "Práctica solicitada correctamente", Toast.LENGTH_SHORT).show();
                                    aplicarPracticaButton.setText("Practica solicitada");
                                }

                                @Override
                                public void onFailure(Call<OfertaModel> call, Throwable t) {
                                    Toast.makeText(PracticaPulsar.this, "Error al solicitar", Toast.LENGTH_SHORT).show();

                                }
                            });
                        });

                    }
                }
            }

            @Override
            public void onFailure(Call<List<PracticaModel>> call, Throwable t) {

            }
        });


    }
}
