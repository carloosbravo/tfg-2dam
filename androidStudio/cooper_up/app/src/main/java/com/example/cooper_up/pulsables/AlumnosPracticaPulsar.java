package com.example.cooper_up.pulsables;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.cooper_up.R;
import com.example.cooper_up.adapters.RValumnos;
import com.example.cooper_up.mains.MainActivityEmpresa;
import com.example.cooper_up.models.AlumnoModel;
import com.example.cooper_up.models.EmpresaModelo;
import com.example.cooper_up.models.PracticaModel;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlumnosPracticaPulsar extends AppCompatActivity {
    private PracticaModel practica;
    private EmpresaModelo empresa;

    private RecyclerView recyclerView;
    private ArrayList<AlumnoModel> itemList = new ArrayList<>();
    private RValumnos adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos_practica_pulsar);

        ImageButton volverBtn = findViewById(R.id.volver);

        // Obtener el objeto PracticaModel del Intent
        if (getIntent() != null) {
            practica = (PracticaModel) getIntent().getSerializableExtra("practica");
            empresa = (EmpresaModelo) getIntent().getSerializableExtra("empresa");
        }

        recyclerView = findViewById(R.id.recyclerViewAlumnosPractica);
        itemList = new ArrayList<>();
        adapter = new RValumnos(this, itemList,empresa);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiAdapter apiAdapter = ApiAdapter.getInstance();
        ApiService apiService = apiAdapter.getApiService();

        volverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlumnosPracticaPulsar.this, MainActivityEmpresa.class);
                intent.putExtra("empresa", empresa);
                startActivity(intent);
            }
        });

        Call<List<AlumnoModel>> call = apiService.alumnosPractica(practica.getId());

        call.enqueue(new Callback<List<AlumnoModel>>() {
            @Override
            public void onResponse(Call<List<AlumnoModel>> call, Response<List<AlumnoModel>> response) {
                List<AlumnoModel> listaAlumnosPractica = response.body();
                adapter.actualizarLista(listaAlumnosPractica);
            }

            @Override
            public void onFailure(Call<List<AlumnoModel>> call, Throwable t) {
                // Manejar el error aquí
            }
        });
    }
}
