package com.example.cooper_up;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.cooper_up.adapters.RVpracticasEliminar;
import com.example.cooper_up.adapters.RVpracticasEmpresa;
import com.example.cooper_up.mains.MainActivityEmpresa;
import com.example.cooper_up.models.EmpresaModelo;
import com.example.cooper_up.models.PracticaModel;
import com.example.cooper_up.pulsables.AlumnoPulsar;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EliminarPractica extends AppCompatActivity {
    private EmpresaModelo empresa;
    private RecyclerView recyclerView;
    private ArrayList<PracticaModel> itemList = new ArrayList<>();
    private RVpracticasEliminar adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_practica);

        // Recuperar el objeto empresa del intent
        empresa = (EmpresaModelo) getIntent().getSerializableExtra("empresa");

        recyclerView = findViewById(R.id.recyclerViewEliminarPractica);
        itemList = new ArrayList<>();
        adapter = new RVpracticasEliminar(this, itemList,empresa);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageButton btnVolver = findViewById(R.id.volverBtn);

        ApiAdapter apiAdapter = ApiAdapter.getInstance();
        ApiService apiService = apiAdapter.getApiService();

        Call<List<PracticaModel>> call = apiService.getPracticasByIdEmpresa(empresa.getId());

        call.enqueue(new Callback<List<PracticaModel>>() {
            @Override
            public void onResponse(Call<List<PracticaModel>> call, Response<List<PracticaModel>> response) {
                if(response.isSuccessful()){
                    List<PracticaModel> practicasEmpresa = response.body();

                    adapter.actualizarLista(practicasEmpresa);
                }
            }

            @Override
            public void onFailure(Call<List<PracticaModel>> call, Throwable t) {
                Log.e("Error", "Error al obtener las practicas: " + t.getMessage());

            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EliminarPractica.this, MainActivityEmpresa.class);
                intent.putExtra("empresa", empresa);
                startActivity(intent);
            }
        });
    }

}