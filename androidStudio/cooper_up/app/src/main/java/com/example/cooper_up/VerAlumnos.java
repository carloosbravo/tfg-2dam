package com.example.cooper_up;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.cooper_up.adapters.RValumnos;
import com.example.cooper_up.adapters.RVpracticas;
import com.example.cooper_up.models.AlumnoModel;
import com.example.cooper_up.models.PracticaModel;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerAlumnos extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<AlumnoModel> itemList = new ArrayList<>();

    RValumnos adapter;

    AlumnoModel alumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_alumnos);

        recyclerView = findViewById(R.id.recyclerAlumno);
        adapter = new RValumnos(this, itemList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiAdapter apiAdapter = ApiAdapter.getInstance();
        ApiService apiService = apiAdapter.getApiService();

        Call<List<AlumnoModel>> call = apiService.getAllAlumnos();

        call.enqueue(new Callback<List<AlumnoModel>>() {
            @Override
            public void onResponse(Call<List<AlumnoModel>> call, Response<List<AlumnoModel>> response) {
                if (response.isSuccessful()) {
                    List<AlumnoModel> allAlumnos = response.body();
                    Log.d("Alumnos", "Lista de Alumnos: " + allAlumnos.toString());
                    adapter.actualizarLista(allAlumnos);
                }
            }

            @Override
            public void onFailure(Call<List<AlumnoModel>> call, Throwable t) {
                Log.e("Error", "Error al obtener los alumnos: " + t.getMessage());

            }
        });
    }
}